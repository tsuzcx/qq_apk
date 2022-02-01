package com.tencent.biz.qqstory.playvideo.entrance;

public class HotRecommendFeedPlayInfo
  extends FeedBasePlayInfo
{
  public final int mPullType;
  
  public HotRecommendFeedPlayInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1, paramString2, paramString3, false, false);
    this.mPullType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HotRecommendFeedPlayInfo{mPullType=");
    localStringBuilder.append(this.mPullType);
    localStringBuilder.append(", mFeedFeedId='");
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */