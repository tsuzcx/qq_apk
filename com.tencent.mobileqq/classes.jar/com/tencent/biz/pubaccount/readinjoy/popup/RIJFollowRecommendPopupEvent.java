package com.tencent.biz.pubaccount.readinjoy.popup;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class RIJFollowRecommendPopupEvent
  extends SimpleBaseEvent
{
  public boolean showing;
  
  public RIJFollowRecommendPopupEvent(boolean paramBoolean)
  {
    this.showing = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupEvent
 * JD-Core Version:    0.7.0.1
 */