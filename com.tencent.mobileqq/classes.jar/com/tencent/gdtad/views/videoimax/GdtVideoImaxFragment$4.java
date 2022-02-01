package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class GdtVideoImaxFragment$4
  implements ValueAnimator.AnimatorUpdateListener
{
  GdtVideoImaxFragment$4(GdtVideoImaxFragment paramGdtVideoImaxFragment, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    float f2 = this.jdField_a_of_type_Float;
    f1 = f2 + (this.b - f2) * f1;
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimationUpdate() called with: current = [");
    paramValueAnimator.append(f1);
    paramValueAnimator.append("]");
    GdtLog.a("GdtVideoImaxFragment", paramValueAnimator.toString());
    paramValueAnimator = GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).getLayoutParams();
    paramValueAnimator.height = ((int)f1);
    GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).getLayoutParams();
    paramValueAnimator.height = Math.abs((int)(this.jdField_a_of_type_Int - f1));
    GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.4
 * JD-Core Version:    0.7.0.1
 */