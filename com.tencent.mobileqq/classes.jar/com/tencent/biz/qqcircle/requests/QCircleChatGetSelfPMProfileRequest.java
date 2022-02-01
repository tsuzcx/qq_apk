package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleProfile.StGetSelfPMProfileReq;
import qqcircle.QQCircleProfile.StGetSelfPMProfileRsp;

public class QCircleChatGetSelfPMProfileRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.StGetSelfPMProfileReq mReq = new QQCircleProfile.StGetSelfPMProfileReq();
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.StGetSelfPMProfileRsp localStGetSelfPMProfileRsp = new QQCircleProfile.StGetSelfPMProfileRsp();
    try
    {
      localStGetSelfPMProfileRsp.mergeFrom(paramArrayOfByte);
      return localStGetSelfPMProfileRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetSelfPMProfileRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.GetSelfPMProfile";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleChatGetSelfPMProfileRequest
 * JD-Core Version:    0.7.0.1
 */