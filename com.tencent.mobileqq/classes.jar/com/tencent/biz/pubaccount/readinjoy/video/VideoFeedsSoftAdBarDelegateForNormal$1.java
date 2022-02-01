package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForNormal$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoFeedsSoftAdBarDelegateForNormal$1(VideoFeedsSoftAdBarDelegateForNormal paramVideoFeedsSoftAdBarDelegateForNormal, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ViewGroup.LayoutParams paramLayoutParams1, int paramInt5, int paramInt6, int paramInt7, ViewGroup.LayoutParams paramLayoutParams2, int paramInt8, int paramInt9) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.width = (this.b + (int)(paramValueAnimator.getAnimatedFraction() * this.c));
    this.a.height = (this.d + (int)(paramValueAnimator.getAnimatedFraction() * this.e));
    VideoFeedsSoftAdBarDelegateForNormal.a(this.m).bE.setLayoutParams(this.a);
    this.f.width = (this.g + (int)(paramValueAnimator.getAnimatedFraction() * this.h));
    this.f.height = (this.i + (int)(paramValueAnimator.getAnimatedFraction() * this.h));
    VideoFeedsSoftAdBarDelegateForNormal.a(this.m).bu.setLayoutParams(this.f);
    this.j.width = (this.k + (int)(paramValueAnimator.getAnimatedFraction() * this.l));
    VideoFeedsSoftAdBarDelegateForNormal.a(this.m).bw.setLayoutParams(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal.1
 * JD-Core Version:    0.7.0.1
 */