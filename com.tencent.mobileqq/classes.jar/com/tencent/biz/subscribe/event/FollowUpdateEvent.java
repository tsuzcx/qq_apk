package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FollowUpdateEvent
  extends SimpleBaseEvent
{
  public int followStatus;
  public String useId;
  
  public FollowUpdateEvent(int paramInt, String paramString)
  {
    this.followStatus = paramInt;
    this.useId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.FollowUpdateEvent
 * JD-Core Version:    0.7.0.1
 */