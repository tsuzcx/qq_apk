package com.tencent.TMG.sdk;

import android.graphics.Bitmap;
import android.hardware.Camera.Parameters;
import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.VcSystemInfo;
import java.nio.ByteBuffer;

public class AVVideoCtrl
{
  public static final int AVPresetType1280720 = 6;
  public static final int AVPresetType192144 = 7;
  public static final int AVPresetType320180 = 8;
  public static final int AVPresetType320240 = 1;
  public static final int AVPresetType480360 = 2;
  public static final int AVPresetType640368 = 4;
  public static final int AVPresetType640480 = 3;
  public static final int AVPresetType960540 = 5;
  public static final int BACK_CAMERA = 1;
  public static final int CAMERA_MODE_AUTO_SENDING = 1;
  public static final int CAMERA_MODE_DEFAULT = 0;
  public static final int CAMERA_MODE_NOT_SENDING = 2;
  public static final int EXTERNAL_FORMAT_ABGR = 11;
  public static final int EXTERNAL_FORMAT_ARGB = 9;
  public static final int EXTERNAL_FORMAT_I420 = 0;
  public static final int EXTERNAL_FORMAT_NV12 = 3;
  public static final int EXTERNAL_FORMAT_NV21 = 1;
  public static final int EXTERNAL_FORMAT_RGB24 = 8;
  public static final int EXTERNAL_FORMAT_RGB565 = 7;
  public static final int EXTERNAL_FORMAT_RGBA = 10;
  public static final int FRONT_CAMERA = 0;
  public static final int SCREEN_HIGH_DEFINITION = 2;
  public static final int SCREEN_STANDARD_DEFINITION = 3;
  public static final int SCREEN_SUPER_DEFINITION = 1;
  public static final String TAG = "AVVideoCtrl";
  static int[] timeArray = new int[2];
  public int nativeObj = 0;
  
  private native int enableCameraPreview(int paramInt, boolean paramBoolean, AVVideoCtrl.EnableCameraCompleteCallback paramEnableCameraCompleteCallback);
  
  private native int enableCameraSendPermission(boolean paramBoolean);
  
  private native void initNative(int paramInt);
  
  public static boolean isEnableBeauty()
  {
    QLog.d("AVVideoCtrl", 0, "isEnable = " + VcSystemInfo.isBeautySupported());
    return VcSystemInfo.isBeautySupported();
  }
  
