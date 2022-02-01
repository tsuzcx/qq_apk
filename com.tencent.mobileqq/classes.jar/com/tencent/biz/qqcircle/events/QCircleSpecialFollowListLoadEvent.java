package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vos;

public class QCircleSpecialFollowListLoadEvent
  extends SimpleBaseEvent
{
  public final boolean isRefresh;
  public final vos resp;
  
  public QCircleSpecialFollowListLoadEvent(vos paramvos, boolean paramBoolean)
  {
    this.resp = paramvos;
    this.isRefresh = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent
 * JD-Core Version:    0.7.0.1
 */