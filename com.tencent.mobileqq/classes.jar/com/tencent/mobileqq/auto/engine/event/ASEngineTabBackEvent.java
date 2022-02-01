package com.tencent.mobileqq.auto.engine.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class ASEngineTabBackEvent
  extends SimpleBaseEvent
{
  private String mBusinessKey;
  
  public ASEngineTabBackEvent(String paramString)
  {
    this.mBusinessKey = paramString;
  }
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent
 * JD-Core Version:    0.7.0.1
 */