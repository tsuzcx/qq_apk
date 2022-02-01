package com.tencent.luggage.wxa.bm;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class b$4
  implements ValueAnimator.AnimatorUpdateListener
{
  int a = b.c(this.b);
  
  b$4(b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    b.d(this.b).a(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a);
    b.d(this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.b.4
 * JD-Core Version:    0.7.0.1
 */