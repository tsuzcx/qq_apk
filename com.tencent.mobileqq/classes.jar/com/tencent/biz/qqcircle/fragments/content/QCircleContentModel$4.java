package com.tencent.biz.qqcircle.fragments.content;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class QCircleContentModel$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleContentModel$4(QCircleContentModel paramQCircleContentModel, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
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
    paramBaseRequest.append(" | isLoadMore:");
    paramBaseRequest.append(this.b);
    paramBaseRequest = paramBaseRequest.toString();
    paramBoolean = true;
    QLog.d("QCircleContentModel", 1, paramBaseRequest);
    if (paramStGetFeedListRsp != null)
    {
      QCircleContentModel.b(this.c).a(paramStGetFeedListRsp.feedAttchInfo.get());
      QCircleContentModel.b(this.c).c(paramStGetFeedListRsp.adAttchInfo.get());
      paramBaseRequest = QCircleContentModel.b(this.c);
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        paramBoolean = false;
      }
      paramBaseRequest.a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.c.updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      if (paramStGetFeedListRsp.busiRspData.has())
      {
        paramBaseRequest = new QQCircleFeedBase.StFeedListBusiRspData();
        try
        {
          paramBaseRequest.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (paramBaseRequest.refreshAttachInfo.has()) {
          QCircleContentModel.b(this.c).b(paramBaseRequest.refreshAttachInfo.get());
        }
      }
      QCirclePluginUtil.a(QCircleContentModel.c(this.c), paramStGetFeedListRsp.vecFeed.get());
    }
    QCircleContentModel.a(this.c).postValue(new ResponseBean(paramLong, paramString, paramStGetFeedListRsp, this.b));
    this.c.b().a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentModel.4
 * JD-Core Version:    0.7.0.1
 */