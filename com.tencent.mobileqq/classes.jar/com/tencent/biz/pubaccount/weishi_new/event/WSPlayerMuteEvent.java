package com.tencent.biz.pubaccount.weishi_new.event;

public class WSPlayerMuteEvent
  extends WSSimpleBaseEvent
{
  private boolean mIsPlayerMute;
  
  public WSPlayerMuteEvent(boolean paramBoolean)
  {
    this.mIsPlayerMute = paramBoolean;
  }
  
  public boolean isPlayerMute()
  {
    return this.mIsPlayerMute;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent
 * JD-Core Version:    0.7.0.1
 */