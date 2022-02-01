package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aewa;
import aewd;
import akfu;
import com.tencent.common.app.AppInterface;

public class ReminderDataManager$2
  implements Runnable
{
  public ReminderDataManager$2(aewd paramaewd, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (aewd.a(this.this$0) == null) {
      aewd.a(this.this$0, (aewa)aewd.a(this.this$0).getManager(321));
    }
    if (this.a.type == 0)
    {
      if (aewd.a(this.this$0) == null) {
        break label88;
      }
      aewd.a(this.this$0).a(this.a);
    }
    for (;;)
    {
      aewd.a(this.this$0, this.a);
      return;
      label88:
      akfu.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.2
 * JD-Core Version:    0.7.0.1
 */