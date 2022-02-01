package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import sii;
import uga;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VideoFeedsDiversionHandler$handleDiversionPriority$2
  extends Lambda
  implements Function0<Unit>
{
  public VideoFeedsDiversionHandler$handleDiversionPriority$2(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AdvertisementInfo localAdvertisementInfo = this.$videoInfo.a;
    uga localuga = this.$videoInfo.a.mAdvertisementSoftInfo;
    sii.a(sii.a, this.$videoInfo);
    localAdvertisementInfo.mAdvertisementSoftInfo = localuga;
    this.$videoInfo.a = localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDiversionHandler.handleDiversionPriority.2
 * JD-Core Version:    0.7.0.1
 */