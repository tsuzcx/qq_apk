package com.tencent.biz.qqcircle.fragments.feeddetail;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;

class QCircleFeedDetailModel$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleFeedDetailModel$2(QCircleFeedDetailModel paramQCircleFeedDetailModel, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean, LoadInfo paramLoadInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    paramBaseRequest = this.d.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestRecommendFeedList onReceive: dispatch Success:");
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
    QLog.d(paramBaseRequest, 1, ((StringBuilder)localObject).toString());
    if (paramStGetFeedListRsp != null)
    {
      this.c.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.c.c(paramStGetFeedListRsp.adAttchInfo.get());
      paramBaseRequest = this.c;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBaseRequest.a(paramBoolean);
      QCircleFeedDetailModel.a(this.d, this.c);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.d.updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      QCirclePluginUtil.a(QCircleFeedDetailModel.c(this.d), paramStGetFeedListRsp.vecFeed.get());
      paramBaseRequest = this.d;
      localObject = paramStGetFeedListRsp.vecFeed.get();
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      QCircleFeedDetailModel.a(paramBaseRequest, true, (List)localObject, false, paramBoolean);
    }
    QCircleFeedDetailModel.b(this.d).postValue(new ResponseBean(paramLong, paramString, paramStGetFeedListRsp, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailModel.2
 * JD-Core Version:    0.7.0.1
 */