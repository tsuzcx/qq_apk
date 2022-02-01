package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ADVideoFeedsGuideManager$1
  extends AnimatorListenerAdapter
{
  ADVideoFeedsGuideManager$1(ADVideoFeedsGuideManager paramADVideoFeedsGuideManager) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((ADVideoFeedsGuideManager.a(this.a) != null) && (ADVideoFeedsGuideManager.a(this.a).e != null))
    {
      ADVideoFeedsGuideManager.a(this.a).e.setVisibility(0);
      paramAnimator = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(ADVideoFeedsGuideManager.a(this.a).e, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(200L);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(ADVideoFeedsGuideManager.a(this.a).e, "translationY", new float[] { AIOUtils.b(15.0F, ADVideoFeedsGuideManager.a(this.a).e.getResources()), 0.0F });
      localObjectAnimator2.setDuration(200L);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      paramAnimator.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager.1
 * JD-Core Version:    0.7.0.1
 */