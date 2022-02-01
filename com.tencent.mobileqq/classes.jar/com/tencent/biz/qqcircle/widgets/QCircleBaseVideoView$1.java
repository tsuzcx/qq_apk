package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper.VideoUrlAdapterCallBack;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Collections;

class QCircleBaseVideoView$1
  implements QCircleVideoExchangeHelper.VideoUrlAdapterCallBack
{
  QCircleBaseVideoView$1(QCircleBaseVideoView paramQCircleBaseVideoView, int paramInt, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = this.c;
    QCircleBaseVideoView.b(paramString, paramString.getVideoPlayId(), "video_exchange_url", this.c.getData(), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong))));
    if (VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      return;
    }
    QCircleBaseVideoView.a(this.c, this.b, this.a);
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    QCircleBaseVideoView.a(this.c, paramStVideo, this.a);
    if (!paramBoolean)
    {
      paramStVideo = this.c;
      QCircleBaseVideoView.a(paramStVideo, paramStVideo.getVideoPlayId(), "video_exchange_url", this.c.getData(), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", "0")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView.1
 * JD-Core Version:    0.7.0.1
 */