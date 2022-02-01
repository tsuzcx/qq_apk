package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import odl;
import rpe;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VideoFeedsDiversionHandler$handleDiversionPriority$5
  extends Lambda
  implements Function0<Unit>
{
  public VideoFeedsDiversionHandler$handleDiversionPriority$5(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    odl localodl1 = this.$videoInfo.a;
    odl localodl2 = this.$videoInfo.b;
    rpe.a(rpe.a, this.$videoInfo);
    this.$videoInfo.a = localodl1;
    this.$videoInfo.b = localodl2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDiversionHandler.handleDiversionPriority.5
 * JD-Core Version:    0.7.0.1
 */