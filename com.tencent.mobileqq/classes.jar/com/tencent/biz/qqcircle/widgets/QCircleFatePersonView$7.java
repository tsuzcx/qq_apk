package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleFatePersonView$7
  extends QCircleD8SafeAnimatorListener
{
  QCircleFatePersonView$7(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QCircleFatePersonView.g(this.a) != null) {
      QCircleFatePersonView.g(this.a).setVisibility(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCircleFatePersonView.g(this.a) != null) {
      QCircleFatePersonView.g(this.a).setVisibility(0);
    }
    if (QCircleFatePersonView.f(this.a) != null) {
      QCircleFatePersonView.f(this.a).setEnabled(true);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.7
 * JD-Core Version:    0.7.0.1
 */