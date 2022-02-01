package com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.qphone.base.util.QLog;

public class ThumbnailUtils
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, true);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a = paramInt5;
    b = paramInt6;
    try
    {
      paramInt1 = TrimNative.prepare(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return paramInt1;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init failed:");
      localStringBuilder.append(Log.getStackTraceString(paramString));
      QLog.e("ThumbnailUtils", 1, localStringBuilder.toString());
    }
    return -444;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c = paramInt1;
    d = paramInt2;
    if (paramBoolean)
    {
      int i = c;
      int j = d;
      double d1;
      double d2;
      if (i > j)
      {
        c = 480;
        d1 = j;
        d2 = paramInt1;
        Double.isNaN(d2);
        d2 = d2 * 1.0D / 480.0D;
        Double.isNaN(d1);
        d = (int)(d1 / d2);
      }
      else
      {
        d = 480;
        d1 = i;
        d2 = paramInt2;
        Double.isNaN(d2);
        d2 = d2 * 1.0D / 480.0D;
        Double.isNaN(d1);
        c = (int)(d1 / d2);
      }
    }
    return TrimNative.initGetFrame(paramString, c, d);
  }
  
  public static Bitmap a(long paramLong1, long paramLong2)
  {
    int i = c;
    if (i > 0)
    {
      int j = d;
      if (j <= 0) {
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (TrimNative.getFrame(paramLong1, paramLong2, localBitmap) != 0)
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        return null;
      }
      return localBitmap;
    }
    return null;
  }
  
  public static Bitmap b(long paramLong1, long paramLong2)
  {
    int i = a;
    if (i > 0)
    {
      int j = b;
      if (j <= 0) {
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (TrimNative.getThumbnail(paramLong1, paramLong2, localBitmap) != 0)
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        return null;
      }
      return localBitmap;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils
 * JD-Core Version:    0.7.0.1
 */