package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAIDepth
{
  private long nativePtr;
  
  public native int cleanupModelData();
  
  public native Bitmap forwardSeg(Bitmap paramBitmap, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupSmootherWithConfig(SegmentSmoothConfig paramSegmentSmoothConfig);
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.GYAIDepth
 * JD-Core Version:    0.7.0.1
 */