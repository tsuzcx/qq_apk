package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import feedcloud.FeedCloudMeta.StFeed;

public abstract interface IPreloadResultCallback
{
  public abstract void doPreloadImage(FeedCloudMeta.StFeed paramStFeed);
  
  public abstract void doPreloadVideo(FeedCloudMeta.StFeed paramStFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.IPreloadResultCallback
 * JD-Core Version:    0.7.0.1
 */