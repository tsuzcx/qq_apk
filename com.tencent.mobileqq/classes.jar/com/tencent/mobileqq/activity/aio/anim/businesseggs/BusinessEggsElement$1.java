package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class BusinessEggsElement$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BusinessEggsElement$1(BusinessEggsElement paramBusinessEggsElement) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    BusinessEggsElement.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsElement.1
 * JD-Core Version:    0.7.0.1
 */