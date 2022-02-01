package com.tencent.biz.qcircleshadow.remotecheck;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleConfig.GetRainbowTableConfigReq;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

public class QCircleGetRainBowRequest
  extends QCircleBaseRequest
{
  QQCircleConfig.GetRainbowTableConfigReq mReq = new QQCircleConfig.GetRainbowTableConfigReq();
  
  public QCircleGetRainBowRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mReq.cookie.set(paramString1);
    this.mReq.qua.set(paramString2);
    this.mReq.group.set(paramString3);
    this.mReq.uid.set(paramString4);
    this.mReq.version.set(paramString5);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleConfig.GetRainbowTableConfigRsp localGetRainbowTableConfigRsp = new QQCircleConfig.GetRainbowTableConfigRsp();
    try
    {
      localGetRainbowTableConfigRsp.mergeFrom(paramArrayOfByte);
      return localGetRainbowTableConfigRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetRainbowTableConfigRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleconfig.CircleConfigService.GetRainbowTableConfig";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotecheck.QCircleGetRainBowRequest
 * JD-Core Version:    0.7.0.1
 */