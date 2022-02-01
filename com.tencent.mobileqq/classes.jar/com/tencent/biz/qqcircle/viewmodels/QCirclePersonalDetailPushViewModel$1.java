package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCirclePersonalDetailPushViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCirclePersonalDetailPushViewModel$1(QCirclePersonalDetailPushViewModel paramQCirclePersonalDetailPushViewModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    this.b.a(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.a);
    paramStGetFeedListRsp = new StringBuilder();
    paramStGetFeedListRsp.append("requestData onReceive: dispatch Success:");
    paramStGetFeedListRsp.append(paramBoolean);
    paramStGetFeedListRsp.append(" | TraceId:");
    paramStGetFeedListRsp.append(paramBaseRequest.getTraceId());
    paramStGetFeedListRsp.append(" | SeqId:");
    paramStGetFeedListRsp.append(paramBaseRequest.getCurrentSeq());
    paramStGetFeedListRsp.append(" | retCode:");
    paramStGetFeedListRsp.append(paramLong);
    paramStGetFeedListRsp.append(" | retMessage:");
    paramStGetFeedListRsp.append(paramString);
    paramStGetFeedListRsp.append(" | isLoadMore:");
    paramStGetFeedListRsp.append(this.a);
    paramStGetFeedListRsp.append(" | isCache:");
    paramStGetFeedListRsp.append(VSNetworkHelper.isProtocolCache(paramString));
    paramStGetFeedListRsp.append(" | extInfo:");
    paramBaseRequest = (QCircleGetFeedListRequest)paramBaseRequest;
    paramStGetFeedListRsp.append(((FeedCloudCommon.Entry)paramBaseRequest.mRequest.extInfo.mapInfo.get(0)).key.get());
    paramStGetFeedListRsp.append(": ");
    paramStGetFeedListRsp.append(((FeedCloudCommon.Entry)paramBaseRequest.mRequest.extInfo.mapInfo.get(0)).value.get());
    QLog.d("QCirclePersonalDetailViewModel", 1, paramStGetFeedListRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel.1
 * JD-Core Version:    0.7.0.1
 */