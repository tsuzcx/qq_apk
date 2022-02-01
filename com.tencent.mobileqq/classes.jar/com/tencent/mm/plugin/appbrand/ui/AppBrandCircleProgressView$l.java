package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class AppBrandCircleProgressView$l
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBrandCircleProgressView$l(AppBrandCircleProgressView paramAppBrandCircleProgressView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppBrandCircleProgressView localAppBrandCircleProgressView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "animation");
    AppBrandCircleProgressView.a(localAppBrandCircleProgressView, paramValueAnimator.getCurrentPlayTime());
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f1 = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.a;
      float f2 = AppBrandCircleProgressView.a(paramValueAnimator);
      double d = f1;
      AppBrandCircleProgressView.a(paramValueAnimator, f2 * (float)Math.cos(d));
      paramValueAnimator = this.a;
      AppBrandCircleProgressView.b(paramValueAnimator, AppBrandCircleProgressView.a(paramValueAnimator) * (float)Math.sin(d));
      paramValueAnimator = this.a;
      d = f1 * 360.0F;
      Double.isNaN(d);
      AppBrandCircleProgressView.c(paramValueAnimator, (float)(d / 6.283185307179586D));
      this.a.invalidate();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView.l
 * JD-Core Version:    0.7.0.1
 */