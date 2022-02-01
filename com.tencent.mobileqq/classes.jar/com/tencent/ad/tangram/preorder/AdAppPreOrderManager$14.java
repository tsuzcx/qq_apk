package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;

class AdAppPreOrderManager$14
  implements Runnable
{
  AdAppPreOrderManager$14(AdAppPreOrderManager paramAdAppPreOrderManager, String paramString) {}
  
  public void run()
  {
    if (!AdAppPreOrderManager.access$1100(this.this$0))
    {
      AdLog.e("AdAppPreOrderManager", "already stopped or not ready");
      return;
    }
    AdLog.i("AdAppPreOrderManager", "stopTasks");
    if (AdAppPreOrderManager.access$400(this.this$0) != null)
    {
      AdAppPreOrderManager.access$1200(this.this$0);
      AdAppPreOrderManager.access$400(this.this$0).writeCurrentIntoFile(this.this$0.getContext());
      AdAppPreOrderManager.access$400(this.this$0).clear();
    }
    AdAppPreOrderManager.access$1300(this.this$0);
    AdLog.i("AdAppPreOrderManager", "stopTasks unRegisterListeners finish");
    try
    {
      AdAppPreOrderManager.access$502(this.this$0, 0);
      AdLog.i("AdAppPreOrderManager", "stopTasks status = STATUS_UNKNOWN finish");
      AdAppPreOrderManager.access$802(this.this$0, true);
      AdAppPreOrderManager.access$002(this.this$0, true);
      AdAppPreOrderManager.access$602(this.this$0, false);
      AdAppPreOrderManager.access$702(this.this$0, false);
      AdAppPreOrderManager.access$202(this.this$0, false);
      AdAppPreOrderManager.access$102(this.this$0, 0L);
      this.this$0.downloadingTaskCount = 0;
      this.this$0.init(this.this$0.getContext(), this.val$uin);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.14
 * JD-Core Version:    0.7.0.1
 */