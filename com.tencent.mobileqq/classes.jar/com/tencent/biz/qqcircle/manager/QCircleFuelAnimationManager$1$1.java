package com.tencent.biz.qqcircle.manager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.utils.ViewUtils;

class QCircleFuelAnimationManager$1$1
  extends AnimatorListenerAdapter
{
  QCircleFuelAnimationManager$1$1(QCircleFuelAnimationManager.1 param1, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.b.b.setVisibility(4);
    this.b.b.setX(this.a.x);
    this.b.b.setY(this.a.y + ViewUtils.a(5.0F));
    this.b.b.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.1.1
 * JD-Core Version:    0.7.0.1
 */