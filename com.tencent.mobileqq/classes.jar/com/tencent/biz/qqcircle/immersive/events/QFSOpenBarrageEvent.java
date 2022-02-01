package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSOpenBarrageEvent
  extends SimpleBaseEvent
{
  private String mFeedId;
  
  public static QFSOpenBarrageEvent build()
  {
    return new QFSOpenBarrageEvent();
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public QFSOpenBarrageEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSOpenBarrageEvent
 * JD-Core Version:    0.7.0.1
 */