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

public class QFSGetFeedListRequest$Builder
  extends QCircleBaseRequest.Builder<QFSGetFeedListRequest>
{
  private final FeedCloudRead.StGetFeedListReq b = new FeedCloudRead.StGetFeedListReq();
  private final QQCircleFeedBase.StFeedListBusiRspData c = new QQCircleFeedBase.StFeedListBusiRspData();
  
  public QFSGetFeedListRequest$Builder(String paramString)
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
  
  public QFSGetFeedListRequest a()
  {
    this.b.busiReqData.set(ByteStringMicro.copyFrom(this.c.toByteArray()));
    this.b.listNum.set(30);
    this.a = new QFSGetFeedListRequest(this.b, null);
    ((QFSGetFeedListRequest)this.a).setUin(this.b.dstUserId.get());
    return (QFSGetFeedListRequest)this.a;
  }
  
  public Builder b(int paramInt)
  {
    this.b.source.set(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest.Builder
 * JD-Core Version:    0.7.0.1
 */