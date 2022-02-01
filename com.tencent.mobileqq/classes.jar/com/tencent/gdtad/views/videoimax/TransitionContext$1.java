package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.gdtad.log.GdtLog;

class TransitionContext$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TransitionContext$1(TransitionContext paramTransitionContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    int j = this.jdField_a_of_type_Int;
    int k = Math.round((0 - j) * f1);
    int m = this.b;
    int n = Math.round((0 - m) * f1);
    int i1 = this.c;
    int i2 = Math.round((this.d - i1) * f1);
    if (this.e < TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight()) {
      i = TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight();
    } else {
      i = this.e;
    }
    int i3 = this.f;
    int i = Math.round((i - i3) * f1);
    this.jdField_a_of_type_AndroidGraphicsRect.set(j + k, m + n, i1 + i2, i3 + i);
    TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).setClipBoundsCompact(this.jdField_a_of_type_AndroidGraphicsRect);
    TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).invalidate();
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimationUpdate() mPreviewView.getHeight = [");
    paramValueAnimator.append(TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight());
    paramValueAnimator.append("]");
    GdtLog.a("TransitionContext", paramValueAnimator.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext.1
 * JD-Core Version:    0.7.0.1
 */