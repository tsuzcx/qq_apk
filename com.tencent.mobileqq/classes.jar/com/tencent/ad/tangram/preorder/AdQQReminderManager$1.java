package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;

class AdQQReminderManager$1
  implements Runnable
{
  AdQQReminderManager$1(AdQQReminderManager paramAdQQReminderManager, boolean paramBoolean) {}
  
  public void run()
  {
    AdLog.i("AdQQReminderManager", String.format("onQQReminderSwichOnResult %b", new Object[] { Boolean.valueOf(this.val$success) }));
    AdAppPreOrderManager.INSTANCE.onQQReminderSwitchStatusChagned();
    AdQQReminderManager.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdQQReminderManager.1
 * JD-Core Version:    0.7.0.1
 */