package com.tencent.biz.expand.flutter;

import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.QFlutterReporter;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/flutter/ExpandFlutterUtils$initReporter$1", "Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin$QFlutterReporter;", "doReport", "", "appkey", "", "channelId", "eventName", "isSucceed", "", "elapse", "", "size", "params", "", "reportImmediately", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$initReporter$1
  implements QflutterBeaconReporterPlugin.QFlutterReporter
{
  public void doReport(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Boolean paramBoolean1, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Map<String, String> paramMap, @Nullable Boolean paramBoolean2)
  {
    boolean bool1 = false;
    if (paramBoolean1 != null)
    {
      paramBoolean1.booleanValue();
      bool1 = paramBoolean1.booleanValue();
    }
    long l1 = 0L;
    if (paramInteger1 != null)
    {
      ((Number)paramInteger1).intValue();
      l1 = paramInteger1.intValue();
    }
    long l2 = 0L;
    if (paramInteger2 != null)
    {
      ((Number)paramInteger2).intValue();
      l2 = paramInteger2.intValue();
    }
    boolean bool2 = false;
    if (paramBoolean2 != null)
    {
      paramBoolean2.booleanValue();
      bool2 = paramBoolean2.booleanValue();
    }
    paramString2 = (1)this;
    UserAction.onUserActionToTunnel(paramString1, paramString3, bool1, l1, l2, paramMap, bool2, bool2);
    if (QLog.isColorLevel()) {
      QLog.d("ExpandFlutterUtils", 2, "[doReport] appkey=" + paramString1 + " eventName=" + paramString3 + " isSucc=" + bool1 + ' ' + "longElapse=" + l1 + " longSize=" + l2 + " params=" + paramMap + " immediat=" + bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterUtils.initReporter.1
 * JD-Core Version:    0.7.0.1
 */