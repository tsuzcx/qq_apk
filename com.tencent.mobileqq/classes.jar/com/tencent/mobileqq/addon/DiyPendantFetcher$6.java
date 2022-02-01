package com.tencent.mobileqq.addon;

import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class DiyPendantFetcher$6
  implements Runnable
{
  DiyPendantFetcher$6(DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void run()
  {
    Object localObject = new HashSet();
    Iterator localIterator = this.this$0.i.iterator();
    while (localIterator.hasNext())
    {
      DiyPendantFetcher.Invalidatable localInvalidatable = (DiyPendantFetcher.Invalidatable)localIterator.next();
      if ((localInvalidatable != null) && (localInvalidatable.c() != null))
      {
        if (!((HashSet)localObject).contains(localInvalidatable))
        {
          ((HashSet)localObject).add(localInvalidatable);
          localInvalidatable.invalidateSelf();
          this.this$0.i.remove(localInvalidatable);
        }
      }
      else {
        this.this$0.i.remove(localInvalidatable);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wait for refresh size: ");
      ((StringBuilder)localObject).append(this.this$0.i.size());
      QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.6
 * JD-Core Version:    0.7.0.1
 */