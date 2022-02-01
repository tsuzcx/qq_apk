package com.gyailib.library;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class GYAIFaceClassify
{
  private long nativePtr;
  
  static
  {
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("TNN");
      System.loadLibrary("light_ai_base");
      System.loadLibrary("light_detect_base");
      System.loadLibrary("light_face_classify");
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
  
  public native int forwardDetect(Bitmap paramBitmap, Rect paramRect, float[] paramArrayOfFloat, GYDetectCommonResultStruct paramGYDetectCommonResultStruct, int paramInt);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIFaceClassify
 * JD-Core Version:    0.7.0.1
 */