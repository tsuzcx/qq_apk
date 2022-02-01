package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleTagPageViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleTagPageViewModel$1(QCircleTagPageViewModel paramQCircleTagPageViewModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
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
    localStringBuilder.append(" | isCache:");
    localStringBuilder.append(bool);
    QLog.d("QCircleTagPageViewModel", 1, localStringBuilder.toString());
    this.b.a(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel.1
 * JD-Core Version:    0.7.0.1
 */