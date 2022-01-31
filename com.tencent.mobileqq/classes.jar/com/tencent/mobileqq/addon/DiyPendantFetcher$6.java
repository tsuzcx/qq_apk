package com.tencent.mobileqq.addon;

import aieg;
import aieh;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(aieg paramaieg) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      aieh localaieh = (aieh)localIterator.next();
      if ((localaieh != null) && (localaieh.a() != null))
      {
        if (!localHashSet.contains(localaieh))
        {
          localHashSet.add(localaieh);
          localaieh.invalidateSelf();
          this.this$0.a.remove(localaieh);
        }
      }
      else {
        this.this$0.a.remove(localaieh);
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