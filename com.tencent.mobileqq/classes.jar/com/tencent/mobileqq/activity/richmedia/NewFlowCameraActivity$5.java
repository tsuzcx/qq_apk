package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$5
  implements CameraExceptionHandler.Callback
{
  NewFlowCameraActivity$5(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onCameraException(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.5
 * JD-Core Version:    0.7.0.1
 */