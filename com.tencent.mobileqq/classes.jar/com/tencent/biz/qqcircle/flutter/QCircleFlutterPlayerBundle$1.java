package com.tencent.biz.qqcircle.flutter;

import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper.VideoUrlAdapterCallBack;
import com.tencent.biz.qqcircle.report.QCircleVideoReporter;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayer;
import com.tencent.biz.qqcircle.richframework.video.QCircleVideoUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Collections;

class QCircleFlutterPlayerBundle$1
  implements QCircleVideoExchangeHelper.VideoUrlAdapterCallBack
{
  QCircleFlutterPlayerBundle$1(QCircleFlutterPlayerBundle paramQCircleFlutterPlayerBundle, long paramLong, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setVideoPath][onChangeError] errorCode=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString);
    QLog.w("QCircleVideoFlutterBundle", 1, localStringBuilder.toString());
    if ((this.c.a != null) && (this.c.a.h())) {
      try
      {
        QCircleVideoReporter.a().a(this.c.a.p(), "video_exchange_url", this.b, Collections.singletonList(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong))));
        if (VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
          return;
        }
        paramString = QCircleVideoUtils.a(this.b.video);
        this.c.a.a(this.b.video.fileId.get(), paramString, (int)this.a);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QCircleVideoFlutterBundle", 1, "[onChangeError]", paramString);
        return;
      }
    }
    QLog.w("QCircleVideoFlutterBundle", 1, "[setVideoPath][onChangeError] invalid player");
    QCircleVideoReporter.a().a(-1L, "video_exchange_url", this.b, Collections.singletonList(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong))));
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    if ((this.c.a != null) && (this.c.a.h()))
    {
      try
      {
        String str = QCircleVideoUtils.a(paramStVideo);
        this.c.a.a(paramStVideo.fileId.get(), str, (int)this.a);
        if (!paramBoolean)
        {
          QCircleVideoReporter.a().a(this.c.a.p(), "video_exchange_url", this.b, Collections.singletonList(QCircleReportHelper.newEntry("ret_code", "0")));
          return;
        }
      }
      catch (Exception paramStVideo)
      {
        QLog.e("QCircleVideoFlutterBundle", 1, "[onChangeSuccess]", paramStVideo);
      }
      return;
    }
    QLog.w("QCircleVideoFlutterBundle", 1, "[setVideoPath][onChangeSuccess] invalid player");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterPlayerBundle.1
 * JD-Core Version:    0.7.0.1
 */