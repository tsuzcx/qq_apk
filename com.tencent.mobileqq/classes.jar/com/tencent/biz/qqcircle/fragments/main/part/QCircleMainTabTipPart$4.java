package com.tencent.biz.qqcircle.fragments.main.part;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QCircleMainTabTipPart$4
  implements Animation.AnimationListener
{
  QCircleMainTabTipPart$4(QCircleMainTabTipPart paramQCircleMainTabTipPart) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleMainTabTipPart.c(this.a).setVisibility(8);
    QCircleMainTabTipPart.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart.4
 * JD-Core Version:    0.7.0.1
 */