package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;

class WSCenterLayoutManager$CenterSmoothScroller
  extends LinearSmoothScroller
{
  int a;
  
  WSCenterLayoutManager$CenterSmoothScroller(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt3 + (paramInt4 - paramInt3) / 2 - (paramInt1 + (paramInt2 - paramInt1) / 2) + this.a / 2;
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager.CenterSmoothScroller
 * JD-Core Version:    0.7.0.1
 */