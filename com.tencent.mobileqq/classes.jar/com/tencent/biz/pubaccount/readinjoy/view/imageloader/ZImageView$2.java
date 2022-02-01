package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ZImageView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ZImageView$2(ZImageView paramZImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.setAlpha(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView.2
 * JD-Core Version:    0.7.0.1
 */