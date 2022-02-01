package com.tencent.biz.qqcircle.localphoto.scan.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.localphoto.scan.data.ExpandBufferedInputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;

public class Image2BitmapUtils
{
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int j = 1;
    int k = 1;
    int i = k;
    if (m <= paramInt2)
    {
      if (n <= paramInt1) {
        break label58;
      }
      i = k;
    }
    for (;;)
    {
      if (m / i < paramInt2)
      {
        j = i;
        if (n / i < paramInt1) {
          label58:
          return j;
        }
      }
      i *= 2;
    }
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int j = paramInt % 360;
    if (j == 0) {
      return paramBitmap;
    }
    int i;
    if (((j > 45) && (j < 135)) || ((j > 225) && (j < 315))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      paramInt = paramBitmap.getWidth();
    } else {
      paramInt = paramBitmap.getHeight();
    }
    if (i == 0) {
      i = paramBitmap.getHeight();
    } else {
      i = paramBitmap.getWidth();
    }
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt, i, paramBitmap.getConfig());
    }
    catch (Throwable localThrowable)
    {
      Bitmap localBitmap;
      label94:
      Canvas localCanvas;
      break label94;
    }
    localBitmap = null;
    if (localBitmap != null)
    {
      if (localBitmap == paramBitmap) {
        return paramBitmap;
      }
      localCanvas = new Canvas(localBitmap);
      paramInt = (paramInt - paramBitmap.getWidth()) / 2;
      i = (i - paramBitmap.getHeight()) / 2;
      if ((paramInt != 0) || (i != 0)) {
        localCanvas.translate(paramInt, i);
      }
      localCanvas.rotate(j, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      paramBitmap.recycle();
      return localBitmap;
    }
    return paramBitmap;
  }
  
  private static Bitmap a(Bitmap paramBitmap, String paramString)
  {
    Bitmap localBitmap1 = paramBitmap;
    Bitmap localBitmap2;
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramBitmap;
      }
      try
      {
        boolean bool = new File(paramString).exists();
        if (!bool) {
          return paramBitmap;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[processExif] image is not exist, path=");
        localStringBuilder.append(paramString);
        QLog.e("Image2BitmapUtils", 1, localStringBuilder.toString(), localThrowable);
        localBitmap2 = a(paramBitmap, JpegExifReader.a(paramString));
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(new ExpandBufferedInputStream(new FileInputStream(paramString), paramArrayOfByte), null, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((i > 0) && (j > 0))
      {
        int k = Math.max(i, j) / Math.min(i, j);
        if (k >= 4)
        {
          paramString = new StringBuilder();
          paramString.append("[decodeBitmap] error ratio, width=");
          paramString.append(i);
          paramString.append(", height=");
          paramString.append(j);
          paramString.append(", ratio=");
          paramString.append(k);
          QLog.e("Image2BitmapUtils", 1, paramString.toString());
          return null;
        }
        localOptions.inSampleSize = a(localOptions, paramInt, paramInt);
        localOptions.inJustDecodeBounds = false;
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        paramArrayOfByte = BitmapFactory.decodeStream(new ExpandBufferedInputStream(new FileInputStream(paramString), paramArrayOfByte), null, localOptions);
        if (QLog.isDevelopLevel()) {
          QLog.d("Image2BitmapUtils", 4, String.format(Locale.CHINESE, "[decodeBitmap] sampleSize=%d, originalWidth=%d, originalHeight=%d, scaledWidth=%d, scaledHeight=%d, filePath=%s", new Object[] { Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), paramString }));
        }
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isRecycled())) {
          return a(paramArrayOfByte, paramString);
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("[decodeBitmap] error size, width=");
        paramString.append(i);
        paramString.append(", height=");
        paramString.append(j);
        QLog.d("Image2BitmapUtils", 4, paramString.toString());
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Image2BitmapUtils", 1, "[decodeBitmap] failed", paramString);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("Image2BitmapUtils", 1, "[decodeBitmap] OOM", paramString);
      return null;
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.utils.Image2BitmapUtils
 * JD-Core Version:    0.7.0.1
 */