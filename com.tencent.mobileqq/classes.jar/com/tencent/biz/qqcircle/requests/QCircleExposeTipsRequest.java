package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleEnvHub.ExposeTipsReq;
import qqcircle.QQCircleEnvHub.ExposeTipsRsp;

public class QCircleExposeTipsRequest
  extends QCircleBaseRequest
{
  private QQCircleEnvHub.ExposeTipsReq mExposeTipsReq = new QQCircleEnvHub.ExposeTipsReq();
  
  public QCircleExposeTipsRequest(String paramString, int paramInt)
  {
    this.mExposeTipsReq.userId.set(paramString);
    this.mExposeTipsReq.tipsId.set(paramInt);
  }
  
  public QQCircleEnvHub.ExposeTipsRsp decode(byte[] paramArrayOfByte)
  {
    QQCircleEnvHub.ExposeTipsRsp localExposeTipsRsp = new QQCircleEnvHub.ExposeTipsRsp();
    try
    {
      localExposeTipsRsp.mergeFrom(paramArrayOfByte);
      return localExposeTipsRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localExposeTipsRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleenvhub.EnvHub.ExposeTips";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mExposeTipsReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleExposeTipsRequest
 * JD-Core Version:    0.7.0.1
 */