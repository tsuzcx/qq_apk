package com.tencent.mm.plugin.appbrand.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class e$2
  implements ValueAnimator.AnimatorUpdateListener
{
  e$2(e parame, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = this.a;
    int j = (int)((this.b * 1.0F - i) * f);
    int k = this.c;
    int m = (int)((this.d * 1.0F - k) * f);
    e.a(this.e, i + j, k + m, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.2
 * JD-Core Version:    0.7.0.1
 */