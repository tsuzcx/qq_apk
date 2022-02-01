package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import qqcircle.QQCircleCounter.CountInfoReq;
import qqcircle.QQCircleCounter.CountInfoRsp;

public class QCircleCountInfoRequest
  extends QCircleBaseRequest
{
  QQCircleCounter.CountInfoReq mReuqest = new QQCircleCounter.CountInfoReq();
  
  public QCircleCountInfoRequest(String paramString, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleCounter.CountInfoRsp localCountInfoRsp = new QQCircleCounter.CountInfoRsp();
    try
    {
      localCountInfoRsp.mergeFrom(paramArrayOfByte);
      return localCountInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localCountInfoRsp;
  }
  
  public String getCmdName()
  {
    return null;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReuqest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleCountInfoRequest
 * JD-Core Version:    0.7.0.1
 */