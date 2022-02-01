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
    if (paramCamera == null)
    {
      QLog.e("CallbackBufferAddStrategy", 0, "fistAdd, camera == null");
      return;
    }
    if (this.mCameraCaptureSettings.format == 17)
    {
      int i = getPreviewFrameCount();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("previewFrameCount = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("CallbackBufferAddStrategy", 0, ((StringBuilder)localObject).toString());
      if ((i != 2) && (i != 3))
      {
        QLog.e("CallbackBufferAddStrategy", 0, "previewFrameCount error");
        return;
      }
      int j = this.mCameraCaptureSettings.width * this.mCameraCaptureSettings.height * 3 / 2;
      if (i == 2) {}
      try
      {
        localObject = new byte[j];
        byte[] arrayOfByte1 = new byte[j];
        paramCamera.addCallbackBuffer((byte[])localObject);
        paramCamera.addCallbackBuffer(arrayOfByte1);
        break label167;
        localObject = new byte[j];
        arrayOfByte1 = new byte[j];
        byte[] arrayOfByte2 = new byte[j];
        paramCamera.addCallbackBuffer((byte[])localObject);
        paramCamera.addCallbackBuffer(arrayOfByte1);
        paramCamera.addCallbackBuffer(arrayOfByte2);
        label167:
        this.mIsUseBuffer = true;
      }
      catch (Exception paramCamera)
      {
        QLog.e("CallbackBufferAddStrategy", 0, "previewFrameCount error", paramCamera);
        this.mIsUseBuffer = false;
      }
      paramCamera = new StringBuilder();
      paramCamera.append("fistAdd, len =  ");
      paramCamera.append(j);
      paramCamera.append("is use buffer = ");
      paramCamera.append(this.mIsUseBuffer);
      QLog.e("CallbackBufferAddStrategy", 0, paramCamera.toString());
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
    if (paramCamera == null)
    {
      QLog.e("CallbackBufferAddStrategy", 0, "supplement, camera == null");
      return;
    }
    if (this.mIsUseBuffer)
    {
      int i = this.mCameraCaptureSettings.width * this.mCameraCaptureSettings.height * 3 / 2;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= i))
      {
        paramCamera.addCallbackBuffer(paramArrayOfByte);
        return;
      }
      paramCamera.addCallbackBuffer(new byte[i]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.CallbackBufferAddStrategy
 * JD-Core Version:    0.7.0.1
 */