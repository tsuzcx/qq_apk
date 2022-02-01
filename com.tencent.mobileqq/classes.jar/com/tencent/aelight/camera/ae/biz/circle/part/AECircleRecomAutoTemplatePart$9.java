package com.tencent.aelight.camera.ae.biz.circle.part;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.core.view.ViewCompat;

class AECircleRecomAutoTemplatePart$9
  implements ValueAnimator.AnimatorUpdateListener
{
  AECircleRecomAutoTemplatePart$9(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart, int[] paramArrayOfInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      ViewCompat.offsetTopAndBottom(AECircleRecomAutoTemplatePart.i(this.b), paramValueAnimator.intValue() - this.a[0]);
      this.a[0] = paramValueAnimator.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.9
 * JD-Core Version:    0.7.0.1
 */