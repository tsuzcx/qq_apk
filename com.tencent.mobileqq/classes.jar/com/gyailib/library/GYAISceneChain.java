package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAISceneChain
{
  private long nativePtr;
  
  static
  {
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("opencv_world");
      System.loadLibrary("TNN");
      System.loadLibrary("light_ai_base");
      System.loadLibrary("light_detect_base");
      System.loadLibrary("light_detect_face");
      System.loadLibrary("light_detect_gender");
      System.loadLibrary("light_detect_scene_chain");
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public native int cleanupModelData();
  
  public native int forwardDetect(Bitmap paramBitmap, GYDetectCommonResultStruct paramGYDetectCommonResultStruct, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.GYAISceneChain
 * JD-Core Version:    0.7.0.1
 */