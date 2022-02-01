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
    Object localObject = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      VipBubbleDrawable localVipBubbleDrawable = (VipBubbleDrawable)localIterator.next();
      if ((localVipBubbleDrawable != null) && (localVipBubbleDrawable.getCallback() != null))
      {
        String str = localVipBubbleDrawable.a;
        if ((this.a.contains(str)) && (!((HashSet)localObject).contains(localVipBubbleDrawable)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("refresh uinAndDiyId drawables: ");
            localStringBuilder.append(str);
            localStringBuilder.append(", vipBubbleDrawable:");
            localStringBuilder.append(localVipBubbleDrawable.toString());
            QLog.i("BubbleDiyFetcher", 2, localStringBuilder.toString());
          }
          ((HashSet)localObject).add(localVipBubbleDrawable);
          localVipBubbleDrawable.invalidateSelf();
          this.this$0.a.remove(localVipBubbleDrawable);
        }
      }
      else
      {
        this.this$0.a.remove(localVipBubbleDrawable);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wait for refresh size: ");
      ((StringBuilder)localObject).append(this.this$0.a.size());
      QLog.i("BubbleDiyFetcher", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */