package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import zzl;

public class EnhanceItemAnimator$3
  implements Runnable
{
  public EnhanceItemAnimator$3(zzl paramzzl, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      zzl.a(this.this$0, localViewHolder);
    }
    this.a.clear();
    zzl.c(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.3
 * JD-Core Version:    0.7.0.1
 */