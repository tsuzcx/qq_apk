package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.List;

public class FeedVideoInfo
  extends BaseUIItem
  implements Copyable
{
  public String feedId;
  public boolean mIsVideoEnd;
  public List<StoryVideoItem> mVideoItemList = new ArrayList(0);
  public String mVideoNextCookie = "";
  public int mVideoPullType;
  public int mVideoSeq;
  
  public FeedVideoInfo() {}
  
  public FeedVideoInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    this.feedId = paramString1;
    this.mVideoSeq = paramInt1;
    this.mVideoPullType = paramInt2;
    this.mVideoNextCookie = paramString2;
    this.mIsVideoEnd = paramBoolean;
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (FeedVideoInfo)paramObject;
    this.feedId = paramObject.feedId;
    this.mVideoSeq = paramObject.mVideoSeq;
    this.mVideoNextCookie = paramObject.mVideoNextCookie;
    this.mIsVideoEnd = paramObject.mIsVideoEnd;
    this.mVideoPullType = paramObject.mVideoPullType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedVideoInfo{feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoItemList=");
    localStringBuilder.append(this.mVideoItemList.size());
    localStringBuilder.append(", mVideoSeq=");
    localStringBuilder.append(this.mVideoSeq);
    localStringBuilder.append(", mVideoPullType=");
    localStringBuilder.append(this.mVideoPullType);
    localStringBuilder.append(", mVideoNextCookie='");
    localStringBuilder.append(this.mVideoNextCookie);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsVideoEnd=");
    localStringBuilder.append(this.mIsVideoEnd);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo
 * JD-Core Version:    0.7.0.1
 */