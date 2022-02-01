package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAIFace
{
  private long nativePtr;
  
  public native int cleanupModelData();
  
  public native int forwardDetect(Bitmap paramBitmap, FaceDetector paramFaceDetector, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig);
  
  @Deprecated
  public native int registerFaceLicense(String paramString);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIFace
 * JD-Core Version:    0.7.0.1
 */