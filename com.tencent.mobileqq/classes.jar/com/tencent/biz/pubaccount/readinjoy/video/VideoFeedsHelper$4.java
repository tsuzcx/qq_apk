package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class VideoFeedsHelper$4
  extends AnimatorListenerAdapter
{
  VideoFeedsHelper$4(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setAlpha(1.0F);
    this.a.setLayerType(0, null);
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.4
 * JD-Core Version:    0.7.0.1
 */