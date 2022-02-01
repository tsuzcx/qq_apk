package com.tencent.biz.qqcircle.immersive.aggregation.bean;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import feedcloud.FeedCloudMeta.StFeedMusic;

public class QFSMusicAggregationInitBean
  extends QCircleInitBean
{
  private byte[] mFeedMusicByteArray;
  
  public FeedCloudMeta.StFeedMusic getFeedMusic()
  {
    FeedCloudMeta.StFeedMusic localStFeedMusic = new FeedCloudMeta.StFeedMusic();
    try
    {
      localStFeedMusic.mergeFrom(this.mFeedMusicByteArray);
      return localStFeedMusic;
    }
    catch (Exception localException) {}
    return localStFeedMusic;
  }
  
  public void setFeedMusic(FeedCloudMeta.StFeedMusic paramStFeedMusic)
  {
    if (paramStFeedMusic != null) {
      this.mFeedMusicByteArray = paramStFeedMusic.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean
 * JD-Core Version:    0.7.0.1
 */