package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;
import android.view.View;

final class AEWaterMarkAdapter$7
  extends LinearSmoothScroller
{
  AEWaterMarkAdapter$7(Context paramContext, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt4 + paramInt3) / 2 - (paramInt2 + paramInt1) / 2;
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    if (this.b) {
      return 100;
    }
    return Math.min(200, super.calculateTimeForScrolling(paramInt));
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = this.a.findFirstVisibleItemPosition();
    int j = this.a.findLastVisibleItemPosition();
    float f;
    if (paramInt < i)
    {
      f = -1.0F;
    }
    else if (paramInt > j)
    {
      f = 1.0F;
    }
    else
    {
      View localView = this.a.findViewByPosition(paramInt);
      if (localView != null) {
        f = this.a.getWidth() / 2.0F - (localView.getLeft() + localView.getRight()) / 2.0F;
      } else {
        f = 0.0F;
      }
    }
    return new PointF(f, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter.7
 * JD-Core Version:    0.7.0.1
 */