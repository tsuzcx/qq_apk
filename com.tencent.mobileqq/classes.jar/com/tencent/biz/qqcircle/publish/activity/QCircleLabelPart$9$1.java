package com.tencent.biz.qqcircle.publish.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCircleLabelPart$9$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleLabelPart$9$1(QCircleLabelPart.9 param9) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.a(QCircleLabelPart.j(this.a.a), (int)f);
    QCircleLabelPart.b(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.9.1
 * JD-Core Version:    0.7.0.1
 */