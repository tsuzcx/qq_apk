package com.tencent.biz.richframework.part.block.base;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class QCircleLinearPagerSnapHelper$1
  extends RecyclerView.OnScrollListener
{
  QCircleLinearPagerSnapHelper$1(QCircleLinearPagerSnapHelper paramQCircleLinearPagerSnapHelper) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      View localView = paramRecyclerView.getChildAt(0);
      if ((QCircleLinearPagerSnapHelper.a(this.a) != null) && (localView != null))
      {
        paramInt = ((RecyclerView.LayoutParams)localView.getLayoutParams()).getViewAdapterPosition();
        if (paramInt != QCircleLinearPagerSnapHelper.b(this.a))
        {
          QCircleLinearPagerSnapHelper.a(this.a).a(paramRecyclerView.findViewHolderForAdapterPosition(QCircleLinearPagerSnapHelper.b(this.a)));
          QCircleLinearPagerSnapHelper.a(this.a, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCircleLinearPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */