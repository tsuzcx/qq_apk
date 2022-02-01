package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoFeedsDiversionHandler$handleDiversionPriority$2
  extends Lambda
  implements Function0<Unit>
{
  VideoFeedsDiversionHandler$handleDiversionPriority$2(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AdvertisementInfo localAdvertisementInfo = this.$videoInfo.a;
    AdvertisementSoftInfo localAdvertisementSoftInfo = this.$videoInfo.a.mAdvertisementSoftInfo;
    VideoFeedsDiversionHandler.a(VideoFeedsDiversionHandler.a, this.$videoInfo);
    localAdvertisementInfo.mAdvertisementSoftInfo = localAdvertisementSoftInfo;
    this.$videoInfo.a = localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDiversionHandler.handleDiversionPriority.2
 * JD-Core Version:    0.7.0.1
 */