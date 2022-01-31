package com.tencent.mobileqq.activity;

import aavu;
import bbfr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;

public class Conversation$1$6
  implements Runnable
{
  public Conversation$1$6(aavu paramaavu) {}
  
  public void run()
  {
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a(this.a.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "UpgradeTIMWrapper MSG_TIM_UPGRADE_BAR_SHOW, tips on: ", Boolean.valueOf(localUpgradeTIMWrapper.a()) });
    }
    if (!localUpgradeTIMWrapper.a()) {
      this.a.a.a(1134058, 0L, true);
    }
    do
    {
      return;
      if (bbfr.a(this.a.a.a.getApp(), "com.tencent.tim"))
      {
        this.a.a.a(1134058, 0L, true);
        return;
      }
    } while ((UpgradeTIMWrapper.b()) || (Conversation.a(this.a.a) != null));
    this.a.a.a(new Conversation.1.6.1(this, localUpgradeTIMWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.6
 * JD-Core Version:    0.7.0.1
 */