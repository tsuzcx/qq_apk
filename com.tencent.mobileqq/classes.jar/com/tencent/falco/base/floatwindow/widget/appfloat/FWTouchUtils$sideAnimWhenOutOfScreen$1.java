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
final class FWTouchUtils$sideAnimWhenOutOfScreen$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FWTouchUtils$sideAnimWhenOutOfScreen$1(WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WindowManager.LayoutParams localLayoutParams = this.$params;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    localLayoutParams.x = ((Integer)paramValueAnimator).intValue();
    this.$windowManager.updateViewLayout(this.$view, (ViewGroup.LayoutParams)this.$params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils.sideAnimWhenOutOfScreen.1
 * JD-Core Version:    0.7.0.1
 */