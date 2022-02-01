package com.tencent.ad.tangram.preorder;

import java.util.Iterator;
import java.util.List;

class AdAppPreOrderManager$2
  implements Runnable
{
  AdAppPreOrderManager$2(AdAppPreOrderManager paramAdAppPreOrderManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = AdAppPreOrderManager.access$1400(this.this$0, this.val$url);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)((Iterator)localObject).next();
        if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.isValid(this.this$0.getContext())))
        {
          if ((this.val$newStatus == 10) && (this.this$0.downloadingTaskCount > 0))
          {
            AdAppPreOrderManager localAdAppPreOrderManager = this.this$0;
            localAdAppPreOrderManager.downloadingTaskCount -= 1;
          }
          this.this$0.setTaskStatusAndCommit(localAdAppPreOrderTask.taskId, this.val$newStatus, this.val$errorCode);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.2
 * JD-Core Version:    0.7.0.1
 */