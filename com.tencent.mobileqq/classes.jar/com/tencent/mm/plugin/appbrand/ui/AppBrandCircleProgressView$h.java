package com.tencent.mm.plugin.appbrand.ui;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class AppBrandCircleProgressView$h
  extends Lambda
  implements Function0<ValueAnimator>
{
  AppBrandCircleProgressView$h(AppBrandCircleProgressView paramAppBrandCircleProgressView)
  {
    super(0);
  }
  
  public final ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)-1.570796326794897D, (float)4.71238898038469D });
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setDuration(this.a.getAnimDuration());
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView.h
 * JD-Core Version:    0.7.0.1
 */