package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import afnl;
import afno;
import albn;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class ReminderDataManager$2
  implements Runnable
{
  public ReminderDataManager$2(afno paramafno, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (afno.a(this.this$0) == null) {
      afno.a(this.this$0, (afnl)afno.a(this.this$0).getManager(QQManagerFactory.QQ_REMINDER_ALARM_MANAGER));
    }
    if (this.a.type == 0)
    {
      if (afno.a(this.this$0) == null) {
        break label88;
      }
      afno.a(this.this$0).a(this.a);
    }
    for (;;)
    {
      afno.a(this.this$0, this.a);
      return;
      label88:
      albn.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.2
 * JD-Core Version:    0.7.0.1
 */