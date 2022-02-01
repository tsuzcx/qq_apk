package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.jetbrains.annotations.NotNull;

public class QCircleSpecialFollowUpdateEvent
  extends SimpleBaseEvent
{
  public final boolean isFollow;
  public final String uin;
  
  public QCircleSpecialFollowUpdateEvent(String paramString, boolean paramBoolean)
  {
    this.uin = paramString;
    this.isFollow = paramBoolean;
  }
  
  @NotNull
  public String toString()
  {
    return "QCircleSpecialFollowUpdateEvent{uin='" + this.uin + '\'' + ", isFollow=" + this.isFollow + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent
 * JD-Core Version:    0.7.0.1
 */