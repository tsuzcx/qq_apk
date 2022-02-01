package com.tencent.biz.qqcircle.fragments.troop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleTroopAggregationFeedViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleTroopAggregationFeedViewModel$1(QCircleTroopAggregationFeedViewModel paramQCircleTroopAggregationFeedViewModel, QCircleGetGroupFeedListRequest paramQCircleGetGroupFeedListRequest, boolean paramBoolean, LoadInfo paramLoadInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    paramBaseRequest = this.d.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestGroupFeedList onReceive: dispatch Success:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" | TraceId:");
    ((StringBuilder)localObject).append(this.a.getTraceId());
    ((StringBuilder)localObject).append(" | SeqId:");
    ((StringBuilder)localObject).append(this.a.getCurrentSeq());
    ((StringBuilder)localObject).append(" | retCode:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" | retMessage:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" | isLoadMore:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" | extInfo:");
    ((StringBuilder)localObject).append(((FeedCloudCommon.Entry)this.a.mRequest.extInfo.mapInfo.get(0)).key.get());
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(((FeedCloudCommon.Entry)this.a.mRequest.extInfo.mapInfo.get(0)).value.get());
    localObject = ((StringBuilder)localObject).toString();
    paramBoolean = true;
    QLog.d(paramBaseRequest, 1, (String)localObject);
    if (paramStGetFeedListRsp != null)
    {
      this.c.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.c.c(paramStGetFeedListRsp.adAttchInfo.get());
      paramBaseRequest = this.c;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        paramBoolean = false;
      }
      paramBaseRequest.a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.d.updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      QCirclePluginUtil.a(QCircleTroopAggregationFeedViewModel.a(this.d), paramStGetFeedListRsp.vecFeed.get());
    }
    QCircleTroopAggregationFeedViewModel.b(this.d).postValue(new ResponseBean(paramLong, paramString, paramStGetFeedListRsp, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationFeedViewModel.1
 * JD-Core Version:    0.7.0.1
 */