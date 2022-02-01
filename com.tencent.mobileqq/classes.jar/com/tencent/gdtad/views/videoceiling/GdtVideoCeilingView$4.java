package com.tencent.gdtad.views.videoceiling;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class GdtVideoCeilingView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  GdtVideoCeilingView$4(GdtVideoCeilingView paramGdtVideoCeilingView, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    paramValueAnimator.topMargin = (this.b + (int)(f1 * this.c));
    if (((paramValueAnimator.topMargin < 1) || (this.a.topMargin >= GdtVideoCeilingView.c(this.f))) && (this.d.c))
    {
      GdtVideoCeilingView.a(this.f, this.a, this.d, this.e);
      return;
    }
    paramValueAnimator = this.d;
    if (paramValueAnimator != null) {
      paramValueAnimator.setLayoutParams(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView.4
 * JD-Core Version:    0.7.0.1
 */