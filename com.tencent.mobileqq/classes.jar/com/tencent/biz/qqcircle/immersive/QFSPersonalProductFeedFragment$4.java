package com.tencent.biz.qqcircle.immersive;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.OnJustSeeListener;

class QFSPersonalProductFeedFragment$4
  extends RecyclerView.OnScrollListener
{
  QFSPersonalProductFeedFragment$4(QFSPersonalProductFeedFragment paramQFSPersonalProductFeedFragment) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (!this.a.z()) {
      return;
    }
    QFSPersonalProductFeedFragment.c(this.a).a(QFSPersonalProductFeedFragment.b(this.a) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment.4
 * JD-Core Version:    0.7.0.1
 */