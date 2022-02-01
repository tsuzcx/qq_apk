package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSLayerFeedPosSyncEvent
  extends SimpleBaseEvent
{
  private int position;
  private int sourceType;
  
  public QFSLayerFeedPosSyncEvent(int paramInt1, int paramInt2)
  {
    this.position = paramInt1;
    this.sourceType = paramInt2;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getSourceType()
  {
    return this.sourceType;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setSourceType(int paramInt)
  {
    this.sourceType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent
 * JD-Core Version:    0.7.0.1
 */