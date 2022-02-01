package com.tencent.biz.qqcircle.flutter;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDanmakuLayer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;

final class QQCircleMethodMine$3
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("QQCircleMethodMine", 4, "qcircle_flutter_activity_destroy");
    if (QQCircleMethodMine.access$000() != null)
    {
      QLog.d("QQCircleMethodMine", 4, "qCircleFlutterDanmakuLayer destroyed");
      QQCircleMethodMine.access$000().i();
      QQCircleMethodMine.access$000().v();
      QQCircleMethodMine.access$002(null);
    }
    QQCircleMethodMine.access$102(null);
    QQCircleMethodMine.access$202(null);
    QQCircleMethodMine.access$302(false);
    QCircleApplication.APP.unregisterReceiver(QQCircleMethodMine.access$400());
    SimpleEventBus.getInstance().unRegisterReceiver(QcircleFlutterEventReceiver.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.3
 * JD-Core Version:    0.7.0.1
 */