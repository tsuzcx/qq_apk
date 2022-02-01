package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCirclePolymerizeDetailViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCirclePolymerizeDetailViewModel$1(QCirclePolymerizeDetailViewModel paramQCirclePolymerizeDetailViewModel, boolean paramBoolean, QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPolymerizeDetailData onReceive: dispatch Success:");
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
    QLog.d("QCirclePolymerizeDetailViewModel", 1, localStringBuilder.toString());
    this.c.a(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel.1
 * JD-Core Version:    0.7.0.1
 */