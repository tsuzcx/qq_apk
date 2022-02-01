package com.tencent.biz.qqstory.playvideo.entrance;

import android.support.annotation.Nullable;

public class SingleFeedPlayInfo
  extends FeedBasePlayInfo
{
  public final int mFeedPullType;
  
  public SingleFeedPlayInfo(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt)
  {
    super(paramString1, paramString2, paramString3, bool, false);
    this.mFeedPullType = paramInt;
  }
  
  public SingleFeedPlayInfo(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, bool, paramBoolean);
    this.mFeedPullType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SingleFeedPlayInfo{mFeedFeedId='");
    localStringBuilder.append(this.mFeedFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartVideoFeedId='");
    localStringBuilder.append(this.mStartVideoFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedPullType=");
    localStringBuilder.append(this.mFeedPullType);
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */