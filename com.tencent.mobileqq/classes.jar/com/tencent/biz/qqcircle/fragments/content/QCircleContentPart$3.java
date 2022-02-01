package com.tencent.biz.qqcircle.fragments.content;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;

class QCircleContentPart$3
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleContentPart$3(QCircleContentPart paramQCircleContentPart) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    if ((QCircleContentPart.f(this.a) != null) && (QCircleContentPart.f(this.a).getBackground() != null)) {
      QCircleContentPart.f(this.a).getBackground().setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.3
 * JD-Core Version:    0.7.0.1
 */