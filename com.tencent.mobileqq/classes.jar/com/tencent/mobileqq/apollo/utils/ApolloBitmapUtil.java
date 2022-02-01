package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.qphone.base.util.QLog;

public class ApolloBitmapUtil
{
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = ((BitmapFactory.Options)localObject).outWidth;
        int j = ((BitmapFactory.Options)localObject).outHeight;
        if (i <= paramInt1) {
          if (j <= paramInt2) {
            break label151;
          }
        }
        paramInt1 = Math.min(Math.round(i / paramInt1), Math.round(j / paramInt2));
        ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        return paramString;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BitmapFactory.decodeFile failed:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("[cmshow]ApolloBitmapUtil", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloBitmapUtil", 2, paramString.getMessage());
        }
        return null;
      }
      label151:
      paramInt1 = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloBitmapUtil
 * JD-Core Version:    0.7.0.1
 */