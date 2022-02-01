package com.tencent.mobileqq.activity.qcircle.handler;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.app.BusinessObserver;

public class QCircleObserver
  implements BusinessObserver
{
  protected void a(int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = ((Integer)paramObject).intValue();
    RFLog.d("QCircleObserver", RFLog.USR, "TYPE_UPDATE_RED_POINT_DISPLAY repointNum");
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver
 * JD-Core Version:    0.7.0.1
 */