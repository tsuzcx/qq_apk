package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.Animator;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class DigitLottieAnimation$1
  extends D8SafeAnimatorListener
{
  DigitLottieAnimation$1(DigitLottieAnimation paramDigitLottieAnimation) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.d("DigitLottieAnimation", 2, "onAnimationEnd");
    DigitLottieAnimation.a(this.a).remove();
    if (DigitLottieAnimation.a(this.a).isEmpty())
    {
      this.a.c();
      return;
    }
    ThreadManagerV2.executeOnSubThread(new DigitLottieAnimation.1.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation.1
 * JD-Core Version:    0.7.0.1
 */