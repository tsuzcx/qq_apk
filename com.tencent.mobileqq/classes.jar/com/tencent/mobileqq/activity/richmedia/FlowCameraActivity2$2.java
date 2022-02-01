package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

class FlowCameraActivity2$2
  implements CameraExceptionHandler.Callback
{
  FlowCameraActivity2$2(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onCameraException(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.2
 * JD-Core Version:    0.7.0.1
 */