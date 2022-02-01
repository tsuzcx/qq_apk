package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoFeedsDiversionHandler$handleDiversionPriority$3
  extends Lambda
  implements Function0<Unit>
{
  VideoFeedsDiversionHandler$handleDiversionPriority$3(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AdvertisementInfo localAdvertisementInfo = this.$videoInfo.a;
    VideoInfo.GameAdComData localGameAdComData = this.$videoInfo.a.gameAdComData;
    VideoFeedsDiversionHandler.a(VideoFeedsDiversionHandler.a, this.$videoInfo);
    localAdvertisementInfo.gameAdComData = localGameAdComData;
    this.$videoInfo.a = localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDiversionHandler.handleDiversionPriority.3
 * JD-Core Version:    0.7.0.1
 */