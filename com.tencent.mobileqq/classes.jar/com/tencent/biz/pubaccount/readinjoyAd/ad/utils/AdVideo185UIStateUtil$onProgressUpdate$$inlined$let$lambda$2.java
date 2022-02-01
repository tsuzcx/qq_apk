package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.AdGuideClickListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "clickPos", "", "onAdGuideClick", "com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideo185UIStateUtil$onProgressUpdate$2$1"}, k=3, mv={1, 1, 16})
final class AdVideo185UIStateUtil$onProgressUpdate$$inlined$let$lambda$2
  implements ReadInJoyAdVideoGuide.AdGuideClickListener
{
  AdVideo185UIStateUtil$onProgressUpdate$$inlined$let$lambda$2(ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide, AdvertisementInfo paramAdvertisementInfo, RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager, VideoPlayParam paramVideoPlayParam) {}
  
  public final void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager;
    if (paramView != null) {
      paramView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.getContext(), paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */