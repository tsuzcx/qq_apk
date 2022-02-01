package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.tencent.luggage.wxa.qz.o;
import kotlin.jvm.functions.Function0;

class AppBrandUILoadingSplash$3
  implements Runnable
{
  AppBrandUILoadingSplash$3(AppBrandUILoadingSplash paramAppBrandUILoadingSplash, Function0 paramFunction0) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
    Object localObject = this.b.getParent();
    if (!(localObject instanceof ViewGroup))
    {
      o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
      return;
    }
    AppBrandUILoadingSplash.b(this.b).b();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new AppBrandUILoadingSplash.3.1(this, this.b.getResources().getColor(2131165190), (ViewParent)localObject));
    localValueAnimator.setStartDelay(Math.round(160.0F));
    localValueAnimator.setDuration(Math.round(40.0F));
    localValueAnimator.setInterpolator(new FastOutLinearInInterpolator());
    localValueAnimator.start();
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(Math.round(160.0F));
    ((ValueAnimator)localObject).addUpdateListener(new AppBrandUILoadingSplash.3.2(this, this.b.getResources().getColor(2131166595)));
    ((ValueAnimator)localObject).setInterpolator(new FastOutSlowInInterpolator());
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.3
 * JD-Core Version:    0.7.0.1
 */