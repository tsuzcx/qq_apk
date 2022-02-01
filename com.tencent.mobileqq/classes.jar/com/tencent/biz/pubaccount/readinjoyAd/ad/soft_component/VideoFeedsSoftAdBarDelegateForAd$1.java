package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

class VideoFeedsSoftAdBarDelegateForAd$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoFeedsSoftAdBarDelegateForAd$1(VideoFeedsSoftAdBarDelegateForAd paramVideoFeedsSoftAdBarDelegateForAd, int paramInt1, int paramInt2, ViewGroup.LayoutParams paramLayoutParams, int paramInt3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = f1 / 2.0F + 0.5F;
    VideoFeedsSoftAdBarDelegateForAd.a(this.e).setPivotX(0.0F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.e).setPivotY(0.0F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.e).setScaleX(f2);
    VideoFeedsSoftAdBarDelegateForAd.a(this.e).setScaleY(f2);
    VideoFeedsSoftAdBarDelegateForAd.a(this.e).setAlpha(f1);
    int i = this.a;
    int j = this.b;
    paramValueAnimator = this.c;
    paramValueAnimator.width = ((int)(j + (i - j) * f1));
    paramValueAnimator.height = ((int)(this.d * f1));
    VideoFeedsSoftAdBarDelegateForAd.b(this.e).setLayoutParams(this.c);
    VideoFeedsSoftAdBarDelegateForAd.b(this.e).setAlpha(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.1
 * JD-Core Version:    0.7.0.1
 */