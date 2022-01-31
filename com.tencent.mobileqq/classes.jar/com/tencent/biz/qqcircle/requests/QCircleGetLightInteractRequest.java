package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetLightInteractListReq;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;

public class QCircleGetLightInteractRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StGetLightInteractListReq req;
  
  public QCircleGetLightInteractRequest(FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    if (paramStFeed != null)
    {
      this.req = new FeedCloudRead.StGetLightInteractListReq();
      this.req.id.set(paramStFeed.likeInfo.id.get());
      this.req.feedID.set(paramStFeed.id.get());
      this.req.hostID.set(paramStFeed.poster.id.get());
      this.req.type.set(2);
      this.req.attachInfo.set(paramString);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetLightInteractListRsp localStGetLightInteractListRsp = new FeedCloudRead.StGetLightInteractListRsp();
    localStGetLightInteractListRsp.mergeFrom(paramArrayOfByte);
    return localStGetLightInteractListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLightInteractList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest
 * JD-Core Version:    0.7.0.1
 */