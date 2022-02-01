package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class AudioTransitionAnimManager$2
  extends D8SafeAnimatorListener
{
  AudioTransitionAnimManager$2(AudioTransitionAnimManager paramAudioTransitionAnimManager, LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("AIOAudioPanel onAnimationCancel drawable=");
      paramAnimator.append(this.a);
      QLog.d("AudioTransitionAnimManager", 2, paramAnimator.toString());
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOAudioPanel onAnimationEnd drawable=");
      localStringBuilder.append(this.a);
      QLog.d("AudioTransitionAnimManager", 2, localStringBuilder.toString());
    }
    AudioTransitionAnimManager.a(this.d, paramAnimator, this.b);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("AIOAudioPanel onAnimationStart drawable=");
      paramAnimator.append(this.a);
      QLog.d("AudioTransitionAnimManager", 2, paramAnimator.toString());
    }
    if ((AudioTransitionAnimUtils.a(this.b)) && (this.a.getSpeed() > 0.0F)) {
      this.a.reverseAnimationSpeed();
    }
    this.c.invalidateDrawable(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.2
 * JD-Core Version:    0.7.0.1
 */