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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedBasePlayInfo{mFeedFeedId='");
    localStringBuilder.append(this.mFeedFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartVideoFeedId='");
    localStringBuilder.append(this.mStartVideoFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartVid='");
    localStringBuilder.append(this.mStartVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mForcePlayVidFromOld2New=");
    localStringBuilder.append(this.mForcePlayVidFromOld2New);
    localStringBuilder.append(", mForceNotUseVidCache=");
    localStringBuilder.append(this.mForceNotUseVidCache);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo
 * JD-Core Version:    0.7.0.1
 */