package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import qqcircle.QQCircleRight.SetCircleUnCareReq;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

public class QCircleSetUnCareRequest
  extends QCircleBaseRequest
{
  private QQCircleRight.SetCircleUnCareReq mRequest = new QQCircleRight.SetCircleUnCareReq();
  
  public QCircleSetUnCareRequest(String paramString, int paramInt1, int paramInt2, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this.mRequest.strUid.set(paramString);
    this.mRequest.operType.set(paramInt1);
    this.mRequest.rightType.set(paramInt2);
    if (paramStCommonExt != null) {
      this.mRequest.extInfo.set(paramStCommonExt);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleRight.SetCircleUnCareRsp localSetCircleUnCareRsp = new QQCircleRight.SetCircleUnCareRsp();
    try
    {
      localSetCircleUnCareRsp.mergeFrom(paramArrayOfByte);
      return localSetCircleUnCareRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetCircleUnCareRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleright.CircleRight.SetCircleUnCare";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest
 * JD-Core Version:    0.7.0.1
 */