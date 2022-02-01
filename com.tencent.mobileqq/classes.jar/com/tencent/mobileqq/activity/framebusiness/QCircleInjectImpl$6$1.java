package com.tencent.mobileqq.activity.framebusiness;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import com.tencent.qphone.base.util.QLog;

class QCircleInjectImpl$6$1
  implements Runnable
{
  QCircleInjectImpl$6$1(QCircleInjectImpl.6 param6, Intent paramIntent) {}
  
  public void run()
  {
    if (this.a.getAction().equals("mqq.intent.action.ACCOUNT_CHANGED"))
    {
      QLog.d("QCBT-QCircleInjectImpl", 1, "account chang from receiver");
      SimpleEventBus.getInstance().dispatchEvent(new FSAccountChangeEvent(true));
      com.tencent.mobileqq.activity.qcircle.QCircleFrame.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.6.1
 * JD-Core Version:    0.7.0.1
 */