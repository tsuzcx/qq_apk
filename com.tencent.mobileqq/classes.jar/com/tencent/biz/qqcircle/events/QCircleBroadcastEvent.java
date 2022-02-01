package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleBroadcastEvent
  extends SimpleBaseEvent
{
  public static final String ACTION_PERSONAL_PAGE_SCROLL_TO_TOP_AND_REFRESH = "qcircle_personal_page_scroll_to_top_and_refresh";
  public String mAction;
  
  public QCircleBroadcastEvent(String paramString)
  {
    this.mAction = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleBroadcastEvent
 * JD-Core Version:    0.7.0.1
 */