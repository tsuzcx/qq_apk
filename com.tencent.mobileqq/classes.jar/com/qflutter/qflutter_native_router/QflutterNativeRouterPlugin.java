package com.qflutter.qflutter_native_router;

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

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_native_router/QflutterNativeRouterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "qflutter_native_router_release"}, k=1, mv={1, 1, 11})
public final class QflutterNativeRouterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final QflutterNativeRouterPlugin.Companion Companion = new QflutterNativeRouterPlugin.Companion(null);
  private static NativeRouter sRouter;
  
  @JvmStatic
  public static final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Companion.registerWith(paramRegistrar);
  }
  
  @JvmStatic
  public static final void setRouter(@Nullable NativeRouter paramNativeRouter)
  {
    Companion.setRouter(paramNativeRouter);
  }
  
  public void onAttachedToEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "flutterPluginBinding");
    new MethodChannel((BinaryMessenger)paramFlutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.tencent.qflutter/native_router").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterNativeRouterPlugin());
  }
  
  public void onDetachedFromEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "binding");
  }
  
  public void onMethodCall(@NonNull @NotNull MethodCall paramMethodCall, @NonNull @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    Object localObject2 = paramMethodCall.method;
    if (localObject2 != null)
    {
      int i = ((String)localObject2).hashCode();
      Object localObject1 = null;
      if (i != -1812943591)
      {
        if ((i != 2075029808) || (!((String)localObject2).equals("openNativePage"))) {
          break label167;
        }
        localObject2 = paramMethodCall.arguments;
        paramMethodCall = (MethodCall)localObject1;
        if (localObject2 != null) {
          paramMethodCall = localObject2.toString();
        }
        localObject1 = paramMethodCall;
        paramMethodCall = sRouter;
        if (paramMethodCall == null) {
          return;
        }
        localObject2 = null;
      }
      else
      {
        if (!((String)localObject2).equals("openNativePageLegacy")) {
          break label167;
        }
        localObject1 = (String)paramMethodCall.argument("url");
        localObject2 = paramMethodCall.argument("params");
        paramMethodCall = (MethodCall)localObject2;
        if (!(localObject2 instanceof Map)) {
          paramMethodCall = null;
        }
        localObject2 = (Map)paramMethodCall;
        paramMethodCall = sRouter;
        if (paramMethodCall == null) {
          return;
        }
      }
      paramMethodCall.openNativePage(null, (String)localObject1, (Map)localObject2, null, paramResult);
      return;
    }
    label167:
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin
 * JD-Core Version:    0.7.0.1
 */