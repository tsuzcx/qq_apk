package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;

class AECameraManager$8$1
  implements CameraProxy.CameraAutoFocusCallBack
{
  AECameraManager$8$1(AECameraManager.8 param8) {}
  
  public void onAutoFocusCallback(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAutoFocusCallback single tap focus ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AECameraManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      AECameraManager.access$302(this.this$1.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.8.1
 * JD-Core Version:    0.7.0.1
 */