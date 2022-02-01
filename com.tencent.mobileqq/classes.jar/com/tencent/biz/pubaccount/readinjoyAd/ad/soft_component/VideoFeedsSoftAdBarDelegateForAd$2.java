package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForAd$2
  extends AnimatorListenerAdapter
{
  VideoFeedsSoftAdBarDelegateForAd$2(VideoFeedsSoftAdBarDelegateForAd paramVideoFeedsSoftAdBarDelegateForAd, VideoItemHolder paramVideoItemHolder) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.2
 * JD-Core Version:    0.7.0.1
 */