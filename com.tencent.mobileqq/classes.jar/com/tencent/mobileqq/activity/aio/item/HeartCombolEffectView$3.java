package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HeartCombolEffectView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  HeartCombolEffectView$3(HeartCombolEffectView paramHeartCombolEffectView, HeartCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView$OneHeartTracker.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView.3
 * JD-Core Version:    0.7.0.1
 */