  private native int nativeAddWatermark(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  private native int nativeFillExternalCaptureFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private native int nativeFillExternalScreenFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private native boolean nativeSetLocalVideoPreProcessCallback(AVVideoCtrl.LocalVideoPreProcessCallback paramLocalVideoPreProcessCallback);
  
  private native void unInitNative();
  
  public int addWatermark(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt < 1) || (paramInt > 8))
    {
      QLog.d("AVVideoCtrl", 0, "AVPresetType error");
      return 1004;
    }
    if (paramBitmap == null)
    {
      QLog.d("AVVideoCtrl", 0, "bitmap null");
      return 1004;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return nativeAddWatermark(paramInt, arrayOfInt, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public void deleteTime()
  {
    if (timeArray != null) {
      timeArray = null;
    }
  }
  
  public int enableCamera(int paramInt1, boolean paramBoolean, int paramInt2, AVVideoCtrl.EnableCameraCompleteCallback paramEnableCameraCompleteCallback)
  {
    switch (paramInt2)
    {
    default: 
      return 1004;
    case 0: 
    case 1: 
      return enableCamera(paramInt1, paramBoolean, paramEnableCameraCompleteCallback);
    }
    return enableCameraPreview(paramInt1, paramBoolean, paramEnableCameraCompleteCallback);
  }
  
  public native int enableCamera(int paramInt, boolean paramBoolean, AVVideoCtrl.EnableCameraCompleteCallback paramEnableCameraCompleteCallback);
  
  public native int enableExternalCapture(boolean paramBoolean1, boolean paramBoolean2, AVVideoCtrl.EnableExternalCaptureCompleteCallback paramEnableExternalCaptureCompleteCallback);
  
  public native int enableScreen(boolean paramBoolean, int paramInt, AVVideoCtrl.EnableScreenCompleteCallback paramEnableScreenCompleteCallback);
  
  public int fillExternalCaptureFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return nativeFillExternalCaptureFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public int fillScreenFrame(AVVideoCtrl.VideoFrameWithByteBuffer paramVideoFrameWithByteBuffer)
  {
    return nativeFillExternalScreenFrame(paramVideoFrameWithByteBuffer.data, paramVideoFrameWithByteBuffer.dataLen, paramVideoFrameWithByteBuffer.stride, paramVideoFrameWithByteBuffer.width, paramVideoFrameWithByteBuffer.height, paramVideoFrameWithByteBuffer.rotate, paramVideoFrameWithByteBuffer.videoFormat, paramVideoFrameWithByteBuffer.srcType);
  }
  
  public native Object getCamera();
  
  public native Object getCameraHandler();
  
  public native int getCameraNum();
  
  public native Object getCameraPara();
  
  public int getFilterTime()
  {
    int i = 0;
    if (timeArray != null) {
      i = timeArray[0];
    }
    return i;
  }
  
  public int getPendantTime()
  {
    if (timeArray != null) {
      return timeArray[1];
    }
    return 0;
  }
  
  public native String getQualityTips();
  
  void init(int paramInt)
  {
    initNative(paramInt);
  }
  
  public native int initCameraSetting(int paramInt1, int paramInt2, int paramInt3);
  
  public native int initCameraSettingWithControlRole(String paramString);
  
  public native void inputBeautyParam(float paramFloat);
  
  public native void inputWhiteningParam(float paramFloat);
  
  public void resetTime()
  {
    if (timeArray != null)
    {
      QLog.d("AVVideoCtrl", 0, "resetEffectTime");
      timeArray[0] = 0;
      timeArray[1] = 0;
    }
  }
  
  public native void setAfterPreviewListener(AVVideoCtrl.AfterPreviewListener paramAfterPreviewListener);
  
  public native void setCameraPara(Camera.Parameters paramParameters);
  
  public native void setCameraPreviewChangeCallback(AVVideoCtrl.CameraPreviewChangeCallback paramCameraPreviewChangeCallback);
  
  public native int setHwEnableFlag(int paramInt1, int paramInt2);
  
  public boolean setLocalVideoPreProcessCallback(AVVideoCtrl.LocalVideoPreProcessCallback paramLocalVideoPreProcessCallback)
  {
    return nativeSetLocalVideoPreProcessCallback(paramLocalVideoPreProcessCallback);
  }
  
  @Deprecated
  public native boolean setLocalVideoPreviewCallback(AVVideoCtrl.LocalVideoPreviewCallback paramLocalVideoPreviewCallback);
  
  public native boolean setLocalVideoPreviewCallbackWithByteBuffer(AVVideoCtrl.LocalVideoPreviewCallbackWithByteBuffer paramLocalVideoPreviewCallbackWithByteBuffer);
  
  public native boolean setRemoteMediaVideoPreviewCallback(AVVideoCtrl.RemoteMediaVideoPreviewCallback paramRemoteMediaVideoPreviewCallback);
  
  public native boolean setRemoteScreenVideoPreviewCallback(AVVideoCtrl.RemoteScreenVideoPreviewCallback paramRemoteScreenVideoPreviewCallback);
  
  @Deprecated
  public native boolean setRemoteVideoPreviewCallback(AVVideoCtrl.RemoteVideoPreviewCallback paramRemoteVideoPreviewCallback);
  
  public native boolean setRemoteVideoPreviewCallbackWithByteBuffer(AVVideoCtrl.RemoteVideoPreviewCallbackWithByteBuffer paramRemoteVideoPreviewCallbackWithByteBuffer);
  
  public native void setRotation(int paramInt);
  
  native int setUseSurfaceTexture(boolean paramBoolean);
  
  public native int switchCamera(int paramInt, AVVideoCtrl.SwitchCameraCompleteCallback paramSwitchCameraCompleteCallback);
  
  void unInit()
  {
    unInitNative();
  }
  
  public int updateCameraMode(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      return 1004;
    }
    switch (paramInt2)
    {
    default: 
      return 1004;
    case 0: 
    case 1: 
      return enableCameraSendPermission(true);
    }
    return enableCameraSendPermission(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVVideoCtrl
 * JD-Core Version:    0.7.0.1
 */