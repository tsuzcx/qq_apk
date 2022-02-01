package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleMessageNoticeEvent
  extends SimpleBaseEvent
{
  public final QCircleMessageNoticeInfo mMessageNoticeInfo;
  
  public QCircleMessageNoticeEvent(QCircleMessageNoticeInfo paramQCircleMessageNoticeInfo)
  {
    this.mMessageNoticeInfo = paramQCircleMessageNoticeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent
 * JD-Core Version:    0.7.0.1
 */