package com.tencent.mobileqq.addon;

import akii;
import akij;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(akii paramakii) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      akij localakij = (akij)localIterator.next();
      if ((localakij != null) && (localakij.a() != null))
      {
        if (!localHashSet.contains(localakij))
        {
          localHashSet.add(localakij);
          localakij.invalidateSelf();
          this.this$0.a.remove(localakij);
        }
      }
      else {
        this.this$0.a.remove(localakij);
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