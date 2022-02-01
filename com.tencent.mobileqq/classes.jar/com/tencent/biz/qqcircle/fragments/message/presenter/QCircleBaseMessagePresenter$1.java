package com.tencent.biz.qqcircle.fragments.message.presenter;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StClearRedPointRsp;

class QCircleBaseMessagePresenter$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StClearRedPointRsp>
{
  QCircleBaseMessagePresenter$1(QCircleBaseMessagePresenter paramQCircleBaseMessagePresenter, QCircleBaseRequest paramQCircleBaseRequest) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearRedPointRsp paramStClearRedPointRsp)
  {
    paramBaseRequest = this.b.f();
    paramStClearRedPointRsp = new StringBuilder();
    paramStClearRedPointRsp.append("traceId:");
    paramStClearRedPointRsp.append(this.a.getTraceId());
    paramStClearRedPointRsp.append(" isSuccess:");
    paramStClearRedPointRsp.append(paramBoolean);
    paramStClearRedPointRsp.append(" errorCode");
    paramStClearRedPointRsp.append(paramLong);
    paramStClearRedPointRsp.append(" err:");
    paramStClearRedPointRsp.append(paramString);
    QLog.i(paramBaseRequest, 1, paramStClearRedPointRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */