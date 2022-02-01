package com.tencent.biz.qqcircle.datacenter.convert;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.data.idata.IDataConverter;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StShare;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleFeedConverter
  implements IDataConverter<FeedBlockData>
{
  private void a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (!paramStFeed2.commentCount.has()) {
      return;
    }
    paramStFeed1.commentCount.set(paramStFeed2.commentCount.get());
  }
  
  private void b(FeedBlockData paramFeedBlockData1, FeedBlockData paramFeedBlockData2)
  {
    paramFeedBlockData2 = (QQCircleFeedBase.StFeedBusiReqData)paramFeedBlockData2.a("DITTO_FEED_BUSI_REQ_DATA");
    if (paramFeedBlockData2 != null) {
      paramFeedBlockData1.a("DITTO_FEED_BUSI_REQ_DATA", paramFeedBlockData2);
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (!paramStFeed2.likeInfo.has()) {
      return;
    }
    paramStFeed1.likeInfo.set(paramStFeed2.likeInfo.get());
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (!paramStFeed2.share.sharedCount.has()) {
      return;
    }
    paramStFeed1.share.sharedCount.set(paramStFeed2.share.sharedCount.get());
  }
  
  public String a(FeedBlockData paramFeedBlockData)
  {
    return paramFeedBlockData.b().id.get();
  }
  
  public void a(FeedBlockData paramFeedBlockData1, FeedBlockData paramFeedBlockData2)
  {
    if (paramFeedBlockData1 != null)
    {
      if (paramFeedBlockData2 == null) {
        return;
      }
      a(paramFeedBlockData1.b(), paramFeedBlockData2.b());
      b(paramFeedBlockData1.b(), paramFeedBlockData2.b());
      c(paramFeedBlockData1.b(), paramFeedBlockData2.b());
      b(paramFeedBlockData1, paramFeedBlockData2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.convert.QCircleFeedConverter
 * JD-Core Version:    0.7.0.1
 */