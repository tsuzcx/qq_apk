package com.tencent.biz.qqcircle.flutter.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFlutterPolyLikeCloseEvent
  extends SimpleBaseEvent
{
  public static final int CLICK_EVENT = 1;
  public static final int DISMISS_EVENT = 0;
  public int mIsClickItem;
  
  public QCircleFlutterPolyLikeCloseEvent(int paramInt)
  {
    this.mIsClickItem = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.event.QCircleFlutterPolyLikeCloseEvent
 * JD-Core Version:    0.7.0.1
 */