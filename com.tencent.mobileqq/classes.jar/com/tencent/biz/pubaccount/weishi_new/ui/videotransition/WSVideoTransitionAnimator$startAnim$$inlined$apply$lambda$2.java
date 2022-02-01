package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimator$startAnim$1$2"}, k=3, mv={1, 1, 16})
final class WSVideoTransitionAnimator$startAnim$$inlined$apply$lambda$2
  implements ValueAnimator.AnimatorUpdateListener
{
  WSVideoTransitionAnimator$startAnim$$inlined$apply$lambda$2(AccelerateDecelerateInterpolator paramAccelerateDecelerateInterpolator, Function0 paramFunction01, Function0 paramFunction02, WSAnimConfig paramWSAnimConfig) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f6 = ((Float)paramValueAnimator).floatValue();
      float f1 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 1, f6);
      float f2 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 2, f6);
      float f3 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 3, f6);
      float f4 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 4, f6);
      int i = (int)WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 6, f6);
      float f5 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 7, f6);
      f6 = WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, this.d, 5, f6);
      WSVideoTransitionAnimator.a.a(this.d.a(), f1);
      WSVideoTransitionAnimator.a.a(this.d.a(), f2, f3);
      WSVideoTransitionAnimator.a.a(this.d.b(), this.d.a().getWidth(), f4, i);
      WSVideoTransitionAnimator.a.a(this.d.a(), (int)f5, (int)f6);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimator.startAnim..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */