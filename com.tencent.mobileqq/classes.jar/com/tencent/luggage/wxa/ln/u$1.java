package com.tencent.luggage.wxa.ln;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.luggage.wxa.jx.bd;

class u$1
  implements Runnable
{
  u$1(u paramu, com.tencent.luggage.wxa.iu.b paramb, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, double paramDouble) {}
  
  public void run()
  {
    com.tencent.mm.plugin.appbrand.page.u localu = bd.a(this.a);
    if (localu == null)
    {
      this.a.a(this.b, this.h.b("fail:page don't exist"));
      return;
    }
    if (!localu.d()) {
      return;
    }
    int i = localu.ah().getBackgroundColor();
    int j = localu.ah().getForegroundColor();
    double d1 = localu.ah().getBackgroundAlpha();
    Object localObject = null;
    if ("linear".equals(this.c)) {
      localObject = new LinearInterpolator();
    } else if ("easeIn".equals(this.c)) {
      localObject = new AccelerateInterpolator();
    } else if ("easeOut".equals(this.c)) {
      localObject = new DecelerateInterpolator();
    } else if ("easeInOut".equals(this.c)) {
      localObject = new AccelerateDecelerateInterpolator();
    }
    ValueAnimator localValueAnimator1 = new ValueAnimator();
    localValueAnimator1.setIntValues(new int[] { i, this.d });
    localValueAnimator1.setEvaluator(new ArgbEvaluator());
    localValueAnimator1.setDuration(this.e);
    localValueAnimator1.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator1.addUpdateListener(new u.1.1(this, localu));
    ValueAnimator localValueAnimator2 = new ValueAnimator();
    localValueAnimator2.setIntValues(new int[] { j, this.f });
    localValueAnimator2.setEvaluator(new ArgbEvaluator());
    localValueAnimator2.setDuration(this.e);
    localValueAnimator2.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator2.addUpdateListener(new u.1.2(this, localu));
    ValueAnimator localValueAnimator3 = new ValueAnimator();
    localValueAnimator3.setFloatValues(new float[] { (float)d1, (float)this.g });
    localValueAnimator3.setDuration(this.e);
    localValueAnimator3.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator3.addUpdateListener(new u.1.3(this, localu));
    localValueAnimator1.start();
    localValueAnimator2.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.u.1
 * JD-Core Version:    0.7.0.1
 */