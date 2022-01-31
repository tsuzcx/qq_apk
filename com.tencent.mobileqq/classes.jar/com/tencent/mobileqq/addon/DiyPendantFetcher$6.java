package com.tencent.mobileqq.addon;

import akmx;
import akmy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(akmx paramakmx) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      akmy localakmy = (akmy)localIterator.next();
      if ((localakmy != null) && (localakmy.a() != null))
      {
        if (!localHashSet.contains(localakmy))
        {
          localHashSet.add(localakmy);
          localakmy.invalidateSelf();
          this.this$0.a.remove(localakmy);
        }
      }
      else {
        this.this$0.a.remove(localakmy);
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