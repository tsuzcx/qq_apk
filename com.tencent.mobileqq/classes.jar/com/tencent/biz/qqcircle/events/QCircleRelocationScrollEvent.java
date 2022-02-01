package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleRelocationScrollEvent
  extends SimpleBaseEvent
{
  public String mFeedId = "";
  public int mInpuPanelHeight = 0;
  public int mKeyboardHeight = 0;
  public int mRelocationType = 0;
  
  public QCircleRelocationScrollEvent(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFeedId = paramString;
    this.mKeyboardHeight = paramInt1;
    this.mInpuPanelHeight = paramInt2;
    this.mRelocationType = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleRelocationScrollEvent
 * JD-Core Version:    0.7.0.1
 */