package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CircularRevealAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CircularRevealAnimator$1(CircularRevealAnimator paramCircularRevealAnimator, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (CircularRevealAnimator.RevealCircle)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(paramValueAnimator.a, paramValueAnimator.b, paramValueAnimator.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.CircularRevealAnimator.1
 * JD-Core Version:    0.7.0.1
 */