package com.tencent.ad.tangram.preorder;

class AdAppPreOrderManager$15
  implements Runnable
{
  AdAppPreOrderManager$15(AdAppPreOrderManager paramAdAppPreOrderManager, String paramString, long paramLong) {}
  
  public void run()
  {
    AdAppPreOrderTask localAdAppPreOrderTask = new AdAppPreOrderTask(this.val$msgId);
    localAdAppPreOrderTask.taskCraetedTimeMillis = this.val$receivedTimeMillis;
    if (AdAppPreOrderManager.access$400(this.this$0).appendTaskWhenReceivedMsg(this.this$0.getContext(), localAdAppPreOrderTask, AdAppPreOrderManager.access$1100(AdAppPreOrderManager.INSTANCE))) {
      this.this$0.runTasks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.15
 * JD-Core Version:    0.7.0.1
 */