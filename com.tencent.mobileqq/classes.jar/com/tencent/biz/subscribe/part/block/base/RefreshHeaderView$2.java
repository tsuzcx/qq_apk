package com.tencent.biz.subscribe.part.block.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RefreshHeaderView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  RefreshHeaderView$2(RefreshHeaderView paramRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.a == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0)) {
      this.b.setState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.2
 * JD-Core Version:    0.7.0.1
 */