package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PushBroadcastReceiver$1
  implements Runnable
{
  PushBroadcastReceiver$1(PushBroadcastReceiver paramPushBroadcastReceiver, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getStringExtra("classname");
    Class localClass;
    if (localObject != null) {
      try
      {
        localObject = Class.forName((String)localObject);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("processIntent", 2, localClassNotFoundException.getMessage());
        }
      }
    } else {
      localClass = null;
    }
    this.b.showIdleNotification(BaseApplication.getContext(), localClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */