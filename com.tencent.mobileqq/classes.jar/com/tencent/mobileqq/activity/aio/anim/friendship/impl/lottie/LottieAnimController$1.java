package com.tencent.mobileqq.activity.aio.anim.friendship.impl.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class LottieAnimController$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LottieAnimController$1(LottieAnimController paramLottieAnimController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (LottieAnimController.a(this.a) != null) {
      LottieAnimController.a(this.a).setAlpha((float)d);
    }
    if (LottieAnimController.a(this.a) != null) {
      LottieAnimController.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.lottie.LottieAnimController.1
 * JD-Core Version:    0.7.0.1
 */