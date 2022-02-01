package com.tencent.ad.tangram.preorder;

class AdAppPreOrderManager$5
  implements Runnable
{
  AdAppPreOrderManager$5(AdAppPreOrderManager paramAdAppPreOrderManager, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    AdAppPreOrderTask localAdAppPreOrderTask = AdAppPreOrderManager.access$1500(this.this$0, this.val$taskId);
    c.onDisplayed(this.this$0.getContext(), localAdAppPreOrderTask, this.val$reminderId, this.val$ready);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.5
 * JD-Core Version:    0.7.0.1
 */