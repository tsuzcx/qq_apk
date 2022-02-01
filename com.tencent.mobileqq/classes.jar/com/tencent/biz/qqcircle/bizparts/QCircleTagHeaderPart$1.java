package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetRankingListRsp;

class QCircleTagHeaderPart$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetRankingListRsp>
{
  QCircleTagHeaderPart$1(QCircleTagHeaderPart paramQCircleTagHeaderPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp)
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
    QLog.d("QCircleTagHeaderPart", 1, localStringBuilder.toString());
    QCircleTagHeaderPart.a(this.a, paramBoolean, paramLong, paramString, paramStGetRankingListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart.1
 * JD-Core Version:    0.7.0.1
 */