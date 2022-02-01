package com.tencent.biz.qqcircle.fragments.content;

import feedcloud.FeedCloudMeta.StFeed;

public class QCircleContentFeedReportScroller$FeedReportBean
{
  private long a;
  private long b;
  private long c;
  private int d;
  private FeedCloudMeta.StFeed e;
  
  public void a()
  {
    this.a = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
    this.c = (this.b - this.a);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.e = paramStFeed;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public long d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentFeedReportScroller.FeedReportBean
 * JD-Core Version:    0.7.0.1
 */