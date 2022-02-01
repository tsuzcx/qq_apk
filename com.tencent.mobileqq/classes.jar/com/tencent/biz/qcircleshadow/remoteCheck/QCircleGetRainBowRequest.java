package com.tencent.biz.qcircleshadow.remoteCheck;

import com.tencent.biz.qcircleshadow.local.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
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
    localGetRainbowTableConfigRsp.mergeFrom(paramArrayOfByte);
    return localGetRainbowTableConfigRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleconfig.CircleConfigService.GetRainbowTableConfig";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCircleGetRainBowRequest
 * JD-Core Version:    0.7.0.1
 */