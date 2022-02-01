package com.qflutter.qflutter_native_router;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_native_router/QflutterNativeRouterPlugin$Companion;", "", "()V", "sRouter", "Lcom/qflutter/qflutter_native_router/NativeRouter;", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "setRouter", "router", "qflutter_native_router_release"}, k=1, mv={1, 1, 11})
public final class QflutterNativeRouterPlugin$Companion
{
  @JvmStatic
  public final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Intrinsics.checkParameterIsNotNull(paramRegistrar, "registrar");
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/native_router").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterNativeRouterPlugin());
  }
  
  @JvmStatic
  public final void setRouter(@Nullable NativeRouter paramNativeRouter)
  {
    if (paramNativeRouter != null) {
      QflutterNativeRouterPlugin.access$setSRouter$cp(paramNativeRouter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin.Companion
 * JD-Core Version:    0.7.0.1
 */