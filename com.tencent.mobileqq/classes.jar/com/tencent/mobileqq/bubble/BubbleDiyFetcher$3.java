package com.tencent.mobileqq.bubble;

import apwr;
import apym;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(apwr paramapwr, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      apym localapym = (apym)localIterator.next();
      if ((localapym != null) && (localapym.getCallback() != null))
      {
        String str = localapym.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localapym)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localapym.toString());
          }
          localHashSet.add(localapym);
          localapym.invalidateSelf();
          this.this$0.a.remove(localapym);
        }
      }
      else
      {
        this.this$0.a.remove(localapym);
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