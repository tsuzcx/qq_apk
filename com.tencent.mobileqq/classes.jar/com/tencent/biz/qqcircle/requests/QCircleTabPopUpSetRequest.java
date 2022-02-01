package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleSwitch.SetCirclePopupSwitchReq;
import qqcircle.QQCircleSwitch.SetCirclePopupSwitchRsp;

public class QCircleTabPopUpSetRequest
  extends QCircleBaseRequest
{
  private final QQCircleSwitch.SetCirclePopupSwitchReq mRequest = new QQCircleSwitch.SetCirclePopupSwitchReq();
  
  public QCircleTabPopUpSetRequest(String paramString)
  {
    if (paramString != null) {
      this.mRequest.enable.set(paramString);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.SetCirclePopupSwitchRsp localSetCirclePopupSwitchRsp = new QQCircleSwitch.SetCirclePopupSwitchRsp();
    try
    {
      localSetCirclePopupSwitchRsp.mergeFrom(paramArrayOfByte);
      return localSetCirclePopupSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetCirclePopupSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetCirclePopupSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleTabPopUpSetRequest
 * JD-Core Version:    0.7.0.1
 */