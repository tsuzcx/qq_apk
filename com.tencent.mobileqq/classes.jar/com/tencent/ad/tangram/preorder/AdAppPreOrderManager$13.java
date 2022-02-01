package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdLifecycleManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class AdAppPreOrderManager$13
  implements Runnable
{
  AdAppPreOrderManager$13(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", String.format("runTasks on file thread, downloadingTaskCount:%d, reminderStatusChanged:%b messagesSynced:%b messagesSynced30SecondsDelay:%b onBackgroundAtFirstTime20SecondsDelay:%b isOnForeground:%b", new Object[] { Integer.valueOf(this.this$0.downloadingTaskCount), Boolean.valueOf(AdAppPreOrderManager.access$800(this.this$0)), Boolean.valueOf(AdAppPreOrderManager.access$600(this.this$0)), Boolean.valueOf(AdAppPreOrderManager.access$700(this.this$0)), Boolean.valueOf(AdAppPreOrderManager.access$200(this.this$0)), Boolean.valueOf(AdLifecycleManager.INSTANCE.isOnForeground()) }));
    AdAppPreOrderManager.access$400(this.this$0).syncPendingTaskToCacheAndFile(this.this$0.getContext());
    Iterator localIterator = AdAppPreOrderManager.access$400(this.this$0).getQueue().iterator();
    while (localIterator.hasNext())
    {
      AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)localIterator.next();
      AdAppPreOrderManager.access$900(this.this$0, localAdAppPreOrderTask);
    }
    AdAppPreOrderManager.access$802(this.this$0, false);
    AdAppPreOrderManager.access$002(this.this$0, false);
    if (AdAppPreOrderManager.access$1000(this.this$0)) {
      this.this$0.runTasks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.13
 * JD-Core Version:    0.7.0.1
 */