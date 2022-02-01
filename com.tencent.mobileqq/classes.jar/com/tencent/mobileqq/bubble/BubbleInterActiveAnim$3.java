package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class BubbleInterActiveAnim$3
  extends D8SafeAnimatorListener
{
  BubbleInterActiveAnim$3(BubbleInterActiveAnim paramBubbleInterActiveAnim, BubbleInterActiveAnim.AnimHolder paramAnimHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationCancel ");
      paramAnimator.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
      QLog.i("BubbleInterActiveAnim", 2, paramAnimator.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationEnd ");
      paramAnimator.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
      QLog.i("BubbleInterActiveAnim", 2, paramAnimator.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationRepeat ");
      paramAnimator.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
      QLog.i("BubbleInterActiveAnim", 2, paramAnimator.toString());
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationStart ");
      paramAnimator.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
      QLog.i("BubbleInterActiveAnim", 2, paramAnimator.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.3
 * JD-Core Version:    0.7.0.1
 */