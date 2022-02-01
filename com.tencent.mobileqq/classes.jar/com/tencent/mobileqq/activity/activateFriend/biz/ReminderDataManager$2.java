package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import agdg;
import agdj;
import alib;
import com.tencent.common.app.AppInterface;

public class ReminderDataManager$2
  implements Runnable
{
  public ReminderDataManager$2(agdj paramagdj, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (agdj.a(this.this$0) == null) {
      agdj.a(this.this$0, (agdg)agdj.a(this.this$0).getManager(321));
    }
    if (this.a.type == 0)
    {
      if (agdj.a(this.this$0) == null) {
        break label88;
      }
      agdj.a(this.this$0).a(this.a);
    }
    for (;;)
    {
      agdj.a(this.this$0, this.a);
      return;
      label88:
      alib.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.2
 * JD-Core Version:    0.7.0.1
 */