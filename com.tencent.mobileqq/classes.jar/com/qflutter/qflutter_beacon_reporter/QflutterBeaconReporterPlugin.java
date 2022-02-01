package com.qflutter.qflutter_beacon_reporter;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "QFlutterReporter", "qflutter_beacon_reporter_release"}, k=1, mv={1, 1, 11})
public final class QflutterBeaconReporterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final QflutterBeaconReporterPlugin.Companion Companion = new QflutterBeaconReporterPlugin.Companion(null);
  private static QflutterBeaconReporterPlugin.QFlutterReporter sReporter;
  
  @JvmStatic
  public static final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Companion.registerWith(paramRegistrar);
  }
  
  @JvmStatic
  public static final void setReporter(@Nullable QflutterBeaconReporterPlugin.QFlutterReporter paramQFlutterReporter)
  {
    Companion.setReporter(paramQFlutterReporter);
  }
  
  public void onAttachedToEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "flutterPluginBinding");
    new MethodChannel((BinaryMessenger)paramFlutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.tencent.qflutter/qflutter_beacon_reporter").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterBeaconReporterPlugin());
  }
  
  public void onDetachedFromEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "binding");
  }
  
  public void onMethodCall(@NonNull @NotNull MethodCall paramMethodCall, @NonNull @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    String str1 = paramMethodCall.method;
    if (str1 == null) {}
    while ((str1.hashCode() != 360348063) || (!str1.equals("doReport")))
    {
      paramResult.notImplemented();
      return;
    }
    str1 = (String)paramMethodCall.argument("appkey");
    String str2 = (String)paramMethodCall.argument("channelId");
    String str3 = (String)paramMethodCall.argument("eventName");
    Boolean localBoolean = (Boolean)paramMethodCall.argument("isSucceed");
    Integer localInteger1 = (Integer)paramMethodCall.argument("elapse");
    Integer localInteger2 = (Integer)paramMethodCall.argument("size");
    Map localMap = (Map)paramMethodCall.argument("params");
    paramMethodCall = (Boolean)paramMethodCall.argument("reportImmediately");
    QflutterBeaconReporterPlugin.QFlutterReporter localQFlutterReporter = sReporter;
    if (localQFlutterReporter != null) {
      localQFlutterReporter.doReport(str1, str2, str3, localBoolean, localInteger1, localInteger2, localMap, paramMethodCall);
    }
    paramResult.success(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin
 * JD-Core Version:    0.7.0.1
 */