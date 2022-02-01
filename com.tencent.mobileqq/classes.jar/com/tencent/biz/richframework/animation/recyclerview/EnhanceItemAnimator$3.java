package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

class EnhanceItemAnimator$3
  implements Runnable
{
  EnhanceItemAnimator$3(EnhanceItemAnimator paramEnhanceItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      EnhanceItemAnimator.a(this.this$0, localViewHolder);
    }
    this.a.clear();
    EnhanceItemAnimator.c(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.3
 * JD-Core Version:    0.7.0.1
 */