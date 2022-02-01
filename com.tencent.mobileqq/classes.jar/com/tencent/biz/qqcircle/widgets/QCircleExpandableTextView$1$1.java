package com.tencent.biz.qqcircle.widgets;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QCircleExpandableTextView$1$1
  implements Animation.AnimationListener
{
  QCircleExpandableTextView$1$1(QCircleExpandableTextView.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.l = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.l = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.1.1
 * JD-Core Version:    0.7.0.1
 */