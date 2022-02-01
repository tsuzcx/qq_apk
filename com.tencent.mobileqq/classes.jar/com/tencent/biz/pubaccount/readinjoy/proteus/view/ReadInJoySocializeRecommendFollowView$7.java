package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class ReadInJoySocializeRecommendFollowView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoySocializeRecommendFollowView$7(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ReadInJoySocializeRecommendFollowView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    ReadInJoySocializeRecommendFollowView.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.7
 * JD-Core Version:    0.7.0.1
 */