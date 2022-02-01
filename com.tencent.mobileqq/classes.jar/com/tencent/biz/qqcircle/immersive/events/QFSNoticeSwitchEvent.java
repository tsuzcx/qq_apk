package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSNoticeSwitchEvent
  extends SimpleBaseEvent
{
  private boolean isOpen = false;
  
  public QFSNoticeSwitchEvent(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
  
  public boolean getNoticeSwitch()
  {
    return this.isOpen;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSNoticeSwitchEvent
 * JD-Core Version:    0.7.0.1
 */