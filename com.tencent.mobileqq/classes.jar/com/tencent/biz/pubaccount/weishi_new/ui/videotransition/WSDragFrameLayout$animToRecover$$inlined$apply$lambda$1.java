package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSDragFrameLayout$animToRecover$1$1"}, k=3, mv={1, 1, 16})
final class WSDragFrameLayout$animToRecover$$inlined$apply$lambda$1
  implements ValueAnimator.AnimatorUpdateListener
{
  WSDragFrameLayout$animToRecover$$inlined$apply$lambda$1(WSDragFrameLayout paramWSDragFrameLayout, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = 1;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    float f2 = f1 - paramValueAnimator.getAnimatedFraction();
    this.a.setTranslationX(this.b * f2);
    this.a.setTranslationY(this.c * f2);
    WSDragFrameLayout localWSDragFrameLayout = this.a;
    f2 = this.d;
    localWSDragFrameLayout.setScaleX(f2 + (f1 - f2) * paramValueAnimator.getAnimatedFraction());
    paramValueAnimator = this.a;
    paramValueAnimator.setScaleY(paramValueAnimator.getScaleX());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout.animToRecover..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */