package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleProfile.StChangePMProfileReq;
import qqcircle.QQCircleProfile.StChangePMProfileRsp;
import qqcircle.QQCircleProfile.StPMProfileData;

public class QCircleChatChangePMProfileRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.StChangePMProfileReq mReq = new QQCircleProfile.StChangePMProfileReq();
  
  public QCircleChatChangePMProfileRequest(QQCircleProfile.StPMProfileData paramStPMProfileData)
  {
    if (paramStPMProfileData != null) {
      this.mReq.profileData.set(paramStPMProfileData);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.StChangePMProfileRsp localStChangePMProfileRsp = new QQCircleProfile.StChangePMProfileRsp();
    try
    {
      localStChangePMProfileRsp.mergeFrom(paramArrayOfByte);
      return localStChangePMProfileRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStChangePMProfileRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.ChangePMProfile";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleChatChangePMProfileRequest
 * JD-Core Version:    0.7.0.1
 */