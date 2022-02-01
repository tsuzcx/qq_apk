package com.tencent.biz.qqstory.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RotateCircleImageView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  RotateCircleImageView$5(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.RotateCircleImageView.5
 * JD-Core Version:    0.7.0.1
 */