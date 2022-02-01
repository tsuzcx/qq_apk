package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class o$22
  implements ValueAnimator.AnimatorUpdateListener
{
  o$22(o paramo, bg parambg, m paramm1, m paramm2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(paramValueAnimator.getAnimatedFraction() * 100.0F);
    o.k(this.d).a(this.a, this.b, this.c, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.22
 * JD-Core Version:    0.7.0.1
 */