package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowReq;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class QCircleDoFollowRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoFollowReq mRequest;
  
  public QCircleDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this(paramStUser, paramInt, paramStCommonExt, false);
  }
  
  public QCircleDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt, boolean paramBoolean) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoFollowRsp localStDoFollowRsp = new FeedCloudWrite.StDoFollowRsp();
    try
    {
      localStDoFollowRsp.mergeFrom(paramArrayOfByte);
      return localStDoFollowRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoFollowRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow";
  }
  
  public FeedCloudWrite.StDoFollowReq getReq()
  {
    return this.mRequest;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest
 * JD-Core Version:    0.7.0.1
 */