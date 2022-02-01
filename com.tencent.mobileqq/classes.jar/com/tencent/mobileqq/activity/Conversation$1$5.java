package com.tencent.mobileqq.activity;

import adyo;
import bgnw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;

public class Conversation$1$5
  implements Runnable
{
  public Conversation$1$5(adyo paramadyo) {}
  
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
      if (bgnw.a(this.a.a.a.getApp(), "com.tencent.tim"))
      {
        this.a.a.a(1134058, 0L, true);
        return;
      }
    } while ((UpgradeTIMWrapper.b()) || (Conversation.a(this.a.a) != null));
    this.a.a.a(new Conversation.1.5.1(this, localUpgradeTIMWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.5
 * JD-Core Version:    0.7.0.1
 */