package com.tencent.biz.qqstory.model.events;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ReadStoryVideoEvent
  extends BaseEvent
{
  public long a;
  public String a;
  public String b;
  
  public ReadStoryVideoEvent(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramStoryVideoItem.mVideoIndex;
    this.b = paramStoryVideoItem.mVid;
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramStoryVideoItem.mCreateTime;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadStoryVideoEvent{unionId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */