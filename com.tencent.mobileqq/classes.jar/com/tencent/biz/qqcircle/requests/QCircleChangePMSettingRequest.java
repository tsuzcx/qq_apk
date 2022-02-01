package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingReq;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class QCircleChangePMSettingRequest
  extends QCircleBaseRequest
{
  private QQCirclePrivateMsgShow.StChangePMSettingReq mReq = new QQCirclePrivateMsgShow.StChangePMSettingReq();
  
  public QCircleChangePMSettingRequest(QQCirclePrivateMsgShow.StPMSettingData paramStPMSettingData)
  {
    if (paramStPMSettingData != null) {
      this.mReq.setting.set(paramStPMSettingData);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCirclePrivateMsgShow.StChangePMSettingRsp localStChangePMSettingRsp = new QQCirclePrivateMsgShow.StChangePMSettingRsp();
    try
    {
      localStChangePMSettingRsp.mergeFrom(paramArrayOfByte);
      return localStChangePMSettingRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStChangePMSettingRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.ChangePMSetting";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleChangePMSettingRequest
 * JD-Core Version:    0.7.0.1
 */