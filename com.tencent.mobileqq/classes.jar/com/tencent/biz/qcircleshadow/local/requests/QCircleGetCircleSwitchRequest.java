package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleSwitch.GetCircleSwitchReq;
import qqcircle.QQCircleSwitch.GetCircleSwitchRsp;

public class QCircleGetCircleSwitchRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.GetCircleSwitchReq mReq = new QQCircleSwitch.GetCircleSwitchReq();
  
  public QCircleGetCircleSwitchRequest(String paramString1, String paramString2)
  {
    this.mReq.switchKey.set(paramString1 + "." + paramString2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.GetCircleSwitchRsp localGetCircleSwitchRsp = new QQCircleSwitch.GetCircleSwitchRsp();
    localGetCircleSwitchRsp.mergeFrom(paramArrayOfByte);
    return localGetCircleSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.GetCircleSwitch";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleGetCircleSwitchRequest
 * JD-Core Version:    0.7.0.1
 */