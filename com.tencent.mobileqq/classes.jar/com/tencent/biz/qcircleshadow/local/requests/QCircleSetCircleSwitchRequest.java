package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleSwitch.SetCircleSwitchReq;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

public class QCircleSetCircleSwitchRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.SetCircleSwitchReq mReq = new QQCircleSwitch.SetCircleSwitchReq();
  
  public QCircleSetCircleSwitchRequest(String paramString1, String paramString2, String paramString3)
  {
    QQCircleSwitch.StSwitch localStSwitch = new QQCircleSwitch.StSwitch();
    localStSwitch.key.set(paramString1 + "." + paramString2);
    localStSwitch.value.set(paramString3);
    this.mReq.sw.set(localStSwitch);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.SetCircleSwitchRsp localSetCircleSwitchRsp = new QQCircleSwitch.SetCircleSwitchRsp();
    localSetCircleSwitchRsp.mergeFrom(paramArrayOfByte);
    return localSetCircleSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetCircleSwitch";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleSetCircleSwitchRequest
 * JD-Core Version:    0.7.0.1
 */