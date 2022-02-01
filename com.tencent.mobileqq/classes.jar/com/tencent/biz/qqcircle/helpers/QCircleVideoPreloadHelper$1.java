package com.tencent.biz.qqcircle.helpers;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StVideo;

class QCircleVideoPreloadHelper$1
  implements QCircleVideoExchangeHelper.VideoUrlAdapterCallBack
{
  QCircleVideoPreloadHelper$1(QCircleVideoPreloadHelper paramQCircleVideoPreloadHelper, boolean paramBoolean, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    if (!VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      QCircleVideoPreloadHelper.b(this.c, this.b.fileId.get(), this.b.playUrl.get(), this.b.duration.get(), this.a);
    }
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    QCircleVideoPreloadHelper.a(this.c, paramStVideo.fileId.get(), paramStVideo.playUrl.get(), paramStVideo.duration.get(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */