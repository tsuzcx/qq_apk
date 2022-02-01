package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import feedcloud.FeedCloudCommon.StCommonExt;
import qqcircle.QQCircleFeedbackhit.StFeedbackCommonInfo;
import qqcircle.QQCircleFeedbackhit.StSetFeedbackHitReq;
import qqcircle.QQCircleFeedbackhit.StSetFeedbackHitRsp;

public class QCircleFeedbackHitRequest
  extends QCircleBaseRequest
{
  private QQCircleFeedbackhit.StSetFeedbackHitReq mRequest = new QQCircleFeedbackhit.StSetFeedbackHitReq();
  
  public QCircleFeedbackHitRequest(QQCircleFeedbackhit.StFeedbackCommonInfo paramStFeedbackCommonInfo, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this.mRequest.feedbackInfo.set(paramStFeedbackCommonInfo);
    if (paramStCommonExt != null) {
      this.mRequest.extInfo.set(paramStCommonExt);
    }
    this.mRequest.type.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleFeedbackhit.StSetFeedbackHitRsp localStSetFeedbackHitRsp = new QQCircleFeedbackhit.StSetFeedbackHitRsp();
    try
    {
      localStSetFeedbackHitRsp.mergeFrom(paramArrayOfByte);
      return localStSetFeedbackHitRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStSetFeedbackHitRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.feedbackHit.FeedbackHit.SetFeedbackHit";
  }
  
  public QQCircleFeedbackhit.StSetFeedbackHitReq getReq()
  {
    return this.mRequest;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleFeedbackHitRequest
 * JD-Core Version:    0.7.0.1
 */