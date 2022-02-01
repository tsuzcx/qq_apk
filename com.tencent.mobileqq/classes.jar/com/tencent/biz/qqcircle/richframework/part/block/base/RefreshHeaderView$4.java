package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RefreshHeaderView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  RefreshHeaderView$4(RefreshHeaderView paramRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.a == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0))
    {
      this.b.setState(0);
      RefreshHeaderView.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.4
 * JD-Core Version:    0.7.0.1
 */