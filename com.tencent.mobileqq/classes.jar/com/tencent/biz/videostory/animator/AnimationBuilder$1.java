package com.tencent.biz.videostory.animator;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class AnimationBuilder$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AnimationBuilder$1(AnimationBuilder paramAnimationBuilder, AnimationListener.Update paramUpdate, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Update.a(this.jdField_a_of_type_AndroidViewView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder.1
 * JD-Core Version:    0.7.0.1
 */