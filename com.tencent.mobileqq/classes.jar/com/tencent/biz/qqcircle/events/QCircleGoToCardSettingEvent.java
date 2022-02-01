package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleGoToCardSettingEvent
  extends SimpleBaseEvent
{
  public boolean mShowCard;
  
  public QCircleGoToCardSettingEvent(boolean paramBoolean)
  {
    this.mShowCard = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent
 * JD-Core Version:    0.7.0.1
 */