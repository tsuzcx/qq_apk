package com.tencent.biz.qqcircle.flutter;

import com.qflutter.qqcircle.TencentQQCirclePlugin;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;

class QQCircleMethodMine$1$1$1
  implements Runnable
{
  QQCircleMethodMine$1$1$1(QQCircleMethodMine.1.1 param1) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloaded", Boolean.valueOf(true));
    this.a.a.b.success(localHashMap);
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/pushAnimationResource", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.1.1.1
 * JD-Core Version:    0.7.0.1
 */