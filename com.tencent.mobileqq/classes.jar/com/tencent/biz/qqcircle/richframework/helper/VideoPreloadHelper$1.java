package com.tencent.biz.qqcircle.richframework.helper;

import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper.VideoUrlAdapterCallBack;
import com.tencent.biz.qqcircle.richframework.video.QCircleVideoUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StVideo;

class VideoPreloadHelper$1
  implements QCircleVideoExchangeHelper.VideoUrlAdapterCallBack
{
  VideoPreloadHelper$1(VideoPreloadHelper paramVideoPreloadHelper, boolean paramBoolean, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    if (!VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      this.c.a(this.b.fileId.get(), QCircleVideoUtils.a(this.b), this.b.duration.get(), this.a);
    }
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    this.c.a(paramStVideo.fileId.get(), QCircleVideoUtils.a(paramStVideo), paramStVideo.duration.get(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */