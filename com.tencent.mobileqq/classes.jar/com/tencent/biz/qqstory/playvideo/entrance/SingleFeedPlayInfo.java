package com.tencent.biz.qqstory.playvideo.entrance;

import android.support.annotation.Nullable;

public class SingleFeedPlayInfo
  extends FeedBasePlayInfo
{
  public final int mFeedPullType;
  
  public SingleFeedPlayInfo(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt) {}
  
  public SingleFeedPlayInfo(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, boolean paramBoolean) {}
  
  public String toString()
  {
    return "SingleFeedPlayInfo{mFeedFeedId='" + this.mFeedFeedId + '\'' + ", mStartVideoFeedId='" + this.mStartVideoFeedId + '\'' + ", mFeedPullType=" + this.mFeedPullType + ", mStartVid='" + this.mStartVid + '\'' + ", mForcePlayVidFromOld2New=" + this.mForcePlayVidFromOld2New + ", mForceNotUseVidCache=" + this.mForceNotUseVidCache + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */