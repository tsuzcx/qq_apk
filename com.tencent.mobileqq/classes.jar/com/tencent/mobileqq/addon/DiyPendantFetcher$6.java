package com.tencent.mobileqq.addon;

import aiqx;
import aiqy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(aiqx paramaiqx) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      aiqy localaiqy = (aiqy)localIterator.next();
      if ((localaiqy != null) && (localaiqy.a() != null))
      {
        if (!localHashSet.contains(localaiqy))
        {
          localHashSet.add(localaiqy);
          localaiqy.invalidateSelf();
          this.this$0.a.remove(localaiqy);
        }
      }
      else {
        this.this$0.a.remove(localaiqy);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.6
 * JD-Core Version:    0.7.0.1
 */