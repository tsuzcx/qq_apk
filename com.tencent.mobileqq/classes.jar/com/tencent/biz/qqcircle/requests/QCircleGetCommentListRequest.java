package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

public class QCircleGetCommentListRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetCommentListReq req = new FeedCloudRead.StGetCommentListReq();
  
  public QCircleGetCommentListRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramStFeed != null)
    {
      this.req.userId.set(paramStFeed.poster.id.get());
      this.req.feedId.set(paramStFeed.id.get());
      this.req.busiTranparent.set(paramStFeed.busiTranparent.get());
    }
    if (paramString1 != null) {
      this.req.feedAttchInfo.set(paramString1);
    }
    this.req.from.set(paramInt1);
    this.req.listNum.set(paramInt2);
    this.req.likeKey.set(paramString2);
  }
  
  public QCircleGetCommentListRequest(FeedCloudMeta.StFeed paramStFeed, String paramString1, int paramInt, String paramString2)
  {
    this(paramStFeed, 0, paramString1, paramInt, paramString2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetCommentListRsp localStGetCommentListRsp = new FeedCloudRead.StGetCommentListRsp();
    localStGetCommentListRsp.mergeFrom(paramArrayOfByte);
    return localStGetCommentListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest
 * JD-Core Version:    0.7.0.1
 */