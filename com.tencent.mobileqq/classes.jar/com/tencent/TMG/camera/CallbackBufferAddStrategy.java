package com.tencent.TMG.camera;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.TMG.utils.QLog;

public class CallbackBufferAddStrategy
{
  static final String TAG = "CallbackBufferAddStrategy";
  CameraCaptureSettings mCameraCaptureSettings;
  private boolean mIsUseBuffer;
  
  private int getPreviewFrameCount()
  {
    if ((Build.MODEL != null) && (Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (this.mCameraCaptureSettings.width == 1280) && (this.mCameraCaptureSettings.height == 720)) {
      return 3;
    }
    return 2;
  }
  
  public void fistAdd(Camera paramCamera)
  {
    if (paramCamera == null) {
      QLog.e("CallbackBufferAddStrategy", 0, "fistAdd, camera == null");
    }
    while (this.mCameraCaptureSettings.format != 17) {
      return;
    }
    int i = getPreviewFrameCount();
    QLog.i("CallbackBufferAddStrategy", 0, "previewFrameCount = " + i);
    if ((i != 2) && (i != 3))
    {
      QLog.e("CallbackBufferAddStrategy", 0, "previewFrameCount error");
      return;
    }
    int j = this.mCameraCaptureSettings.width * this.mCameraCaptureSettings.height * 3 / 2;
    if (i == 2) {}
    for (;;)
    {
      try
      {
        arrayOfByte1 = new byte[j];
        arrayOfByte2 = new byte[j];
        paramCamera.addCallbackBuffer(arrayOfByte1);
        paramCamera.addCallbackBuffer(arrayOfByte2);
        this.mIsUseBuffer = true;
      }
      catch (Exception paramCamera)
      {
        byte[] arrayOfByte1;
        byte[] arrayOfByte2;
        byte[] arrayOfByte3;
        QLog.e("CallbackBufferAddStrategy", 0, "previewFrameCount error", paramCamera);
        this.mIsUseBuffer = false;
        continue;
      }
      QLog.e("CallbackBufferAddStrategy", 0, "fistAdd, len =  " + j + "is use buffer = " + this.mIsUseBuffer);
      return;
      arrayOfByte1 = new byte[j];
      arrayOfByte2 = new byte[j];
      arrayOfByte3 = new byte[j];
      paramCamera.addCallbackBuffer(arrayOfByte1);
      paramCamera.addCallbackBuffer(arrayOfByte2);
      paramCamera.addCallbackBuffer(arrayOfByte3);
    }
  }
  
  public boolean getIsUseBuffer()
  {
    return this.mIsUseBuffer;
  }
  
  public void setCameraCaptureSettings(CameraCaptureSettings paramCameraCaptureSettings)
  {
    this.mCameraCaptureSettings = paramCameraCaptureSettings;
    this.mIsUseBuffer = false;
  }
  
  public void supplement(Camera paramCamera, byte[] paramArrayOfByte)
  {
    if (paramCamera == null) {
      QLog.e("CallbackBufferAddStrategy", 0, "supplement, camera == null");
    }
    while (!this.mIsUseBuffer) {
      return;
    }
    int i = this.mCameraCaptureSettings.width * this.mCameraCaptureSettings.height * 3 / 2;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < i))
    {
      paramCamera.addCallbackBuffer(new byte[i]);
      return;
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.camera.CallbackBufferAddStrategy
 * JD-Core Version:    0.7.0.1
 */