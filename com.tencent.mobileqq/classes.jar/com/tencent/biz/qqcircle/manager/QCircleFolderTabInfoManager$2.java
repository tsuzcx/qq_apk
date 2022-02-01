package com.tencent.biz.qqcircle.manager;

import com.tencent.QCircleCollection;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class QCircleFolderTabInfoManager$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp>
{
  QCircleFolderTabInfoManager$2(QCircleFolderTabInfoManager paramQCircleFolderTabInfoManager) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchNewDataNow requestTabData onReceive: dispatch Success:");
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
    QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
    QCircleCollection.a("QCircleTabViewModel", "QCircleTabViewModel receive");
    this.a.a(paramBoolean, paramLong, paramString, paramStGetBusiInfoRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager.2
 * JD-Core Version:    0.7.0.1
 */