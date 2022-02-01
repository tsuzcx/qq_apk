package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

class AppBrandUILoadingSplash$3$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBrandUILoadingSplash$3$2(AppBrandUILoadingSplash.3 param3, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    AppBrandUILoadingSplash.d(this.b.b).setTextColor(Color.argb(Math.round(255.0F * f), Color.red(this.a), Color.green(this.a), Color.blue(this.a)));
    AppBrandUILoadingSplash.b(this.b.b).setAlpha(f);
    AppBrandUILoadingSplash.e(this.b.b).setAlpha(f);
    AppBrandUILoadingSplash.f(this.b.b).setAlpha(f);
    this.b.b.a(this.b.b.getResources().getColor(2131165190), AppBrandUILoadingSplash.c(this.b.b) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.3.2
 * JD-Core Version:    0.7.0.1
 */