package com.tencent.mobileqq.addon;

import amks;
import amkt;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(amks paramamks) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      amkt localamkt = (amkt)localIterator.next();
      if ((localamkt != null) && (localamkt.a() != null))
      {
        if (!localHashSet.contains(localamkt))
        {
          localHashSet.add(localamkt);
          localamkt.invalidateSelf();
          this.this$0.a.remove(localamkt);
        }
      }
      else {
        this.this$0.a.remove(localamkt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.6
 * JD-Core Version:    0.7.0.1
 */