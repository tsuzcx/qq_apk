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
      EnhanceItemAnimator.a(this.this$0, localMoveInfo.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localMoveInfo.jdField_a_of_type_Int, localMoveInfo.b, localMoveInfo.c, localMoveInfo.d);
    }
    this.a.clear();
    EnhanceItemAnimator.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */