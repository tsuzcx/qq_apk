package com.tencent.biz.qqcircle.fragments.content;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QCircleContentModel$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QCircleContentModel$3(QCircleContentModel paramQCircleContentModel, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest, QCircleInitBean paramQCircleInitBean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("getSingleFeed onReceive: dispatch Success:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" | TraceId:");
    paramBaseRequest.append(this.a.getTraceId());
    paramBaseRequest.append(" | SeqId:");
    paramBaseRequest.append(this.a.getCurrentSeq());
    paramBaseRequest.append(" | retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" | retMessage:");
    paramBaseRequest.append(paramString);
    QLog.d("QCircleContentModel", 1, paramBaseRequest.toString());
    if (paramStGetFeedDetailRsp != null)
    {
      if (paramStGetFeedDetailRsp.extInfo.has()) {
        this.c.updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedDetailRsp.extInfo.get());
      }
      if (!VSNetworkHelper.isProtocolCache(paramString))
      {
        QCirclePluginGlobalInfo.b(paramStGetFeedDetailRsp.isFirstLogin.get());
        paramBaseRequest = this.b;
        if ((paramBaseRequest != null) && (paramBaseRequest.isNeedShowGoHomeButton())) {
          QCircleDTLoginReporter.daTongLoginReportMiddlePage(this.b.getSchemeAttrs(), QCirclePluginGlobalInfo.k());
        }
      }
    }
    QCircleContentModel.a(this.c).postValue(new ResponseBean(paramLong, paramString, paramStGetFeedDetailRsp, false));
    this.c.b().a(4);
    QCircleContentModel.a(this.c, paramLong, paramString, paramStGetFeedDetailRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentModel.3
 * JD-Core Version:    0.7.0.1
 */