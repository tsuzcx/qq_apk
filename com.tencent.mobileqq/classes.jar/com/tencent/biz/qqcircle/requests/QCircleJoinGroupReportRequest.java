package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import qqcircle.QQCircleProfile.JoinGroupReportReq;
import qqcircle.QQCircleProfile.JoinGroupReportRsp;

public class QCircleJoinGroupReportRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.JoinGroupReportReq mReq = new QQCircleProfile.JoinGroupReportReq();
  
  public QCircleJoinGroupReportRequest(long paramLong)
  {
    this.mReq.groupID.set(paramLong);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.JoinGroupReportRsp localJoinGroupReportRsp = new QQCircleProfile.JoinGroupReportRsp();
    try
    {
      localJoinGroupReportRsp.mergeFrom(paramArrayOfByte);
      return localJoinGroupReportRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localJoinGroupReportRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.JoinGroupReport";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleJoinGroupReportRequest
 * JD-Core Version:    0.7.0.1
 */