package com.tencent.ad.tangram.preorder;

import android.util.Pair;
import java.util.Iterator;
import java.util.List;

class AdAppPreOrderManager$3
  implements Runnable
{
  AdAppPreOrderManager$3(AdAppPreOrderManager paramAdAppPreOrderManager, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.val$urlAndPkgName.size())
    {
      if (this.val$urlAndPkgName.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = AdAppPreOrderManager.access$1400(this.this$0, (String)((Pair)this.val$urlAndPkgName.get(i)).first);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)((Iterator)localObject).next();
            if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.isValid(this.this$0.getContext()))) {
              this.this$0.setTaskStatusAndCommit(localAdAppPreOrderTask.taskId, 8);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.3
 * JD-Core Version:    0.7.0.1
 */