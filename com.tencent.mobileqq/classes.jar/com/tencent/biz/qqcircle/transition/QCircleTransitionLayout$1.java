package com.tencent.biz.qqcircle.transition;

import android.animation.Animator;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleTransitionLayout$1
  extends QCircleD8SafeAnimatorListener
{
  QCircleTransitionLayout$1(QCircleTransitionLayout paramQCircleTransitionLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QCircleTransitionLayout.a(this.a) != null) {
      QCircleTransitionLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionLayout.1
 * JD-Core Version:    0.7.0.1
 */