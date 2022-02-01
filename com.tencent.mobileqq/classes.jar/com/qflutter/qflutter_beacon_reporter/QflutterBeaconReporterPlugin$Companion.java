package com.qflutter.qflutter_beacon_reporter;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin$Companion;", "", "()V", "sReporter", "Lcom/qflutter/qflutter_beacon_reporter/QflutterBeaconReporterPlugin$QFlutterReporter;", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "setReporter", "reporter", "qflutter_beacon_reporter_release"}, k=1, mv={1, 1, 11})
public final class QflutterBeaconReporterPlugin$Companion
{
  @JvmStatic
  public final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Intrinsics.checkParameterIsNotNull(paramRegistrar, "registrar");
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/qflutter_beacon_reporter").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterBeaconReporterPlugin());
  }
  
  @JvmStatic
  public final void setReporter(@Nullable QflutterBeaconReporterPlugin.QFlutterReporter paramQFlutterReporter)
  {
    if (paramQFlutterReporter != null) {
      QflutterBeaconReporterPlugin.access$setSReporter$cp(paramQFlutterReporter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.Companion
 * JD-Core Version:    0.7.0.1
 */