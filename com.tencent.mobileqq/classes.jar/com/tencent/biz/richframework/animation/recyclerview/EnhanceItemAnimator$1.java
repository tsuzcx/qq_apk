package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;

class EnhanceItemAnimator$1
  implements Runnable
{
  EnhanceItemAnimator$1(EnhanceItemAnimator paramEnhanceItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EnhanceItemAnimator.MoveInfo localMoveInfo = (EnhanceItemAnimator.MoveInfo)localIterator.next();
      EnhanceItemAnimator.a(this.this$0, localMoveInfo.a, localMoveInfo.b, localMoveInfo.c, localMoveInfo.d, localMoveInfo.e);
    }
    this.a.clear();
    EnhanceItemAnimator.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */