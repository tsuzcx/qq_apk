package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class SharePanelShowStateEvent
  extends SimpleBaseEvent
{
  public boolean shown;
  
  public SharePanelShowStateEvent(boolean paramBoolean)
  {
    this.shown = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SharePanelShowStateEvent
 * JD-Core Version:    0.7.0.1
 */