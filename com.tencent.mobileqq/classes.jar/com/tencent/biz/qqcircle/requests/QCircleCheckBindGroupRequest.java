package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import qqcircle.QQCircleProfile.CheckBindGroupReq;
import qqcircle.QQCircleProfile.CheckBindGroupRsp;

public class QCircleCheckBindGroupRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.CheckBindGroupReq mReq = new QQCircleProfile.CheckBindGroupReq();
  
  public QCircleCheckBindGroupRequest() {}
  
  public QCircleCheckBindGroupRequest(List<Long> paramList)
  {
    this.mReq.groupIDList.set(paramList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.CheckBindGroupRsp localCheckBindGroupRsp = new QQCircleProfile.CheckBindGroupRsp();
    try
    {
      localCheckBindGroupRsp.mergeFrom(paramArrayOfByte);
      return localCheckBindGroupRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localCheckBindGroupRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.CheckBindGroup";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleCheckBindGroupRequest
 * JD-Core Version:    0.7.0.1
 */