package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta.StMedalInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleBase.CircleRankingData;

public class QCircleTagItemInfo
{
  private int a;
  private QQCircleBase.CircleRankingData b;
  private FeedCloudMeta.StTagInfo c;
  private FeedCloudMeta.StMedalInfo d;
  
  public QCircleTagItemInfo(int paramInt, FeedCloudMeta.StMedalInfo paramStMedalInfo)
  {
    this.a = paramInt;
    this.d = paramStMedalInfo;
  }
  
  public QCircleTagItemInfo(int paramInt, FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.a = paramInt;
    this.c = paramStTagInfo;
  }
  
  public QCircleTagItemInfo(int paramInt, QQCircleBase.CircleRankingData paramCircleRankingData)
  {
    this.a = paramInt;
    this.b = paramCircleRankingData;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public QQCircleBase.CircleRankingData b()
  {
    return this.b;
  }
  
  public FeedCloudMeta.StTagInfo c()
  {
    return this.c;
  }
  
  public FeedCloudMeta.StMedalInfo d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleTagItemInfo
 * JD-Core Version:    0.7.0.1
 */