package com.tencent.mobileqq.bubble;

import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

class BubbleDiyFetcher$3
  implements Runnable
{
  BubbleDiyFetcher$3(BubbleDiyFetcher paramBubbleDiyFetcher, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      VipBubbleDrawable localVipBubbleDrawable = (VipBubbleDrawable)localIterator.next();
      if ((localVipBubbleDrawable != null) && (localVipBubbleDrawable.getCallback() != null))
      {
        String str = localVipBubbleDrawable.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localVipBubbleDrawable)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localVipBubbleDrawable.toString());
          }
          localHashSet.add(localVipBubbleDrawable);
          localVipBubbleDrawable.invalidateSelf();
          this.this$0.a.remove(localVipBubbleDrawable);
        }
      }
      else
      {
        this.this$0.a.remove(localVipBubbleDrawable);
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