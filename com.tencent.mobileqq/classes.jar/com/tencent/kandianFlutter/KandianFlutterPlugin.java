package com.tencent.kandianFlutter;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/kandianFlutter/KandianFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "kandianFlutter_release"}, k=1, mv={1, 1, 11})
public final class KandianFlutterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel a;
  
  public void onAttachedToEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "flutterPluginBinding");
    this.a = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "kandianFlutter");
    paramFlutterPluginBinding = this.a;
    if (paramFlutterPluginBinding == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler((MethodChannel.MethodCallHandler)this);
  }
  
  public void onDetachedFromEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "binding");
    paramFlutterPluginBinding = this.a;
    if (paramFlutterPluginBinding == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler(null);
  }
  
  public void onMethodCall(@NonNull @NotNull MethodCall paramMethodCall, @NonNull @NotNull MethodChannel.Result paramResult)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kandianFlutter.KandianFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */