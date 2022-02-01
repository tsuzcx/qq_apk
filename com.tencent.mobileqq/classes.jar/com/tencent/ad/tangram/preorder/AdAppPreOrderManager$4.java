package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;

class AdAppPreOrderManager$4
  implements Runnable
{
  AdAppPreOrderManager$4(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", "onQQReminderSwitchStatusChagned");
    AdAppPreOrderManager.access$802(this.this$0, true);
    this.this$0.runTasks();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.4
 * JD-Core Version:    0.7.0.1
 */