package com.tencent.mobileqq.bubble;

import aqkr;
import aqmm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(aqkr paramaqkr, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      aqmm localaqmm = (aqmm)localIterator.next();
      if ((localaqmm != null) && (localaqmm.getCallback() != null))
      {
        String str = localaqmm.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localaqmm)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localaqmm.toString());
          }
          localHashSet.add(localaqmm);
          localaqmm.invalidateSelf();
          this.this$0.a.remove(localaqmm);
        }
      }
      else
      {
        this.this$0.a.remove(localaqmm);
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