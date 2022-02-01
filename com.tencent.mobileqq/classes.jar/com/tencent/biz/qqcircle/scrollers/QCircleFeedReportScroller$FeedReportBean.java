package com.tencent.biz.qqcircle.scrollers;

import android.view.View;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleFeedReportScroller$FeedReportBean
{
  private View a;
  private long b;
  private long c;
  private long d;
  private int e;
  private FeedCloudMeta.StFeed f;
  
  public View a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
    this.d = (this.c - this.b);
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.f = paramStFeed;
  }
  
  public void b()
  {
    this.b = System.currentTimeMillis();
  }
  
  public long c()
  {
    return this.b;
  }
  
  public long d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public FeedCloudMeta.StFeed g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.FeedReportBean
 * JD-Core Version:    0.7.0.1
 */