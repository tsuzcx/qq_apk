package com.tencent.luggage.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;
import kotlin.jvm.functions.Function0;

class a$1
  implements Runnable
{
  a$1(a parama, Function0 paramFunction0) {}
  
  public void run()
  {
    a.a(this.b).b();
    Object localObject = this.b.getParent();
    if (!(localObject instanceof ViewGroup)) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new a.1.1(this, (ViewParent)localObject));
    localValueAnimator.setStartDelay(Math.round(144.0F));
    localValueAnimator.setDuration(Math.round(36.0F));
    localValueAnimator.setInterpolator(new FastOutLinearInInterpolator());
    localValueAnimator.start();
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(Math.round(144.0F));
    ((ValueAnimator)localObject).addUpdateListener(new a.1.2(this));
    ((ValueAnimator)localObject).setInterpolator(new FastOutSlowInInterpolator());
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a.1
 * JD-Core Version:    0.7.0.1
 */