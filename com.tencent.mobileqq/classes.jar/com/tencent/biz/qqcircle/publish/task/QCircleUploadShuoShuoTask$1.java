package com.tencent.biz.qqcircle.publish.task;

import android.os.Handler;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed.Builder;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;
import java.util.Arrays;

class QCircleUploadShuoShuoTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StPublishFeedRsp>
{
  QCircleUploadShuoShuoTask$1(QCircleUploadShuoShuoTask paramQCircleUploadShuoShuoTask) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" retCode:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" traceId:");
    ((StringBuilder)localObject).append(paramBaseRequest.getTraceId());
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, ((StringBuilder)localObject).toString());
    localObject = new QCircleUploadShuoShuoTask.ResultParmas();
    ((QCircleUploadShuoShuoTask.ResultParmas)localObject).a = paramLong;
    ((QCircleUploadShuoShuoTask.ResultParmas)localObject).b = paramString;
    ((QCircleUploadShuoShuoTask.ResultParmas)localObject).d = this.a.av;
    ((QCircleUploadShuoShuoTask.ResultParmas)localObject).e = paramBaseRequest.getTraceId();
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      ((QCircleUploadShuoShuoTask.ResultParmas)localObject).c = paramStPublishFeedRsp.feed.id.get();
    }
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      paramString = new QCircleFakeFeed.Builder().setFeedId(paramStPublishFeedRsp.feed.id.get()).setClientKey(this.a.av).setCreateTime(paramStPublishFeedRsp.feed.createTime.get()).setPuin(paramStPublishFeedRsp.feed.poster.id.get()).setFeedType(paramStPublishFeedRsp.feed.feedType.get()).setVideoPath(paramStPublishFeedRsp.feed.video.playUrl.get()).setCoverPath(paramStPublishFeedRsp.feed.cover.picUrl.get()).setWidth(paramStPublishFeedRsp.feed.cover.width.get()).setHeight(paramStPublishFeedRsp.feed.cover.height.get()).setDuration(paramStPublishFeedRsp.feed.video.duration.get()).build();
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.a.av });
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent(true));
      if (paramLong == 0L)
      {
        QCircleUploadShuoShuoTask.a(this.a);
        RFThreadManager.getSerialThreadHandler().postDelayed(QCircleUploadShuoShuoTask.b(this.a), 10000L);
      }
      QCircleUploadShuoShuoTask.a(this.a, paramString, 0, (QCircleUploadShuoShuoTask.ResultParmas)localObject);
    }
    else
    {
      if (paramLong == 10027L)
      {
        paramString = new QCircleFakeFeed.Builder().setClientKey(this.a.av).build();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramString, 3));
      }
      QCircleUploadShuoShuoTask.a(this.a, (QCircleUploadShuoShuoTask.ResultParmas)localObject);
    }
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLISH_FEEDS_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", QCircleUploadShuoShuoTask.c(this.a)), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong)), QCircleReportHelper.newEntry("ext1", paramBaseRequest.getTraceId()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramBaseRequest.getCurrentSeq())) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask.1
 * JD-Core Version:    0.7.0.1
 */