package com.tencent.biz.qqcircle.widgets.person;

import android.animation.Animator;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCirclePersonalPymkContainerView$2
  extends QCircleD8SafeAnimatorListener
{
  QCirclePersonalPymkContainerView$2(QCirclePersonalPymkContainerView paramQCirclePersonalPymkContainerView, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QCirclePersonalPymkContainerView.a(this.b, this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCirclePersonalPymkContainerView.a(this.b, this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.person.QCirclePersonalPymkContainerView.2
 * JD-Core Version:    0.7.0.1
 */