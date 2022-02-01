package com.tencent.biz.qqcircle.fragments.content;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class QCircleContentPart$10
  extends RecyclerView.OnScrollListener
{
  QCircleContentPart$10(QCircleContentPart paramQCircleContentPart) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (QCircleContentPart.q(this.a) != null))
    {
      if (!(QCircleContentPart.q(this.a).getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      paramRecyclerView = this.a;
      QCircleContentPart.a(paramRecyclerView, ((LinearLayoutManager)QCircleContentPart.q(paramRecyclerView).getLayoutManager()).findFirstCompletelyVisibleItemPosition());
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QCircleContentPart.q(this.a) != null)
    {
      if (!(QCircleContentPart.q(this.a).getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)QCircleContentPart.q(this.a).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = QCircleContentPart.q(this.a).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          QCircleContentPart.r(this.a);
        }
        if ((paramInt1 == paramInt2 - 1) && (QCircleContentPart.s(this.a))) {
          QCircleContentPart.t(this.a);
        }
        QCircleContentPart.b(this.a, paramInt1);
        return;
      }
      paramInt1 = ((LinearLayoutManager)QCircleContentPart.q(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
      if (QCircleContentPart.u(this.a) == 0) {
        QCircleContentPart.t(this.a);
      }
      QCircleContentPart.b(this.a, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.10
 * JD-Core Version:    0.7.0.1
 */