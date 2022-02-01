package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleTaskCenterEvent
  extends SimpleBaseEvent
{
  public boolean mIsShowTaskPanel;
  public int mPopContextHashCode;
  
  public QCircleTaskCenterEvent(int paramInt, boolean paramBoolean)
  {
    this.mIsShowTaskPanel = paramBoolean;
    this.mPopContextHashCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent
 * JD-Core Version:    0.7.0.1
 */