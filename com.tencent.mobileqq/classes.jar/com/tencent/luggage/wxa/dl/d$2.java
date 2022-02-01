package com.tencent.luggage.wxa.dl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class d$2
  implements ValueAnimator.AnimatorUpdateListener
{
  d$2(d paramd) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (FrameLayout.LayoutParams)d.a(this.a).getLayoutParams();
    paramValueAnimator.topMargin = (d.b(this.a).getRect().top + (int)((d.c(this.a) - d.a(this.a).getHeight()) * f));
    d.a(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dl.d.2
 * JD-Core Version:    0.7.0.1
 */