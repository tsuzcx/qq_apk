package com.tencent.mobileqq.bubble;

import apec;
import apfx;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(apec paramapec, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      apfx localapfx = (apfx)localIterator.next();
      if ((localapfx != null) && (localapfx.getCallback() != null))
      {
        String str = localapfx.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localapfx)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localapfx.toString());
          }
          localHashSet.add(localapfx);
          localapfx.invalidateSelf();
          this.this$0.a.remove(localapfx);
        }
      }
      else
      {
        this.this$0.a.remove(localapfx);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */