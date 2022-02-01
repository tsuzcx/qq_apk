package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleGoHomeButtonPart$3
  extends QCircleD8SafeAnimatorListener
{
  QCircleGoHomeButtonPart$3(QCircleGoHomeButtonPart paramQCircleGoHomeButtonPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCircleGoHomeButtonPart.c(this.a) != null) {
      QCircleGoHomeButtonPart.c(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart.3
 * JD-Core Version:    0.7.0.1
 */