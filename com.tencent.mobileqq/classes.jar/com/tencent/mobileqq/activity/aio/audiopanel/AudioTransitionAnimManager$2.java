package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class AudioTransitionAnimManager$2
  implements Animator.AnimatorListener
{
  AudioTransitionAnimManager$2(AudioTransitionAnimManager paramAudioTransitionAnimManager, LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationCancel drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationEnd drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    AudioTransitionAnimManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioTransitionAnimManager, paramAnimator, this.jdField_a_of_type_Int);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationStart drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    if ((AudioTransitionAnimUtils.a(this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getSpeed() > 0.0F)) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.reverseAnimationSpeed();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.invalidateDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.2
 * JD-Core Version:    0.7.0.1
 */