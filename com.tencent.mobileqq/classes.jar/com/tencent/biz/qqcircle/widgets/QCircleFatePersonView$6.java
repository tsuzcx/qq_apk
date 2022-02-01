package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.widget.ImageView;

class QCircleFatePersonView$6
  extends AnimatorListenerAdapter
{
  QCircleFatePersonView$6(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if ((QCircleFatePersonView.e(this.a) != null) && (QCircleFatePersonView.e(this.a).isRunning())) {
      QCircleFatePersonView.e(this.a).cancel();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setEnabled(true);
    QCircleFatePersonView.h(this.a).setRotationY(-90.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setEnabled(false);
    if (QCircleFatePersonView.g(this.a) != null) {
      QCircleFatePersonView.g(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.6
 * JD-Core Version:    0.7.0.1
 */