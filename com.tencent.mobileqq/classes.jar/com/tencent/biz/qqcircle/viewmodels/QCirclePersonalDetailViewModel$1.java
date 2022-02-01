package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class QCirclePersonalDetailViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp>
{
  QCirclePersonalDetailViewModel$1(QCirclePersonalDetailViewModel paramQCirclePersonalDetailViewModel, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, boolean paramBoolean, QCircleInitBean paramQCircleInitBean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("requestData onReceive: dispatch Success:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" | TraceId:");
    paramBaseRequest.append(this.a.getTraceId());
    paramBaseRequest.append(" | SeqId:");
    paramBaseRequest.append(this.a.getCurrentSeq());
    paramBaseRequest.append(" | retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" | retMessage:");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" | isLoadMore:");
    paramBaseRequest.append(this.b);
    paramBaseRequest.append(" | isCache:");
    paramBaseRequest.append(bool);
    QLog.d("QCirclePersonalDetailViewModel", 1, paramBaseRequest.toString());
    this.d.a(paramBoolean, paramLong, paramString, paramStGetMainPageRsp, Boolean.valueOf(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel.1
 * JD-Core Version:    0.7.0.1
 */