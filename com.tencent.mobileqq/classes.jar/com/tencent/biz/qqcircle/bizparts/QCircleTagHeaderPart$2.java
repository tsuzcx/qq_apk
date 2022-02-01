package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleTagHeaderPart$2
  extends QCircleD8SafeAnimatorListener
{
  QCircleTagHeaderPart$2(QCircleTagHeaderPart paramQCircleTagHeaderPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCircleTagHeaderPart.a(this.a) != null) {
      QCircleTagHeaderPart.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart.2
 * JD-Core Version:    0.7.0.1
 */