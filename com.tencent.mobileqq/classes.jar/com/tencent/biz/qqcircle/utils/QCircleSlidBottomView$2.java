package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleSlidBottomView$2
  extends QCircleD8SafeAnimatorListener
{
  QCircleSlidBottomView$2(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QCircleSlidBottomView.a(this.a) != null) {
      QCircleSlidBottomView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.2
 * JD-Core Version:    0.7.0.1
 */