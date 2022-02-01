package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleSyncToTroopSettingEvent
  extends SimpleBaseEvent
{
  public boolean mCanSyncTroopARK;
  
  public QCircleSyncToTroopSettingEvent(boolean paramBoolean)
  {
    this.mCanSyncTroopARK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent
 * JD-Core Version:    0.7.0.1
 */