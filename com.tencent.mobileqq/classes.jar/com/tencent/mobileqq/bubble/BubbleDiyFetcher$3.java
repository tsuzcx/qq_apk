package com.tencent.mobileqq.bubble;

import anwm;
import anyh;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(anwm paramanwm, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      anyh localanyh = (anyh)localIterator.next();
      if ((localanyh != null) && (localanyh.getCallback() != null))
      {
        String str = localanyh.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localanyh)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localanyh.toString());
          }
          localHashSet.add(localanyh);
          localanyh.invalidateSelf();
          this.this$0.a.remove(localanyh);
        }
      }
      else
      {
        this.this$0.a.remove(localanyh);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */