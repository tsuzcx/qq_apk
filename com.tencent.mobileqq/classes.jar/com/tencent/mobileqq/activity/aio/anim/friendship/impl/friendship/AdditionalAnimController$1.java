package com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class AdditionalAnimController$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AdditionalAnimController$1(AdditionalAnimController paramAdditionalAnimController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (AdditionalAnimController.a(this.a) != null) {
      AdditionalAnimController.a(this.a).setAlpha((float)d);
    }
    if (AdditionalAnimController.b(this.a) != null) {
      AdditionalAnimController.b(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship.AdditionalAnimController.1
 * JD-Core Version:    0.7.0.1
 */