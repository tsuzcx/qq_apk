package com.tencent.biz.qqcircle.publish.task;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QCircleUploadShuoShuoTask$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QCircleUploadShuoShuoTask$3(QCircleUploadShuoShuoTask paramQCircleUploadShuoShuoTask, QCircleFakeFeed paramQCircleFakeFeed, QCircleUploadShuoShuoTask.ResultParmas paramResultParmas, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("fetch real feed success:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append("  retCode code:");
    paramBaseRequest.append(paramLong);
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(this.a, 2));
      QCircleUploadShuoShuoTask.a(this.d, this.b);
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("start retry retryCount:");
    paramBaseRequest.append(this.c);
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, paramBaseRequest.toString());
    if (!this.d.a(this.a, this.c, this.b)) {
      QCircleUploadShuoShuoTask.a(this.d, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask.3
 * JD-Core Version:    0.7.0.1
 */