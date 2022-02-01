package com.tencent.biz.qqstory.playvideo.entrance;

public class HomeFeedPlayInfo
  extends FeedBasePlayInfo
{
  public boolean mIsEnd;
  
  public HomeFeedPlayInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, false, paramBoolean);
  }
  
  public HomeFeedPlayInfo(String paramString, boolean paramBoolean)
  {
    super(paramString, "", "", paramBoolean, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomeFeedPlayInfo{mIsEnd=");
    localStringBuilder.append(this.mIsEnd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */