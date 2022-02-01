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
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      DiyPendantFetcher.Invalidatable localInvalidatable = (DiyPendantFetcher.Invalidatable)localIterator.next();
      if ((localInvalidatable != null) && (localInvalidatable.a() != null))
      {
        if (!localHashSet.contains(localInvalidatable))
        {
          localHashSet.add(localInvalidatable);
          localInvalidatable.invalidateSelf();
          this.this$0.a.remove(localInvalidatable);
        }
      }
      else {
        this.this$0.a.remove(localInvalidatable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.6
 * JD-Core Version:    0.7.0.1
 */