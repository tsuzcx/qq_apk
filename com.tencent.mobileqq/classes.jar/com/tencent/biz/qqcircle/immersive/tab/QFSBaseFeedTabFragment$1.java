package com.tencent.biz.qqcircle.immersive.tab;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.immersive.part.QFSMessageNoticePart;

class QFSBaseFeedTabFragment$1
  extends RecyclerView.OnScrollListener
{
  float a = 0.0F;
  
  QFSBaseFeedTabFragment$1(QFSBaseFeedTabFragment paramQFSBaseFeedTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      View localView = QFSBaseFeedTabFragment.a(this.b);
      if (paramRecyclerView.canScrollVertically(1)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      localView.setVisibility(paramInt);
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.a += paramInt2;
    if (this.a > QFSBaseFeedTabFragment.b(this.b))
    {
      QFSMessageNoticePart.o();
      QFSMessageNoticePart.p();
      this.a = 0.0F;
    }
    else if (this.a < 0.0F)
    {
      this.a = 0.0F;
    }
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment.1
 * JD-Core Version:    0.7.0.1
 */