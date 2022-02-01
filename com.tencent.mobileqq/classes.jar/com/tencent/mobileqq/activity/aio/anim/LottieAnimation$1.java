package com.tencent.mobileqq.activity.aio.anim;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class LottieAnimation$1
  implements Animator.AnimatorListener
{
  LottieAnimation$1(LottieAnimation paramLottieAnimation) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "onAnimationEnd");
    }
    LottieAnimation.a(this.a).remove();
    if (LottieAnimation.a(this.a).isEmpty()) {
      this.a.c();
    }
    while (LottieAnimation.a(this.a)) {
      return;
    }
    LottieAnimation.a(this.a).clear();
    this.a.c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation.1
 * JD-Core Version:    0.7.0.1
 */