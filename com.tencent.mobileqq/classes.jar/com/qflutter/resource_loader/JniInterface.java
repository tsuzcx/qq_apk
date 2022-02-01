package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

public class JniInterface
{
  static final String TAG = "SkinEngineJniInterface";
  
  public static long getBitmapPixelDataMemoryPtr(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return 0L;
    }
    try
    {
      long l = nativeGetBitmapPixelDataMemoryPtr(paramBitmap);
      return l;
    }
    catch (Throwable paramBitmap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapPixelDataMemoryPtr error:");
      localStringBuilder.append(paramBitmap.getMessage());
      Log.e("SkinEngineJniInterface", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static long getByteBufferPtr(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return 0L;
    }
    try
    {
      long l = nativeGetByteBufferPtr(paramByteBuffer);
      return l;
    }
    catch (Throwable paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getByteBufferPtr error:");
      localStringBuilder.append(paramByteBuffer.getMessage());
      Log.e("SkinEngineJniInterface", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static native long nativeGetBitmapPixelDataMemoryPtr(Bitmap paramBitmap);
  
  public static native long nativeGetByteBufferPtr(ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.resource_loader.JniInterface
 * JD-Core Version:    0.7.0.1
 */