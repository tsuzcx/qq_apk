package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

public class QCircleGetCommentListRequest
  extends QCircleBaseRequest
{
  public static final int COMMENT_LIST_REQ_TYPE_BARRAGE = 1;
  public static final int COMMENT_LIST_REQ_TYPE_UNKNOWN = 0;
  public FeedCloudRead.StGetCommentListReq req;
  
  public QCircleGetCommentListRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean) {}
  
  public QCircleGetCommentListRequest(FeedCloudMeta.StFeed paramStFeed, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    this(paramStFeed, 0, paramString1, paramInt, paramString2, paramBoolean);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetCommentListRsp localStGetCommentListRsp = new FeedCloudRead.StGetCommentListRsp();
    try
    {
      localStGetCommentListRsp.mergeFrom(paramArrayOfByte);
      return localStGetCommentListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetCommentListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest
 * JD-Core Version:    0.7.0.1
 */