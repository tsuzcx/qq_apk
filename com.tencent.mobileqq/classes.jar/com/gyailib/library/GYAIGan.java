package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAIGan
{
  private long nativePtr;
  
  public native int cleanupModelData();
  
  public native Bitmap forward(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig, SDKGanConvertConfig paramSDKGanConvertConfig);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIGan
 * JD-Core Version:    0.7.0.1
 */