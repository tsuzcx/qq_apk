package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 15})
final class FWTouchUtils$sideAnim$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FWTouchUtils$sideAnim$1(boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (this.$isX)
    {
      localLayoutParams = this.$params;
      Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      localLayoutParams.x = ((Integer)paramValueAnimator).intValue();
    }
    for (;;)
    {
      this.$windowManager.updateViewLayout(this.$view, (ViewGroup.LayoutParams)this.$params);
      return;
      localLayoutParams = this.$params;
      Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      localLayoutParams.y = ((Integer)paramValueAnimator).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils.sideAnim.1
 * JD-Core Version:    0.7.0.1
 */