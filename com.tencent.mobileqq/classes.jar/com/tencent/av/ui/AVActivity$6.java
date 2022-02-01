package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class AVActivity$6
  implements Runnable
{
  AVActivity$6(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "OnCreateUI --> init EffectCtrlBase");
    }
    VideoController.a().a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.6
 * JD-Core Version:    0.7.0.1
 */