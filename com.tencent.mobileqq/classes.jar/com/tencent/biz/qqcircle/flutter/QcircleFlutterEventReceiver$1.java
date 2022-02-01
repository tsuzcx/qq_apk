package com.tencent.biz.qqcircle.flutter;

import com.qflutter.qqcircle.TencentQQCirclePlugin;
import java.util.HashMap;
import java.util.Map;

class QcircleFlutterEventReceiver$1
  implements Runnable
{
  QcircleFlutterEventReceiver$1(QcircleFlutterEventReceiver paramQcircleFlutterEventReceiver, String paramString, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.a);
    localHashMap.put("fuelCount", Integer.valueOf(this.b));
    localHashMap.put("eventType", "updateFuel");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QcircleFlutterEventReceiver.1
 * JD-Core Version:    0.7.0.1
 */