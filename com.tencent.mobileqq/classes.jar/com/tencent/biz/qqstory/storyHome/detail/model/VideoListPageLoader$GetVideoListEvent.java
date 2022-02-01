package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.List;

public class VideoListPageLoader$GetVideoListEvent
  extends BasePageLoaderEvent
{
  public String e;
  public String f;
  public List<StoryVideoItem> h = new ArrayList();
  public FeedVideoInfo i;
  
  public VideoListPageLoader$GetVideoListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.e = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetVideoListEvent{mVideoItems=");
    localStringBuilder.append(this.h.size());
    localStringBuilder.append(", feedId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mUnionId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent
 * JD-Core Version:    0.7.0.1
 */