package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QFSGetLikeFeedListRequest$Builder
  extends QCircleBaseRequest.Builder<QFSGetLikeFeedListRequest>
{
  private final FeedCloudRead.StGetFeedListReq b = new FeedCloudRead.StGetFeedListReq();
  private final QQCircleFeedBase.StFeedListBusiRspData c = new QQCircleFeedBase.StFeedListBusiRspData();
  
  public QFSGetLikeFeedListRequest$Builder(String paramString)
  {
    this.b.dstUserId.set(paramString);
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramString);
    localStFeed.poster.set(localStUser);
    this.b.feed.set(localStFeed);
  }
  
  public Builder a(int paramInt)
  {
    this.b.from.set(paramInt);
    return this;
  }
  
  public QFSGetLikeFeedListRequest a()
  {
    this.b.busiReqData.set(ByteStringMicro.copyFrom(this.c.toByteArray()));
    this.b.listNum.set(30);
    this.a = new QFSGetLikeFeedListRequest(this.b, null);
    ((QFSGetLikeFeedListRequest)this.a).setUin(this.b.dstUserId.get());
    ((QFSGetLikeFeedListRequest)this.a).setSourceType(this.b.source.get());
    return (QFSGetLikeFeedListRequest)this.a;
  }
  
  public Builder b(int paramInt)
  {
    this.b.source.set(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.request.QFSGetLikeFeedListRequest.Builder
 * JD-Core Version:    0.7.0.1
 */