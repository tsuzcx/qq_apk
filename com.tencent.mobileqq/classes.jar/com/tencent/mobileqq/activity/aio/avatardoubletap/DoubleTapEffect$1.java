package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class DoubleTapEffect$1
  extends D8SafeAnimatorListener
{
  DoubleTapEffect$1(DoubleTapEffect paramDoubleTapEffect) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationCancel() called with: animation = [");
      localStringBuilder.append(paramAnimator);
      localStringBuilder.append("]");
      QLog.d("DoubleTapEffect", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationEnd() called with: animation = [");
      localStringBuilder.append(paramAnimator);
      localStringBuilder.append("]");
      QLog.d("DoubleTapEffect", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationRepeat() called with: animation = [");
      localStringBuilder.append(paramAnimator);
      localStringBuilder.append("]");
      QLog.d("DoubleTapEffect", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationStart() called with: animation = [");
      localStringBuilder.append(paramAnimator);
      localStringBuilder.append("]");
      QLog.d("DoubleTapEffect", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.DoubleTapEffect.1
 * JD-Core Version:    0.7.0.1
 */