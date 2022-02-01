package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.SpecialFollowListResp;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleSpecialFollowListLoadEvent
  extends SimpleBaseEvent
{
  public final boolean isRefresh;
  public final QCircleSpecialFollowManager.SpecialFollowListResp resp;
  
  public QCircleSpecialFollowListLoadEvent(QCircleSpecialFollowManager.SpecialFollowListResp paramSpecialFollowListResp, boolean paramBoolean)
  {
    this.resp = paramSpecialFollowListResp;
    this.isRefresh = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent
 * JD-Core Version:    0.7.0.1
 */