package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SixCombolEffectView$10
  implements ValueAnimator.AnimatorUpdateListener
{
  SixCombolEffectView$10(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.a < 0.52F)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.10
 * JD-Core Version:    0.7.0.1
 */