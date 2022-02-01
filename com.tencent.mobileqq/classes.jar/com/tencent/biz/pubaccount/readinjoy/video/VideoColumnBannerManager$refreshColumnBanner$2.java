package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$refreshColumnBanner$2
  implements View.OnClickListener
{
  VideoColumnBannerManager$refreshColumnBanner$2(VideoColumnBannerManager paramVideoColumnBannerManager, VideoInfo paramVideoInfo, ShortVideoItemHolder paramShortVideoItemHolder) {}
  
  public final void onClick(View paramView)
  {
    VideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.refreshColumnBanner.2
 * JD-Core Version:    0.7.0.1
 */