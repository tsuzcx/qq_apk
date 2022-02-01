package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 15})
final class FWTouchUtils$sideAnimWhenOutOfScreen$3
  implements ValueAnimator.AnimatorUpdateListener
{
  FWTouchUtils$sideAnimWhenOutOfScreen$3(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WindowManager.LayoutParams localLayoutParams = this.$params;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      localLayoutParams.y = ((Integer)paramValueAnimator).intValue();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils.sideAnimWhenOutOfScreen.3
 * JD-Core Version:    0.7.0.1
 */