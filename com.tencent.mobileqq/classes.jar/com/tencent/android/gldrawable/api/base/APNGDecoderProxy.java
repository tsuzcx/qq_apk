package com.tencent.android.gldrawable.api.base;

import android.graphics.Bitmap;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IConfigStub;
import java.lang.reflect.Method;

public class APNGDecoderProxy
{
  public static final int NOT_VALID_FRAME = -1;
  private static Method nativeFreeFrame;
  private static Method nativeFreeImage;
  private static Method nativeGetNextFrame;
  private static Method nativeStartDecode;
  
  static
  {
    try
    {
      System.loadLibrary("APNG");
    }
    catch (Throwable localThrowable1)
    {
      GLDrawableApi.config().log("can not find libAPNG.so", localThrowable1);
    }
    try
    {
      Class localClass = Class.forName("com.tencent.image.ApngImage");
      nativeGetNextFrame = localClass.getDeclaredMethod("nativeGetNextFrame", new Class[] { Long.TYPE, Long.TYPE, Bitmap.class, [I.class });
      nativeGetNextFrame.setAccessible(true);
      nativeStartDecode = localClass.getDeclaredMethod("nativeStartDecode", new Class[] { String.class, [I.class, Integer.TYPE });
      nativeStartDecode.setAccessible(true);
      nativeFreeImage = localClass.getDeclaredMethod("nativeFreeImage", new Class[] { Long.TYPE });
      nativeFreeImage.setAccessible(true);
      nativeFreeFrame = localClass.getDeclaredMethod("nativeFreeFrame", new Class[] { Long.TYPE });
      nativeFreeFrame.setAccessible(true);
      return;
    }
    catch (Throwable localThrowable2)
    {
      GLDrawableApi.config().log("can not find method", localThrowable2);
    }
  }
  
  public static void freeFrame(long paramLong)
  {
    try
    {
      nativeFreeFrame.invoke(null, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Throwable localThrowable)
    {
      GLDrawableApi.config().log("freeFrame", localThrowable);
    }
  }
  
  public static void freeImage(long paramLong)
  {
    try
    {
      nativeFreeImage.invoke(null, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Throwable localThrowable)
    {
      GLDrawableApi.config().log("freeImage", localThrowable);
    }
  }
  
  public static long getNextFrame(long paramLong1, long paramLong2, Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    try
    {
      paramLong1 = ((Long)nativeGetNextFrame.invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBitmap, paramArrayOfInt })).longValue();
      return paramLong1;
    }
    catch (Throwable paramBitmap)
    {
      GLDrawableApi.config().log("getNextFrame", paramBitmap);
    }
    return -1L;
  }
  
  public static long startDecode(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      long l = ((Long)nativeStartDecode.invoke(null, new Object[] { paramString, paramArrayOfInt, Integer.valueOf(paramInt) })).longValue();
      return l;
    }
    catch (Throwable paramString)
    {
      GLDrawableApi.config().log("startDecode", paramString);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.APNGDecoderProxy
 * JD-Core Version:    0.7.0.1
 */