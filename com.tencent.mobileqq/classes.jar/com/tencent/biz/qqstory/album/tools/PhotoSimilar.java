package com.tencent.biz.qqstory.album.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;

public class PhotoSimilar
{
  public static double a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 != null)
    {
      if (paramBitmap2 == null) {
        return 0.0D;
      }
      if (paramBitmap1.getWidth() == paramBitmap2.getWidth())
      {
        if (paramBitmap1.getHeight() != paramBitmap2.getHeight()) {
          return 0.0D;
        }
        int i = a(b(paramBitmap1));
        int j = a(b(paramBitmap2));
        return a(a(paramBitmap1, i), a(paramBitmap2, j), paramBitmap1.getWidth(), paramBitmap1.getHeight());
      }
    }
    return 0.0D;
  }
  
  private static double a(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    double d1 = 0.0D;
    int i = 0;
    while (i < paramInt1)
    {
      int j = 0;
      while (j < paramInt2)
      {
        d2 = d1;
        if (paramArrayOfInt1[i][j] != paramArrayOfInt2[i][j]) {
          d2 = d1 + 1.0D;
        }
        j += 1;
        d1 = d2;
      }
      i += 1;
    }
    double d2 = paramInt1 * paramInt2;
    Double.isNaN(d2);
    return 1.0D - d1 / d2;
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[256];
    int m = 0;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    i = 0;
    for (int j = 0; i < paramArrayOfByte.length; j = k)
    {
      n = paramArrayOfByte[i] & 0xFF;
      arrayOfInt[n] += 1;
      k = j;
      if (arrayOfInt[n] > j) {
        k = arrayOfInt[n];
      }
      i += 1;
    }
    int n = paramArrayOfByte.length;
    i = 0;
    float f1 = 0.0F;
    while (i < 256)
    {
      f1 += arrayOfInt[i] * i;
      i += 1;
    }
    int k = 0;
    float f4 = 0.0F;
    float f2 = 0.0F;
    j = 0;
    i = m;
    while (i < 256)
    {
      k += arrayOfInt[i];
      float f3;
      if (k == 0)
      {
        f3 = f2;
      }
      else
      {
        m = n - k;
        if (m == 0) {
          return j;
        }
        float f5 = f4 + arrayOfInt[i] * i;
        f3 = k;
        float f6 = f5 / f3;
        f4 = m;
        f6 -= (f1 - f5) / f4;
        f6 = f3 * f4 * f6 * f6;
        f4 = f5;
        f3 = f2;
        if (f6 > f2)
        {
          j = i;
          f3 = f6;
          f4 = f5;
        }
      }
      i += 1;
      f2 = f3;
    }
    return j;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap.getWidth() <= 50)
    {
      localBitmap = paramBitmap;
      if (paramBitmap.getHeight() <= 50) {}
    }
    else
    {
      localBitmap = a(paramBitmap, 50, 50);
    }
    return c(localBitmap);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
  }
  
  private static int[][] a(Bitmap paramBitmap, int paramInt)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
    int i = 0;
    while (i < paramBitmap.getWidth())
    {
      int j = 0;
      while (j < paramBitmap.getHeight())
      {
        if (Color.red(paramBitmap.getPixel(i, j)) > paramInt) {
          arrayOfInt[i][j] = 1;
        } else {
          arrayOfInt[i][j] = 0;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static byte[] b(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramBitmap.getByteCount());
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static Bitmap c(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int[] arrayOfInt = new int[k * m];
    paramBitmap.getPixels(arrayOfInt, 0, k, 0, 0, k, m);
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < k)
      {
        int n = k * i + j;
        int i1 = arrayOfInt[n];
        double d1 = (0xFF0000 & i1) >> 16;
        Double.isNaN(d1);
        double d2 = (0xFF00 & i1) >> 8;
        Double.isNaN(d2);
        double d3 = i1 & 0xFF;
        Double.isNaN(d3);
        i1 = (int)(d1 * 0.3D + d2 * 0.59D + d3 * 0.11D);
        arrayOfInt[n] = (i1 | i1 << 16 | 0xFF000000 | i1 << 8);
        j += 1;
      }
      i += 1;
    }
    paramBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.RGB_565);
    paramBitmap.setPixels(arrayOfInt, 0, k, 0, 0, k, m);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSimilar
 * JD-Core Version:    0.7.0.1
 */