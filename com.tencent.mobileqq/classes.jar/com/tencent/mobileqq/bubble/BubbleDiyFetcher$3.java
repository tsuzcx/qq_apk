package com.tencent.mobileqq.bubble;

import ambf;
import amcz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(ambf paramambf, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      amcz localamcz = (amcz)localIterator.next();
      if ((localamcz != null) && (localamcz.getCallback() != null))
      {
        String str = localamcz.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localamcz)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localamcz.toString());
          }
          localHashSet.add(localamcz);
          localamcz.invalidateSelf();
          this.this$0.a.remove(localamcz);
        }
      }
      else
      {
        this.this$0.a.remove(localamcz);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */