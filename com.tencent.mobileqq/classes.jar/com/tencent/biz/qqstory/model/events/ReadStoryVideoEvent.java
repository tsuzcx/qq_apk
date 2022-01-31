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
    return "ReadStoryVideoEvent{unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", videoIndex=" + this.jdField_a_of_type_Long + ", vid='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */