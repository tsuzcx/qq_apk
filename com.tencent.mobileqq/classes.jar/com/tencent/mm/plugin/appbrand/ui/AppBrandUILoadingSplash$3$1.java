package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewParent;

class AppBrandUILoadingSplash$3$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBrandUILoadingSplash$3$1(AppBrandUILoadingSplash.3 param3, int paramInt, ViewParent paramViewParent) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = Color.argb(i, Color.red(this.a), Color.green(this.a), Color.blue(this.a));
    AppBrandUILoadingSplash.a(this.c.b).setBackgroundColor(j);
    AppBrandUILoadingSplash.a(this.c.b, j, AppBrandUILoadingSplash.c(this.c.b) ^ true);
    if (i == 0) {
      this.c.b.post(new AppBrandUILoadingSplash.3.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.3.1
 * JD-Core Version:    0.7.0.1
 */