package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleColdBootPreloadTask$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleColdBootPreloadTask$3(QCircleColdBootPreloadTask paramQCircleColdBootPreloadTask) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadFeed onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | source:");
    localStringBuilder.append(QCircleColdBootPreloadTask.a(this.a));
    QLog.d("QCircleColdBootPreloadTask", 1, localStringBuilder.toString());
    QCircleColdBootPreloadTask.a(this.a, paramBoolean, paramLong, paramString, paramStGetFeedListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadTask.3
 * JD-Core Version:    0.7.0.1
 */