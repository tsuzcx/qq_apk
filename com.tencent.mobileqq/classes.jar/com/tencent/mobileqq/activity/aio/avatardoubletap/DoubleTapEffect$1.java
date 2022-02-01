package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class DoubleTapEffect$1
  implements Animator.AnimatorListener
{
  DoubleTapEffect$1(DoubleTapEffect paramDoubleTapEffect) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationCancel() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationEnd() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationRepeat() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationStart() called with: animation = [" + paramAnimator + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.DoubleTapEffect.1
 * JD-Core Version:    0.7.0.1
 */