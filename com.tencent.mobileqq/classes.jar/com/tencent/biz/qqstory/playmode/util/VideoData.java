package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class VideoData
{
  public int a;
  public int b;
  public int c;
  public int d;
  public List<StoryVideoItem> e;
  public String f;
  public boolean g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mErrorCode:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mVideoTotalCount:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mFirstPlayIndex:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mVideoList:");
    localStringBuilder.append(this.e.toString());
    localStringBuilder.append(", mFeedId:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mIsEnd:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.VideoData
 * JD-Core Version:    0.7.0.1
 */