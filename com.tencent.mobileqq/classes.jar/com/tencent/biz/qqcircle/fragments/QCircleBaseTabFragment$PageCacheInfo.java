package com.tencent.biz.qqcircle.fragments;

import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

class QCircleBaseTabFragment$PageCacheInfo
{
  private final List<FeedCloudMeta.StFeed> a;
  private final int b;
  private final int c;
  
  public QCircleBaseTabFragment$PageCacheInfo(List<FeedCloudMeta.StFeed> paramList, int paramInt1, int paramInt2)
  {
    this.a = paramList;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  boolean a()
  {
    List localList = this.a;
    return (localList != null) && (localList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.PageCacheInfo
 * JD-Core Version:    0.7.0.1
 */