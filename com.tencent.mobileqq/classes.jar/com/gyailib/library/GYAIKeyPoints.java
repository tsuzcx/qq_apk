package com.gyailib.library;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;

public class GYAIKeyPoints
{
  public static final int TYPE_CAT = 1;
  public static final int TYPE_FULL_BODY = 2;
  private long nativePtr;
  
  public native int cleanupModelData();
  
  public native int forwardDetect(Bitmap paramBitmap, GYDetectCommonResultStruct paramGYDetectCommonResultStruct, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig);
  
  public int initInstance(SDKDeviceConfig paramSDKDeviceConfig, int paramInt)
  {
    if (paramInt == 2)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type_full_body", "true");
      paramSDKDeviceConfig.setInfos(localHashMap);
    }
    return initInstance(paramSDKDeviceConfig);
  }
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIKeyPoints
 * JD-Core Version:    0.7.0.1
 */