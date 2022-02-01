package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSEnableSlideRightActionEvent
  extends SimpleBaseEvent
{
  boolean mEnable;
  
  public QFSEnableSlideRightActionEvent(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public boolean isEnable()
  {
    return this.mEnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent
 * JD-Core Version:    0.7.0.1
 */