package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QCircleFakeAdapter$5
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QCircleFakeAdapter$5(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      QCircleFakeAdapter.a(this.c, paramStGetFeedDetailRsp, this.a);
    }
    else
    {
      this.c.a(this.a);
      QLog.d("QCircleFakeAdapter", 1, "start retry");
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("fetch real feed success:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append("  retCode code:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" fromRetry");
    paramBaseRequest.append(this.b);
    QLog.d("QCircleFakeAdapter", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.5
 * JD-Core Version:    0.7.0.1
 */