package com.tencent.TMG.sdk;

import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.VcSystemInfo;

public class AVBeautyEngine
{
  static final String TAG = "SdkJni";
  private static boolean isEnableBeauty = false;
  private float mBeautyParam = 0.0F;
  private float mWhiteningParam = 0.0F;
  public int nativeObj = 0;
  
  public AVBeautyEngine()
  {
    if (AVSDKLibLoader.loadSdkLibrary())
    {
      nativeCreate();
      isEnableBeauty = isEnableBeauty();
    }
  }
  
  public static boolean isEnableBeauty()
  {
    QLog.d("SdkJni", 0, "isEnable = " + VcSystemInfo.isBeautySupported());
    return VcSystemInfo.isBeautySupported();
  }
  
  private native int nativeCreate();
  
  private native void nativeDestroy();
  
  private native void nativeInputBeautyParam(float paramFloat);
  
  private native void nativeInputWhiteningParam(float paramFloat);
  
  protected void finalize()
  {
    if (this.nativeObj != 0) {
      nativeDestroy();
    }
  }
  
  public float getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public float getWhiteningParam()
  {
    return this.mWhiteningParam;
  }
  
  public void inputBeautyParam(float paramFloat)
  {
    if ((isEnableBeauty) && (this.nativeObj != 0))
    {
      this.mBeautyParam = paramFloat;
      nativeInputBeautyParam(this.mBeautyParam);
    }
  }
  
  public void inputWhiteningParam(float paramFloat)
  {
    if ((isEnableBeauty) && (this.nativeObj != 0))
    {
      this.mWhiteningParam = paramFloat;
      nativeInputWhiteningParam(paramFloat);
    }
  }
  
  public native int nativeProcessExternalFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public int processExternalFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isEnableBeauty) {
      return nativeProcessExternalFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVBeautyEngine
 * JD-Core Version:    0.7.0.1
 */