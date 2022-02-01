package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedPointEvent
  extends SimpleBaseEvent
{
  public QQCircleCounter.RedPointInfo mRedPointInfo;
  public int mRedPointMainMsgType;
  
  public QCircleRedPointEvent(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    this.mRedPointMainMsgType = paramInt;
    this.mRedPointInfo = paramRedPointInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleRedPointEvent
 * JD-Core Version:    0.7.0.1
 */