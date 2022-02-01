package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.nativebmp.NativeBitmap;
import java.nio.ByteBuffer;

public class JniInterface
{
  static final String TAG = "JniInterface";
  
  public static long getBitmapPixelDataMemoryPtr(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return 0L;
      }
      try
      {
        long l = NativeBitmap.nativeGetBitmapPixelDataMemoryPtr(paramBitmap);
        return l;
      }
      catch (Throwable paramBitmap)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBitmapPixelDataMemoryPtr error:");
        localStringBuilder.append(paramBitmap.getMessage());
        Log.e("JniInterface", localStringBuilder.toString());
      }
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
      long l = NativeBitmap.nativeGetByteBufferPtr(paramByteBuffer);
      return l;
    }
    catch (Throwable paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getByteBufferPtr error:");
      localStringBuilder.append(paramByteBuffer.getMessage());
      Log.e("JniInterface", localStringBuilder.toString());
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.resource_loader.JniInterface
 * JD-Core Version:    0.7.0.1
 */