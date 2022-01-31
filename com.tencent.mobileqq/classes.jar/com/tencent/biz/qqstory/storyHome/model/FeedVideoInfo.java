package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.model.BaseUIItem;
import java.util.ArrayList;
import java.util.List;

public class FeedVideoInfo
  extends BaseUIItem
  implements Copyable
{
  public String feedId;
  public boolean mIsVideoEnd;
  public List mVideoItemList = new ArrayList(0);
  public String mVideoNextCookie = "";
  public int mVideoPullType;
  public int mVideoSeq;
  
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
    return "FeedVideoInfo{feedId='" + this.feedId + '\'' + ", mVideoItemList=" + this.mVideoItemList.size() + ", mVideoSeq=" + this.mVideoSeq + ", mVideoPullType=" + this.mVideoPullType + ", mVideoNextCookie='" + this.mVideoNextCookie + '\'' + ", mIsVideoEnd=" + this.mIsVideoEnd + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo
 * JD-Core Version:    0.7.0.1
 */