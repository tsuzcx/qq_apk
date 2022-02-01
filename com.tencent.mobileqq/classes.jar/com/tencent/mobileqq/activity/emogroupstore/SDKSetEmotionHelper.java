package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.widget.ProgressBar;

public class SDKSetEmotionHelper
{
  public static ValueAnimator a(ProgressBar paramProgressBar, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt }).setDuration(500L);
    localValueAnimator.addUpdateListener(new SDKSetEmotionHelper.1(paramProgressBar));
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionHelper
 * JD-Core Version:    0.7.0.1
 */