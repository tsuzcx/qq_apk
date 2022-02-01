package com.tencent.biz.qqcircle.events;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleAtUpdateEvent
  extends SimpleBaseEvent
{
  public Intent mData;
  
  public QCircleAtUpdateEvent(Context paramContext, Intent paramIntent)
  {
    this.mData = paramIntent;
    int i;
    if (paramContext != null) {
      i = paramContext.hashCode();
    } else {
      i = 0;
    }
    this.mHashCode = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent
 * JD-Core Version:    0.7.0.1
 */