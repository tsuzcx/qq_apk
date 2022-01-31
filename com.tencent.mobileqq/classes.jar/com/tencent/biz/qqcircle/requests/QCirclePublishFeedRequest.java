package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StPublishFeedReq;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

public class QCirclePublishFeedRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCirclePublishFeedRequest";
  FeedCloudWrite.StPublishFeedReq mReq = new FeedCloudWrite.StPublishFeedReq();
  
  public QCirclePublishFeedRequest(FeedCloudCommon.StCommonExt paramStCommonExt, FeedCloudMeta.StFeed paramStFeed)
  {
    this.mReq.feed = paramStFeed;
    this.mReq.extInfo.set(paramStCommonExt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StPublishFeedRsp localStPublishFeedRsp = new FeedCloudWrite.StPublishFeedRsp();
    localStPublishFeedRsp.mergeFrom(paramArrayOfByte);
    return localStPublishFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PublishFeed";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCirclePublishFeedRequest
 * JD-Core Version:    0.7.0.1
 */