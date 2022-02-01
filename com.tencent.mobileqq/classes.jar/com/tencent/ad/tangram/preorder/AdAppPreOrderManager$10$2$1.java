package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdLifecycleManager;

class AdAppPreOrderManager$10$2$1
  implements Runnable
{
  AdAppPreOrderManager$10$2$1(AdAppPreOrderManager.10.2 param2, long paramLong) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", "onBackground+20s");
    long l1 = System.currentTimeMillis();
    long l2 = AdAppPreOrderManager.access$100(this.this$2.this$1.this$0);
    if ((!AdAppPreOrderManager.access$200(this.this$2.this$1.this$0)) && (AdAppPreOrderManager.access$100(this.this$2.this$1.this$0) != 0L) && (l1 - l2 >= this.val$delayMillisAfterBackground) && (!AdLifecycleManager.INSTANCE.isOnForeground()))
    {
      AdAppPreOrderManager.access$202(this.this$2.this$1.this$0, true);
      this.this$2.this$1.this$0.runTasks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.10.2.1
 * JD-Core Version:    0.7.0.1
 */