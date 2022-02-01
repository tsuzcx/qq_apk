package com.tencent.biz.qqcircle.richframework.part.block.base;

import androidx.recyclerview.widget.RecyclerView;

class RefreshHeaderView$5
  implements Runnable
{
  RefreshHeaderView$5(RefreshHeaderView paramRefreshHeaderView, RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView != null) {
      localRecyclerView.scrollToPosition(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.5
 * JD-Core Version:    0.7.0.1
 */