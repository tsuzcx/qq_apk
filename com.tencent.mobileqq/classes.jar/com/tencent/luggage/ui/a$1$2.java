package com.tencent.luggage.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;

class a$1$2
  implements ValueAnimator.AnimatorUpdateListener
{
  a$1$2(a.1 param1) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    a.c(this.a.b).setTextColor(Color.argb(Math.round(255.0F * f), 0, 0, 0));
    a.a(this.a.b).setAlpha(f);
    a.d(this.a.b).setAlpha(f);
    a.d(this.a.b).setScaleY(f);
    a.d(this.a.b).setScaleX(f);
    this.a.b.a(-1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a.1.2
 * JD-Core Version:    0.7.0.1
 */