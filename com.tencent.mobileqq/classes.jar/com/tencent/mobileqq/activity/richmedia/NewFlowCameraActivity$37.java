package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$37
  implements CameraProxy.CameraAutoFocusCallBack
{
  NewFlowCameraActivity$37(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "single tap focus " + paramBoolean1);
    }
    NewFlowCameraReporter.a(paramBoolean1);
    if (paramBoolean1)
    {
      NewFlowCameraActivity.h(this.a, true);
      return;
    }
    this.a.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.37
 * JD-Core Version:    0.7.0.1
 */