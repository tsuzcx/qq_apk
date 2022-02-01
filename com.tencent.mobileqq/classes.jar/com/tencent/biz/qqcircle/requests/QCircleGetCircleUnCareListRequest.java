package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import qqcircle.QQCircleRight.GetCircleUnCareListReq;
import qqcircle.QQCircleRight.GetCircleUnCareListRsp;

public class QCircleGetCircleUnCareListRequest
  extends QCircleBaseRequest
{
  private QQCircleRight.GetCircleUnCareListReq mRequest = new QQCircleRight.GetCircleUnCareListReq();
  
  public QCircleGetCircleUnCareListRequest(int paramInt)
  {
    this.mRequest.rightType.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleRight.GetCircleUnCareListRsp localGetCircleUnCareListRsp = new QQCircleRight.GetCircleUnCareListRsp();
    try
    {
      localGetCircleUnCareListRsp.mergeFrom(paramArrayOfByte);
      return localGetCircleUnCareListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetCircleUnCareListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleright.CircleRight.GetCircleUnCareList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest
 * JD-Core Version:    0.7.0.1
 */