package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleSlidBottomView$3
  extends QCircleD8SafeAnimatorListener
{
  QCircleSlidBottomView$3(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCircleSlidBottomView.a(this.a) != null) {
      QCircleSlidBottomView.a(this.a).b();
    }
    this.a.setVisibility(8);
    QCircleSlidBottomView.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCircleSlidBottomView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.3
 * JD-Core Version:    0.7.0.1
 */