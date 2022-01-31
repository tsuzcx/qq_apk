package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;

class FlowCameraActivity2$HandleEndVideoEncode
  implements Runnable
{
  private SVHwEncoder a;
  
  FlowCameraActivity2$HandleEndVideoEncode(FlowCameraActivity2 paramFlowCameraActivity2, SVHwEncoder paramSVHwEncoder)
  {
    this.a = paramSVHwEncoder;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.a);
    }
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.HandleEndVideoEncode
 * JD-Core Version:    0.7.0.1
 */