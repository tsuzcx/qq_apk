package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;

public class WSTopSmoothScroller
  extends LinearSmoothScroller
{
  WSTopSmoothScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt3 - paramInt1 + (paramInt2 - paramInt1);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return null;
  }
  
  protected int getVerticalSnapPreference()
  {
    return -1;
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSTopSmoothScroller
 * JD-Core Version:    0.7.0.1
 */