package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class LbsDescPublishEvent
  extends SimpleBaseEvent
{
  public String mDesc;
  
  public LbsDescPublishEvent(String paramString)
  {
    this.mDesc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.LbsDescPublishEvent
 * JD-Core Version:    0.7.0.1
 */