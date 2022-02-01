package com.tencent.biz.richframework.part.block.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class PullLoadMoreAdapter$2
  extends RecyclerView.OnScrollListener
{
  PullLoadMoreAdapter$2(PullLoadMoreAdapter paramPullLoadMoreAdapter) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.a.w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.2
 * JD-Core Version:    0.7.0.1
 */