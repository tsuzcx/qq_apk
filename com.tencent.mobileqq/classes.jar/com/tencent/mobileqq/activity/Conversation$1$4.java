package com.tencent.mobileqq.activity;

import acms;
import android.os.Message;
import bdiv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class Conversation$1$4
  implements Runnable
{
  public Conversation$1$4(acms paramacms) {}
  
  public void run()
  {
    long l = bdiv.a(this.a.a.a.getApplication(), this.a.a.a.getCurrentAccountUin());
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      localUpgradeTIMWrapper = UpgradeTIMWrapper.a();
      if (localUpgradeTIMWrapper != null)
      {
        localMessage = this.a.a.b.obtainMessage(1134045);
        localMessage.obj = localUpgradeTIMWrapper;
        this.a.a.a(new Conversation.1.4.1(this, localMessage));
      }
    }
    while (!QLog.isColorLevel())
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      Message localMessage;
      return;
    }
    QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips smaller than 24 hours");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.4
 * JD-Core Version:    0.7.0.1
 */