package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideo185UIStateUtil$onProgressUpdate$1$1"}, k=3, mv={1, 1, 16})
final class AdVideo185UIStateUtil$onProgressUpdate$$inlined$let$lambda$1
  implements View.OnClickListener
{
  AdVideo185UIStateUtil$onProgressUpdate$$inlined$let$lambda$1(ReadInJoyVideoAdHighLightBar paramReadInJoyVideoAdHighLightBar, AdvertisementInfo paramAdvertisementInfo, RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager, VideoPlayParam paramVideoPlayParam) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.c;
    if (paramView != null) {
      paramView.a(this.a.getContext(), 22, this.b, this.d.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */