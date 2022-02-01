package com.tencent.biz.qqcircle.immersive;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;

class QFSPersonalFeedFragment$5
  extends RecyclerView.OnScrollListener
{
  QFSPersonalFeedFragment$5(QFSPersonalFeedFragment paramQFSPersonalFeedFragment) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.a;
    QFSPersonalFeedFragment.a(paramRecyclerView, QFSPersonalFeedFragment.a(paramRecyclerView).findFirstVisibleItemPosition());
    paramRecyclerView = this.a;
    QFSPersonalFeedFragment.b(paramRecyclerView, QFSPersonalFeedFragment.a(paramRecyclerView).findLastVisibleItemPosition());
    paramRecyclerView = this.a;
    paramRecyclerView.h = ((QFSPersonalFeedFragment.b(paramRecyclerView) + QFSPersonalFeedFragment.c(this.a)) / 2 / 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment.5
 * JD-Core Version:    0.7.0.1
 */