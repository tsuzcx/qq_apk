package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$8
  implements CameraProxy.CameraAutoFocusCallBack
{
  NewFlowCameraActivity$8(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with custom camera focus " + paramBoolean1);
    }
    NewFlowCameraReporter.a(paramBoolean1);
    NewFlowCameraActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.8
 * JD-Core Version:    0.7.0.1
 */