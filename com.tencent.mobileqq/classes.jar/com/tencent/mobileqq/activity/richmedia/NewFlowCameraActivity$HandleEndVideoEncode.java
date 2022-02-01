package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$HandleEndVideoEncode
  implements Runnable
{
  private SVHwEncoder a = null;
  
  NewFlowCameraActivity$HandleEndVideoEncode(NewFlowCameraActivity paramNewFlowCameraActivity, SVHwEncoder paramSVHwEncoder)
  {
    this.a = paramSVHwEncoder;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.a);
    }
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.HandleEndVideoEncode
 * JD-Core Version:    0.7.0.1
 */