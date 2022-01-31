package com.tencent.mobileqq.bubble;

import ansd;
import anty;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(ansd paramansd, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      anty localanty = (anty)localIterator.next();
      if ((localanty != null) && (localanty.getCallback() != null))
      {
        String str = localanty.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localanty)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localanty.toString());
          }
          localHashSet.add(localanty);
          localanty.invalidateSelf();
          this.this$0.a.remove(localanty);
        }
      }
      else
      {
        this.this$0.a.remove(localanty);
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