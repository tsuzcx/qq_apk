package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarRecordActivity$7
  implements CameraExceptionHandler.Callback
{
  DynamicAvatarRecordActivity$7(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.7
 * JD-Core Version:    0.7.0.1
 */