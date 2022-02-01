package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;

public abstract interface VideoFeedsAdapter$AdapterEventListener
{
  public abstract void a(long paramLong);
  
  public abstract void a(VideoInfo paramVideoInfo, boolean paramBoolean);
  
  public abstract void a(VideoItemHolder paramVideoItemHolder);
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.AdapterEventListener
 * JD-Core Version:    0.7.0.1
 */