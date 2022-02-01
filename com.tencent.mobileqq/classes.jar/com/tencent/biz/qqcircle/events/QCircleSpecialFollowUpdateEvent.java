package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleSpecialFollowUpdateEvent{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isFollow=");
    localStringBuilder.append(this.isFollow);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent
 * JD-Core Version:    0.7.0.1
 */