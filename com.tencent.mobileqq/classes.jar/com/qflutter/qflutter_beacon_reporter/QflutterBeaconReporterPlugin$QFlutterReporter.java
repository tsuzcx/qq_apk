package com.qflutter.qflutter_beacon_reporter;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin$QFlutterReporter;", "", "doReport", "", "appkey", "", "channelId", "eventName", "isSucceed", "", "elapse", "", "size", "params", "", "reportImmediately", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)V", "qflutter_beacon_reporter_release"}, k=1, mv={1, 1, 11})
public abstract interface QflutterBeaconReporterPlugin$QFlutterReporter
{
  public abstract void doReport(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Boolean paramBoolean1, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Map<String, String> paramMap, @Nullable Boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.QFlutterReporter
 * JD-Core Version:    0.7.0.1
 */