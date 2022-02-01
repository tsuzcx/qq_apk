package com.tencent.mobileqq.activity;

import aejr;
import android.os.Message;
import bhsi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class Conversation$UICallBack$6
  implements Runnable
{
  public Conversation$UICallBack$6(aejr paramaejr) {}
  
  public void run()
  {
    long l = bhsi.a(this.a.a.a.getApplication(), this.a.a.a.getCurrentAccountUin());
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      localUpgradeTIMWrapper = UpgradeTIMWrapper.a();
      if (localUpgradeTIMWrapper != null)
      {
        localMessage = this.a.a.b.obtainMessage(1134045);
        localMessage.obj = localUpgradeTIMWrapper;
        this.a.a.a(new Conversation.UICallBack.6.1(this, localMessage));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.UICallBack.6
 * JD-Core Version:    0.7.0.1
 */