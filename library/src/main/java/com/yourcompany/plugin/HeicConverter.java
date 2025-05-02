package com.yourcompany.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

public class HeicConverter {
    public static String convertHeicToJpeg(String heicPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(heicPath);
            if (bitmap == null) return "";

            File outputFile = new File(Environment.getExternalStorageDirectory(), "converted_heic_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream out = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            return outputFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
