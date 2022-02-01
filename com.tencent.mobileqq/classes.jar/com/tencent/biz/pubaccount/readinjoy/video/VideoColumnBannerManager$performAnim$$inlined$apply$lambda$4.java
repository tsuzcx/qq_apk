package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$1$2", "Lcom/tencent/mobileqq/activity/richmedia/AnimatorAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$4
  extends AnimatorAdapter
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$4(ShortVideoItemHolder paramShortVideoItemHolder, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.b();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.a;
        if ((paramAnimator != null) && (paramAnimator.a == true)) {
          VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c(), 0, (int)200L);
        }
      }
    }
    for (;;)
    {
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.b(), 8, (int)200L);
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c(), 0, (int)200L);
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d(), 0, (int)200L);
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e(), 0, (int)200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.f();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.f();
      if (paramAnimator != null) {
        paramAnimator.setScaleX(0.0F);
      }
      paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.f();
      if (paramAnimator != null) {
        paramAnimator.setScaleY(0.0F);
      }
      paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.f();
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.animate();
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.scaleX(1.0F);
          if (paramAnimator != null)
          {
            paramAnimator = paramAnimator.scaleY(1.0F);
            if (paramAnimator != null)
            {
              paramAnimator = paramAnimator.setDuration(200L);
              if (paramAnimator != null) {
                paramAnimator.start();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.4
 * JD-Core Version:    0.7.0.1
 */