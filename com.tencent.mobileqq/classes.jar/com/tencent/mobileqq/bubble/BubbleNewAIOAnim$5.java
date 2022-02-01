package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

class BubbleNewAIOAnim$5
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$5(BubbleNewAIOAnim paramBubbleNewAIOAnim, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.5
 * JD-Core Version:    0.7.0.1
 */