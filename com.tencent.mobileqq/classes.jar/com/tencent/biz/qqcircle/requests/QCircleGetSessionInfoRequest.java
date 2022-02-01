package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetSessionInfoReq;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

public class QCircleGetSessionInfoRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StGetSessionInfoReq mReq = new FeedCloudRead.StGetSessionInfoReq();
  
  public QCircleGetSessionInfoRequest(FeedCloudCommon.StCommonExt paramStCommonExt, int paramInt)
  {
    if (paramStCommonExt != null) {
      this.mReq.extInfo.set(paramStCommonExt);
    }
    this.mReq.scene.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetSessionInfoRsp localStGetSessionInfoRsp = new FeedCloudRead.StGetSessionInfoRsp();
    localStGetSessionInfoRsp.mergeFrom(paramArrayOfByte);
    return localStGetSessionInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetSessionInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetSessionInfoRequest
 * JD-Core Version:    0.7.0.1
 */