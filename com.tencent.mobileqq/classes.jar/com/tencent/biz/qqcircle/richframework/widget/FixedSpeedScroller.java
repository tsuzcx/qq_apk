package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.widget.Scroller;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class FixedSpeedScroller
  extends Scroller
{
  private int a = 150;
  
  public FixedSpeedScroller(Context paramContext)
  {
    super(paramContext, new LinearOutSlowInInterpolator());
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.FixedSpeedScroller
 * JD-Core Version:    0.7.0.1
 */