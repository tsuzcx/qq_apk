package com.tencent.biz.richframework.part.block.base;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;

class QCircleLinearPagerSnapHelper$3
  implements RecyclerView.OnChildAttachStateChangeListener
{
  QCircleLinearPagerSnapHelper$3(QCircleLinearPagerSnapHelper paramQCircleLinearPagerSnapHelper, RecyclerView paramRecyclerView) {}
  
  public void onChildViewAttachedToWindow(@NonNull View paramView)
  {
    if ((QCircleLinearPagerSnapHelper.a(this.b) != null) && (QCircleLinearPagerSnapHelper.c(this.b)))
    {
      paramView = this.a.findContainingViewHolder(paramView);
      QCircleLinearPagerSnapHelper.a(this.b, false);
      if (paramView != null) {
        QCircleLinearPagerSnapHelper.a(this.b).a(paramView);
      }
    }
  }
  
  public void onChildViewDetachedFromWindow(@NonNull View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCircleLinearPagerSnapHelper.3
 * JD-Core Version:    0.7.0.1
 */