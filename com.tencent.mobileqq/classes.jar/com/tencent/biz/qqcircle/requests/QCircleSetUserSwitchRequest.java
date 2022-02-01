package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import qqcircle.QQCircleProfile.SetUserSwitchReq;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

public class QCircleSetUserSwitchRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.SetUserSwitchReq mReq = new QQCircleProfile.SetUserSwitchReq();
  
  public QCircleSetUserSwitchRequest(int paramInt1, int paramInt2)
  {
    this.mReq.switchType.set(paramInt1);
    this.mReq.value.set(paramInt2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.SetUserSwitchRsp localSetUserSwitchRsp = new QQCircleProfile.SetUserSwitchRsp();
    try
    {
      localSetUserSwitchRsp.mergeFrom(paramArrayOfByte);
      return localSetUserSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetUserSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetUserSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest
 * JD-Core Version:    0.7.0.1
 */