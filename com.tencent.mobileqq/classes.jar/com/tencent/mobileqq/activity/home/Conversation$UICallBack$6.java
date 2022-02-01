package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class Conversation$UICallBack$6
  implements Runnable
{
  Conversation$UICallBack$6(Conversation.UICallBack paramUICallBack) {}
  
  public void run()
  {
    long l = SharedPreUtils.Q(this.a.a.aF.getApplication(), this.a.a.s().getCurrentAccountUin());
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.e();
      if (localUpgradeTIMWrapper != null)
      {
        Message localMessage = this.a.a.G.obtainMessage(1134045);
        localMessage.obj = localUpgradeTIMWrapper;
        this.a.a.b(new Conversation.UICallBack.6.1(this, localMessage));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips smaller than 24 hours");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.6
 * JD-Core Version:    0.7.0.1
 */