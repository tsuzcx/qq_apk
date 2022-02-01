package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

final class AnimatorFactory$2
  extends D8SafeAnimatorListener
{
  AnimatorFactory$2(AnimatorFactory.AnimatorListener paramAnimatorListener, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener;
    if (paramAnimator != null) {
      paramAnimator.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener;
    if (paramAnimator != null) {
      paramAnimator.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener;
    if (paramAnimator != null) {
      paramAnimator.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory.2
 * JD-Core Version:    0.7.0.1
 */