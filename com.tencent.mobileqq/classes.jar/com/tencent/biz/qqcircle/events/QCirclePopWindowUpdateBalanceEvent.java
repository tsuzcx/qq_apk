package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePopWindowUpdateBalanceEvent
  extends SimpleBaseEvent
{
  public int balance;
  public String uin;
  
  public QCirclePopWindowUpdateBalanceEvent(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.balance = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent
 * JD-Core Version:    0.7.0.1
 */