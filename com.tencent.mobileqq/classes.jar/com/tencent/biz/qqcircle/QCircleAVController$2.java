package com.tencent.biz.qqcircle;

import com.qflutter.superchannel.SuperChannelPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QCircleAVController$2
  implements Runnable
{
  QCircleAVController$2(QCircleAVController paramQCircleAVController) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("state", Integer.valueOf(QCirclePluginConfig.PhoneCallState.INCOMING.ordinal()));
    try
    {
      SuperChannelPlugin.sendEvent("tencent_qqcircle/phone_call_state", localHashMap);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVController", 1, "sendEvent:'tencent_qqcircle/phone_call_state failed'", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleAVController.2
 * JD-Core Version:    0.7.0.1
 */