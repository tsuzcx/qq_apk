package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetC2CFeedReq;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;

public class QCircleStGetC2CFeedRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetC2CFeedReq mReq = new FeedCloudRead.StGetC2CFeedReq();
  
  public QCircleStGetC2CFeedRequest(String paramString)
  {
    this.mReq.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetC2CFeedRsp localStGetC2CFeedRsp = new FeedCloudRead.StGetC2CFeedRsp();
    localStGetC2CFeedRsp.mergeFrom(paramArrayOfByte);
    return localStGetC2CFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetC2CFeed";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleStGetC2CFeedRequest
 * JD-Core Version:    0.7.0.1
 */