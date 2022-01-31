package com.tencent.biz.pubaccount.weishi_new.download.wsapp;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class WSPicMonitorEvent<T>
  extends SimpleBaseEvent
{
  private T mContent;
  private int mOperateType;
  private int mType;
  
  public WSPicMonitorEvent(int paramInt1, int paramInt2, T paramT)
  {
    this.mType = paramInt1;
    this.mOperateType = paramInt2;
    this.mContent = paramT;
  }
  
  public T getContent()
  {
    return this.mContent;
  }
  
  public int getOperateType()
  {
    return this.mOperateType;
  }
  
  public int getType()
  {
    return this.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSPicMonitorEvent
 * JD-Core Version:    0.7.0.1
 */