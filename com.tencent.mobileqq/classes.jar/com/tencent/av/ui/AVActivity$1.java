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
    if (QLog.isColorLevel())
    {
      String str = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call IdleHandler mPeerUin:=");
      localStringBuilder.append(this.a.j);
      QLog.w(str, 1, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AVActivity.1.1(this), 2000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.1
 * JD-Core Version:    0.7.0.1
 */