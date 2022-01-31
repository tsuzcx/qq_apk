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
    return "HomeFeedPlayInfo{mIsEnd=" + this.mIsEnd + ", mFeedFeedId='" + this.mFeedFeedId + '\'' + ", mStartVideoFeedId='" + this.mStartVideoFeedId + '\'' + ", mStartVid='" + this.mStartVid + '\'' + ", mForcePlayVidFromOld2New=" + this.mForcePlayVidFromOld2New + ", mForceNotUseVidCache=" + this.mForceNotUseVidCache + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */