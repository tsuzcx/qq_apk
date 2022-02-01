package com.tencent.av.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AVActivity$1
  implements MessageQueue.IdleHandler
{
  AVActivity$1(AVActivity paramAVActivity) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.b, 1, "call IdleHandler mPeerUin:=" + this.a.c);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AVActivity.1.1(this), 2000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.1
 * JD-Core Version:    0.7.0.1
 */