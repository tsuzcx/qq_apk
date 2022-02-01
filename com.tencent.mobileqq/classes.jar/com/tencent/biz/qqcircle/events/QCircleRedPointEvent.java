package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleCounter.CountInfoRsp;

public class QCircleRedPointEvent
  extends SimpleBaseEvent
{
  public QQCircleCounter.CountInfoRsp mCountInfoRsp;
  public int mRedPointMainMsgType;
  
  public QCircleRedPointEvent(int paramInt, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    this.mRedPointMainMsgType = paramInt;
    this.mCountInfoRsp = paramCountInfoRsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleRedPointEvent
 * JD-Core Version:    0.7.0.1
 */