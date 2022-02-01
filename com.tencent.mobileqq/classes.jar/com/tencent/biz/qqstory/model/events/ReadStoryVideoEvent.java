package com.tencent.biz.qqstory.model.events;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ReadStoryVideoEvent
  extends BaseEvent
{
  public String a;
  public long b;
  public String c;
  
  public ReadStoryVideoEvent(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.a = paramString;
    this.b = paramStoryVideoItem.mVideoIndex;
    this.c = paramStoryVideoItem.mVid;
    if (this.b == 0L) {
      this.b = paramStoryVideoItem.mCreateTime;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadStoryVideoEvent{unionId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */