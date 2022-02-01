package com.qflutter.qqcircle;

import android.os.Build.VERSION;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qqcircle/TencentQQCirclePlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "tencent_qqcircle_release"}, k=1, mv={1, 1, 11})
public final class TencentQQCirclePlugin
  implements MethodChannel.MethodCallHandler
{
  public static final TencentQQCirclePlugin.Companion Companion = new TencentQQCirclePlugin.Companion(null);
  
  @JvmStatic
  public static final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Companion.registerWith(paramRegistrar);
  }
  
  public void onMethodCall(@NotNull MethodCall paramMethodCall, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    if (Intrinsics.areEqual(paramMethodCall.method, "getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall.toString());
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqcircle.TencentQQCirclePlugin
 * JD-Core Version:    0.7.0.1
 */