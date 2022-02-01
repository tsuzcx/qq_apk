package com.tencent.ilive.uicomponent.luxurygiftcomponent.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;

class GiftAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GiftAnimator$1(GiftAnimator paramGiftAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    PointF localPointF = (PointF)paramValueAnimator.getAnimatedValue();
    this.val$target.setTranslationX(localPointF.x);
    this.val$target.setTranslationY(localPointF.y);
    float f = 1.0F - paramValueAnimator.getAnimatedFraction() * 40.0F / 50.0F;
    this.val$target.setScaleX(f);
    this.val$target.setScaleY(f);
    this.val$target.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.anim.GiftAnimator.1
 * JD-Core Version:    0.7.0.1
 */