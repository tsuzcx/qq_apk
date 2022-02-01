package com.tencent.biz.qqcircle.immersive;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QFSPersonalFeedFragment$4
  extends RecyclerView.OnScrollListener
{
  QFSPersonalFeedFragment$4(QFSPersonalFeedFragment paramQFSPersonalFeedFragment) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (this.a.a(paramRecyclerView)) {
      paramRecyclerView.stopScroll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment.4
 * JD-Core Version:    0.7.0.1
 */