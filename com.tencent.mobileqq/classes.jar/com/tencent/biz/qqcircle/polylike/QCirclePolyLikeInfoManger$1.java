package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StRewardData;

class QCirclePolyLikeInfoManger$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp>
{
  QCirclePolyLikeInfoManger$1(QCirclePolyLikeInfoManger paramQCirclePolyLikeInfoManger, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    String str = QCirclePolyLikeInfoManger.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCirclePolyLikeInfoManger.e());
    localStringBuilder.append("->onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" |CmdName:");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new QQCircleFeedBase.StBusiInfoData();
      paramString = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
      try
      {
        paramBaseRequest.mergeFrom(paramString);
        if (!this.a) {
          this.b.a(paramBaseRequest.allPolyInfo.get());
        }
        if (paramBaseRequest.rewardData.myMoney.get() >= 0L)
        {
          this.b.a((float)paramBaseRequest.rewardData.myMoney.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBaseRequest)
      {
        QLog.d(QCirclePolyLikeInfoManger.e(), 4, paramBaseRequest, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeInfoManger.1
 * JD-Core Version:    0.7.0.1
 */