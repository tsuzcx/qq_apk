package com.tencent.biz.qqcircle.extendpb;

import feedcloud.FeedCloudMeta.StFeed;

public class FeedBlockData
  extends BaseBlockData<FeedCloudMeta.StFeed>
{
  public FeedBlockData(FeedCloudMeta.StFeed paramStFeed)
  {
    super(paramStFeed);
  }
  
  public FeedCloudMeta.StFeed b()
  {
    return (FeedCloudMeta.StFeed)super.a();
  }
  
  public FeedBlockData c()
  {
    QCircleTransFormHelper.a(this, (FeedCloudMeta.StFeed)this.b);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.extendpb.FeedBlockData
 * JD-Core Version:    0.7.0.1
 */