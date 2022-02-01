package com.tencent.biz.richframework.part.block.base;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class QCircleLinearPagerSnapHelper
  extends PagerSnapHelper
{
  private QCirclePagerSnapHelper.PagerChangeListener a;
  private int b = -1;
  private boolean c;
  
  private void a(@Nullable RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && (paramRecyclerView.getAdapter() != null))
    {
      paramRecyclerView.getAdapter().registerAdapterDataObserver(new QCircleLinearPagerSnapHelper.2(this));
      paramRecyclerView.addOnChildAttachStateChangeListener(new QCircleLinearPagerSnapHelper.3(this, paramRecyclerView));
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(QCirclePagerSnapHelper.PagerChangeListener paramPagerChangeListener)
  {
    this.a = paramPagerChangeListener;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    super.attachToRecyclerView(paramRecyclerView);
    a(paramRecyclerView);
    if (paramRecyclerView != null) {
      paramRecyclerView.addOnScrollListener(new QCircleLinearPagerSnapHelper.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCircleLinearPagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */