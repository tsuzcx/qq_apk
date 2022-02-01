package com.qflutter.qqcircle;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qqcircle/TencentQQCirclePlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "tencent_qqcircle_release"}, k=1, mv={1, 1, 11})
public final class TencentQQCirclePlugin$Companion
{
  @JvmStatic
  public final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Intrinsics.checkParameterIsNotNull(paramRegistrar, "registrar");
    new MethodChannel(paramRegistrar.messenger(), "tencent_qqcircle").setMethodCallHandler((MethodChannel.MethodCallHandler)new TencentQQCirclePlugin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqcircle.TencentQQCirclePlugin.Companion
 * JD-Core Version:    0.7.0.1
 */