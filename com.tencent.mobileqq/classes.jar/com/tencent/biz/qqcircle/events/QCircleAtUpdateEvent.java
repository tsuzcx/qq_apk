package com.tencent.biz.qqcircle.events;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleAtUpdateEvent
  extends SimpleBaseEvent
{
  public Intent mData;
  
  public QCircleAtUpdateEvent(Intent paramIntent)
  {
    this.mData = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent
 * JD-Core Version:    0.7.0.1
 */