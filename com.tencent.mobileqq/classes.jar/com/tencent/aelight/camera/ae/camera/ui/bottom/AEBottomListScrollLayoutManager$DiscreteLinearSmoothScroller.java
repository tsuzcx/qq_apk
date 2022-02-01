package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.view.View;

class AEBottomListScrollLayoutManager$DiscreteLinearSmoothScroller
  extends LinearSmoothScroller
{
  public AEBottomListScrollLayoutManager$DiscreteLinearSmoothScroller(AEBottomListScrollLayoutManager paramAEBottomListScrollLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    return AEBottomListScrollLayoutManager.a(this.a).a(-this.a.g);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    return AEBottomListScrollLayoutManager.a(this.a).b(-this.a.g);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return (int)(Math.max(0.01F, Math.min(Math.abs(paramInt), this.a.d) / this.a.d) * AEBottomListScrollLayoutManager.a(this.a));
  }
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return new PointF(AEBottomListScrollLayoutManager.a(this.a).a(this.a.g), AEBottomListScrollLayoutManager.a(this.a).b(this.a.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller
 * JD-Core Version:    0.7.0.1
 */