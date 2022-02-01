package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class TagDescPublishEvent
  extends SimpleBaseEvent
{
  public String mTagDesc;
  
  public TagDescPublishEvent(String paramString)
  {
    this.mTagDesc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.TagDescPublishEvent
 * JD-Core Version:    0.7.0.1
 */