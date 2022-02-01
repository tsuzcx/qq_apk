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
    float f2 = f1 / 2.0F;
    float f3 = f1 / 2.0F;
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setPivotX(0.0F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setPivotY(0.0F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setScaleX(f2 + 0.5F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setScaleY(f3 + 0.5F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setAlpha(f1);
    int i = this.jdField_a_of_type_Int;
    int j = this.b;
    paramValueAnimator = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
    f2 = this.b;
    paramValueAnimator.width = ((int)((i - j) * f1 + f2));
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(this.c * f1));
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    VideoFeedsSoftAdBarDelegateForAd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd).setAlpha(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.1
 * JD-Core Version:    0.7.0.1
 */