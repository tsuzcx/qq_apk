package com.tencent.mobileqq.apollo;

import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.utils.QLog;

class AVCameraCaptureModel$1$3
  extends AVVideoCtrl.EnableCameraCompleteCallback
{
  AVCameraCaptureModel$1$3(AVCameraCaptureModel.1 param1) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVCameraCaptureModel", 0, "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.3
 * JD-Core Version:    0.7.0.1
 */