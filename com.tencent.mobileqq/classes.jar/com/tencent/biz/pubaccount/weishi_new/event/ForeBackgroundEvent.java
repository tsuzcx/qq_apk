package com.tencent.biz.pubaccount.weishi_new.event;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class ForeBackgroundEvent
  extends SimpleBaseEvent
{
  public boolean mIsBackground;
  
  public ForeBackgroundEvent(boolean paramBoolean)
  {
    this.mIsBackground = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent
 * JD-Core Version:    0.7.0.1
 */