package com.tencent.mobileqq.addon;

import almr;
import alms;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(almr paramalmr) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      alms localalms = (alms)localIterator.next();
      if ((localalms != null) && (localalms.a() != null))
      {
        if (!localHashSet.contains(localalms))
        {
          localHashSet.add(localalms);
          localalms.invalidateSelf();
          this.this$0.a.remove(localalms);
        }
      }
      else {
        this.this$0.a.remove(localalms);
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