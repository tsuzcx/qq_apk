package com.tencent.biz.widgets;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class TabLayout$2
  implements Animator.AnimatorListener
{
  TabLayout$2(TabLayout paramTabLayout, Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationCancel(paramAnimator);
    TabLayout.a(this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(paramAnimator);
    TabLayout.a(this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationRepeat(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.2
 * JD-Core Version:    0.7.0.1
 */