package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class PushBroadcastReceiver$2
  implements Runnable
{
  PushBroadcastReceiver$2(PushBroadcastReceiver paramPushBroadcastReceiver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "PushBroadcastReceiver processIntent removeNotification");
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushBroadcastReceiver.2
 * JD-Core Version:    0.7.0.1
 */