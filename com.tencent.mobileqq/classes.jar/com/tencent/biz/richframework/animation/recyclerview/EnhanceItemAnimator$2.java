package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;

class EnhanceItemAnimator$2
  implements Runnable
{
  EnhanceItemAnimator$2(EnhanceItemAnimator paramEnhanceItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EnhanceItemAnimator.ChangeInfo localChangeInfo = (EnhanceItemAnimator.ChangeInfo)localIterator.next();
      EnhanceItemAnimator.a(this.this$0, localChangeInfo);
    }
    this.a.clear();
    EnhanceItemAnimator.b(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */