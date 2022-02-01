package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleContentModel$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleContentModel$2(QCircleContentModel paramQCircleContentModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestTagPageData onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | isLoadMore:");
    localStringBuilder.append(this.a);
    QLog.d("QCircleContentModel", 1, localStringBuilder.toString());
    QCircleContentModel.a(this.b, paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentModel.2
 * JD-Core Version:    0.7.0.1
 */