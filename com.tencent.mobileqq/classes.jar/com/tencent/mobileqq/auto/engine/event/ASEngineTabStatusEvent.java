package com.tencent.mobileqq.auto.engine.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class ASEngineTabStatusEvent
  extends SimpleBaseEvent
{
  private String mBusinessKey;
  private boolean mIsSelected;
  
  public ASEngineTabStatusEvent(String paramString, boolean paramBoolean)
  {
    this.mIsSelected = paramBoolean;
    this.mBusinessKey = paramString;
  }
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
  
  public boolean isSelected()
  {
    return this.mIsSelected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent
 * JD-Core Version:    0.7.0.1
 */