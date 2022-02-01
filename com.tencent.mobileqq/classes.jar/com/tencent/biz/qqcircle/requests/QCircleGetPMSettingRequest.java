package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingReq;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;

public class QCircleGetPMSettingRequest
  extends QCircleBaseRequest
{
  private QQCirclePrivateMsgShow.StGetPMSettingReq mReq = new QQCirclePrivateMsgShow.StGetPMSettingReq();
  
  public QCircleGetPMSettingRequest(String paramString)
  {
    this.mReq.uid.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCirclePrivateMsgShow.StGetPMSettingRsp localStGetPMSettingRsp = new QQCirclePrivateMsgShow.StGetPMSettingRsp();
    try
    {
      localStGetPMSettingRsp.mergeFrom(paramArrayOfByte);
      return localStGetPMSettingRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetPMSettingRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.GetPMSetting";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetPMSettingRequest
 * JD-Core Version:    0.7.0.1
 */