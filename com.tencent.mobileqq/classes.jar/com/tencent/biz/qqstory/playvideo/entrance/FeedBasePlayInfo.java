package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class FeedBasePlayInfo
  implements Serializable
{
  public final String mFeedFeedId;
  public final boolean mForceNotUseVidCache;
  public final boolean mForcePlayVidFromOld2New;
  public final String mStartVid;
  public final String mStartVideoFeedId;
  
  public FeedBasePlayInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mFeedFeedId = paramString1;
    this.mStartVideoFeedId = paramString2;
    this.mStartVid = paramString3;
    this.mForcePlayVidFromOld2New = paramBoolean1;
    this.mForceNotUseVidCache = paramBoolean2;
  }
  
  public String toString()
  {
    return "FeedBasePlayInfo{mFeedFeedId='" + this.mFeedFeedId + '\'' + ", mStartVideoFeedId='" + this.mStartVideoFeedId + '\'' + ", mStartVid='" + this.mStartVid + '\'' + ", mForcePlayVidFromOld2New=" + this.mForcePlayVidFromOld2New + ", mForceNotUseVidCache=" + this.mForceNotUseVidCache + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo
 * JD-Core Version:    0.7.0.1
 */