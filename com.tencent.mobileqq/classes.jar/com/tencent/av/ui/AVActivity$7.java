package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class AVActivity$7
  implements Runnable
{
  AVActivity$7(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.i, 2, "OnCreateUI --> init EffectCtrlBase");
    }
    VideoController.f().m(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.7
 * JD-Core Version:    0.7.0.1
 */