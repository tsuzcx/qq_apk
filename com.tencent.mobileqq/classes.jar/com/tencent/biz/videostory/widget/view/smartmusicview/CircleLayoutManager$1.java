package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

class CircleLayoutManager$1
  extends LinearSmoothScroller
{
  CircleLayoutManager$1(CircleLayoutManager paramCircleLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager.1
 * JD-Core Version:    0.7.0.1
 */