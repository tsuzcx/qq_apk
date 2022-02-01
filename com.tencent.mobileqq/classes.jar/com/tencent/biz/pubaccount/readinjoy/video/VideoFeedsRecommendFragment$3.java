package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class VideoFeedsRecommendFragment$3
  implements View.OnLayoutChangeListener
{
  private int jdField_a_of_type_Int;
  
  VideoFeedsRecommendFragment$3(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, Configuration paramConfiguration) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).getHeight() != this.jdField_a_of_type_Int) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null))
    {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).c();
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).c();
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).b()) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null)) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a.f(true);
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(this.jdField_a_of_type_AndroidContentResConfiguration);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "onConfigurationChanged onLayoutChange: " + Arrays.toString(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getActivity())));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).getHeight();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "onConfigurationChanged onLayoutChange: screen size unchanged " + Arrays.toString(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getActivity())));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */