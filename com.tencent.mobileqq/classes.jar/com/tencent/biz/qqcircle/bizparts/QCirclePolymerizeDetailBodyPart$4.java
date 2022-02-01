package com.tencent.biz.qqcircle.bizparts;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;

class QCirclePolymerizeDetailBodyPart$4
  extends RecyclerView.OnScrollListener
{
  QCirclePolymerizeDetailBodyPart$4(QCirclePolymerizeDetailBodyPart paramQCirclePolymerizeDetailBodyPart) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!(this.a.be_().getLayoutManager() instanceof SafeStaggeredGridLayoutManager)) {
      return;
    }
    paramRecyclerView = ((SafeStaggeredGridLayoutManager)this.a.be_().getLayoutManager()).findFirstVisibleItemPositions(null);
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.length <= 0) {
        return;
      }
      if ((QCirclePolymerizeDetailBodyPart.d(this.a) != paramRecyclerView[0]) && (paramRecyclerView[0] + 1 == QCirclePolymerizeDetailBodyPart.e(this.a))) {
        this.a.E().a("go_home_button_show_bubble_guide", null);
      }
      QCirclePolymerizeDetailBodyPart.b(this.a, paramRecyclerView[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart.4
 * JD-Core Version:    0.7.0.1
 */