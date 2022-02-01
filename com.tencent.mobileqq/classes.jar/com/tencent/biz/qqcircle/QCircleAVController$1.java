package com.tencent.biz.qqcircle;

import com.qflutter.superchannel.SuperChannelPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QCircleAVController$1
  implements Runnable
{
  QCircleAVController$1(QCircleAVController paramQCircleAVController, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      SuperChannelPlugin.sendEvent("tencent_qqcircle/phone_call_state", this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVController", 1, "sendEvent:'tencent_qqcircle/phone_call_state failed'", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleAVController.1
 * JD-Core Version:    0.7.0.1
 */