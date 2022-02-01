package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;

class QCircleLightInteractViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetLightInteractListRsp>
{
  QCircleLightInteractViewModel$1(QCircleLightInteractViewModel paramQCircleLightInteractViewModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    String str = QCircleLightInteractViewModel.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPolyList onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | isCache:");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    this.b.a(paramBoolean, paramLong, this.a, paramString, paramStGetLightInteractListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleLightInteractViewModel.1
 * JD-Core Version:    0.7.0.1
 */