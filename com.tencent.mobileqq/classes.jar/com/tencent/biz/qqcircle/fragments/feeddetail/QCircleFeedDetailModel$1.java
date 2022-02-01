package com.tencent.biz.qqcircle.fragments.feeddetail;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QCircleFeedDetailModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QCircleFeedDetailModel$1(QCircleFeedDetailModel paramQCircleFeedDetailModel, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest, QCircleInitBean paramQCircleInitBean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    paramBaseRequest = this.c.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSingleFeed onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(this.a.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(this.a.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | extInfo:");
    localStringBuilder.append(((FeedCloudCommon.Entry)this.a.mRequest.extInfo.mapInfo.get(0)).key.get());
    localStringBuilder.append(": ");
    localStringBuilder.append(((FeedCloudCommon.Entry)this.a.mRequest.extInfo.mapInfo.get(0)).value.get());
    QLog.d(paramBaseRequest, 1, localStringBuilder.toString());
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
      if (paramLong != 0L) {
        QCircleFeedDetailModel.a(this.c).postValue(UIStateData.a(paramString).a(paramLong).b(false));
      } else {
        QCircleFeedDetailModel.a(this.c, (FeedCloudMeta.StFeed)paramStGetFeedDetailRsp.feed.get(), false);
      }
    }
    QCircleFeedDetailModel.b(this.c).postValue(new ResponseBean(paramLong, paramString, paramStGetFeedDetailRsp, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailModel.1
 * JD-Core Version:    0.7.0.1
 */