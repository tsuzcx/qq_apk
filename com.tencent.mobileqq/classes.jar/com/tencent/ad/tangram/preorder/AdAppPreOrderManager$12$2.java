package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdLifecycleManager;

class AdAppPreOrderManager$12$2
  implements Runnable
{
  AdAppPreOrderManager$12$2(AdAppPreOrderManager.12 param12, long paramLong) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", "onMessagesSynced background+20s");
    long l1 = System.currentTimeMillis();
    long l2 = AdAppPreOrderManager.access$100(this.this$1.this$0);
    if ((!AdAppPreOrderManager.access$200(this.this$1.this$0)) && (AdAppPreOrderManager.access$100(this.this$1.this$0) != 0L) && (l1 - l2 >= this.val$delayMillisAfterBackground) && (!AdLifecycleManager.INSTANCE.isOnForeground())) {
      AdAppPreOrderManager.access$202(this.this$1.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.12.2
 * JD-Core Version:    0.7.0.1
 */