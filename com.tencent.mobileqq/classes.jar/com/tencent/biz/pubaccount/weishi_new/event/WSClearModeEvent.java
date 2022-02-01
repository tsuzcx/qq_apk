package com.tencent.biz.pubaccount.weishi_new.event;

public class WSClearModeEvent
  extends WSSimpleBaseEvent
{
  private boolean isClearMode;
  
  public WSClearModeEvent(boolean paramBoolean)
  {
    this.isClearMode = paramBoolean;
  }
  
  public boolean isClearMode()
  {
    return this.isClearMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent
 * JD-Core Version:    0.7.0.1
 */