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
    return AEBottomListScrollLayoutManager.a(this.a).a(-this.a.j);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    return AEBottomListScrollLayoutManager.a(this.a).b(-this.a.j);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return (int)(Math.max(0.01F, Math.min(Math.abs(paramInt), this.a.g) / this.a.g) * AEBottomListScrollLayoutManager.b(this.a));
  }
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return new PointF(AEBottomListScrollLayoutManager.a(this.a).a(this.a.j), AEBottomListScrollLayoutManager.a(this.a).b(this.a.j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller
 * JD-Core Version:    0.7.0.1
 */