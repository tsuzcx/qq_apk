package com.tencent.biz.richframework.part.block.base;

import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

class QCircleLinearPagerSnapHelper$2
  extends RecyclerView.AdapterDataObserver
{
  QCircleLinearPagerSnapHelper$2(QCircleLinearPagerSnapHelper paramQCircleLinearPagerSnapHelper) {}
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    super.onItemRangeInserted(paramInt1, paramInt2);
    QCircleLinearPagerSnapHelper.a(this.a, true);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    super.onItemRangeRemoved(paramInt1, paramInt2);
    QCircleLinearPagerSnapHelper.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCircleLinearPagerSnapHelper.2
 * JD-Core Version:    0.7.0.1
 */