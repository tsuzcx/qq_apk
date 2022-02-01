package com.tencent.biz.qqcircle.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;

class QCircleWaterfallFeedsBlock$1
  extends RecyclerView.OnScrollListener
{
  QCircleWaterfallFeedsBlock$1(QCircleWaterfallFeedsBlock paramQCircleWaterfallFeedsBlock) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((QCircleWaterfallFeedsBlock.a(this.a) instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)QCircleWaterfallFeedsBlock.a(this.a);
      int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
      paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
      if (Math.min(this.a.getLocalPosition(arrayOfInt[0]), this.a.getLocalPosition(arrayOfInt[1])) <= 0)
      {
        paramRecyclerView.invalidateSpanAssignments();
        QLog.d("QCircleWaterfallFeedsBlock", 2, "invalidateSpanAssignments occur!");
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock.1
 * JD-Core Version:    0.7.0.1
 */