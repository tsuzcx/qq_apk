package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.MotionEvent;

public class QFSTapClickEvent
  extends QFSBaseFeedPresenterEvent
{
  private MotionEvent a;
  private String b;
  
  public QFSTapClickEvent(String paramString, MotionEvent paramMotionEvent)
  {
    this.b = paramString;
    this.a = paramMotionEvent;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public MotionEvent b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.event.QFSTapClickEvent
 * JD-Core Version:    0.7.0.1
 */