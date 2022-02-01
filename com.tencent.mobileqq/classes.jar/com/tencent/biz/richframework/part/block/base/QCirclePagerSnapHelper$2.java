package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.State;

class QCirclePagerSnapHelper$2
  extends LinearSmoothScroller
{
  QCirclePagerSnapHelper$2(QCirclePagerSnapHelper paramQCirclePagerSnapHelper, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return QCirclePagerSnapHelper.l(this.b) / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForDeceleration(int paramInt)
  {
    return super.calculateTimeForDeceleration(paramInt);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return super.calculateTimeForScrolling(paramInt);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.computeScrollVectorForPosition(paramInt);
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = QCirclePagerSnapHelper.a(this.b, this.a, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0)
    {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
      return;
    }
    QCirclePagerSnapHelper.TouchEventProcessor.d(QCirclePagerSnapHelper.k(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.2
 * JD-Core Version:    0.7.0.1
 */