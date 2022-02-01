package com.tencent.mobileqq.activity.aio.intimate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;

class IntimateScoreCardView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  IntimateScoreCardView$3(IntimateScoreCardView paramIntimateScoreCardView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f < 0.5F)
    {
      IntimateScoreCardView.a(this.a).setAlpha(1.0F - f * 2.0F);
      return;
    }
    IntimateScoreCardView.a(this.a).setAlpha(f * 2.0F - 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView.3
 * JD-Core Version:    0.7.0.1
 */