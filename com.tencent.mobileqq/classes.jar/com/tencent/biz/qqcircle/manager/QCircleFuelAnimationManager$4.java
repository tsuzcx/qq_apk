package com.tencent.biz.qqcircle.manager;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;

class QCircleFuelAnimationManager$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleFuelAnimationManager$4(QCircleFuelAnimationManager paramQCircleFuelAnimationManager, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    this.a.setX(paramValueAnimator.x);
    this.a.setY(paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.4
 * JD-Core Version:    0.7.0.1
 */