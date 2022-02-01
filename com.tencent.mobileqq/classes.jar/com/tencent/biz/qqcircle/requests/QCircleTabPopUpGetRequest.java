package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchReq;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp;

public class QCircleTabPopUpGetRequest
  extends QCircleBaseRequest
{
  private final QQCircleSwitch.GetCirclePopupSwitchReq mRequest = new QQCircleSwitch.GetCirclePopupSwitchReq();
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.GetCirclePopupSwitchRsp localGetCirclePopupSwitchRsp = new QQCircleSwitch.GetCirclePopupSwitchRsp();
    try
    {
      localGetCirclePopupSwitchRsp.mergeFrom(paramArrayOfByte);
      return localGetCirclePopupSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetCirclePopupSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.GetCirclePopupSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleTabPopUpGetRequest
 * JD-Core Version:    0.7.0.1
 */