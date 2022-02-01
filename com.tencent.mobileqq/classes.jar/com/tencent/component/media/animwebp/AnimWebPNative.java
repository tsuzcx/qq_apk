package com.tencent.component.media.animwebp;

import com.tencent.component.media.utils.ImageManagerLog;
import java.nio.ByteBuffer;

public class AnimWebPNative
{
  private static final String TAG = "AnimWebPNative";
  private ByteBuffer currentFrameByteBuffer;
  private byte[] fileContentBytes;
  
  public AnimWebPNative(byte[] paramArrayOfByte)
  {
    this.fileContentBytes = paramArrayOfByte;
  }
  
  public static boolean isAnimWebP(byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool = nativeIsAnimWebP(paramArrayOfByte);
      return bool;
    }
    catch (Throwable paramArrayOfByte)
    {
      ImageManagerLog.e("AnimWebPNative", paramArrayOfByte.getMessage());
    }
    return false;
  }
  
  private native AnimWebPInfo nativeInit(byte[] paramArrayOfByte);
  
  private static native boolean nativeIsAnimWebP(byte[] paramArrayOfByte);
  
  private native AnimWebPInfo nativeNextFrame(ByteBuffer paramByteBuffer);
  
  private native void nativeRelease();
  
  public ByteBuffer getCurrentFrameByteBuffer()
  {
    return this.currentFrameByteBuffer;
  }
  
  public AnimWebPInfo initialize()
  {
    try
    {
      AnimWebPInfo localAnimWebPInfo = nativeInit(this.fileContentBytes);
      this.currentFrameByteBuffer = ByteBuffer.allocateDirect(localAnimWebPInfo.getCanvasWidth() * localAnimWebPInfo.getCanvasHeight() * 4);
      return localAnimWebPInfo;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("AnimWebPNative", localThrowable.getMessage());
    }
    return null;
  }
  
  public AnimWebPInfo nextFrame()
  {
    try
    {
      AnimWebPInfo localAnimWebPInfo = nativeNextFrame(this.currentFrameByteBuffer);
      return localAnimWebPInfo;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("AnimWebPNative", localThrowable.getMessage());
    }
    return null;
  }
  
  public void release()
  {
    try
    {
      nativeRelease();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("AnimWebPNative", localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.animwebp.AnimWebPNative
 * JD-Core Version:    0.7.0.1
 */