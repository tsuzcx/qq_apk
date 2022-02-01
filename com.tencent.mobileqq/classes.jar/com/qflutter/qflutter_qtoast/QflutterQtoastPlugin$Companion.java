package com.qflutter.qflutter_qtoast;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_qtoast/QflutterQtoastPlugin$Companion;", "", "()V", "sToast", "Lcom/qflutter/qflutter_qtoast/QFlutterToast;", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "setToast", "toast", "qflutter_qtoast_release"}, k=1, mv={1, 1, 11})
public final class QflutterQtoastPlugin$Companion
{
  @JvmStatic
  public final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Intrinsics.checkParameterIsNotNull(paramRegistrar, "registrar");
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/qtoast").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterQtoastPlugin());
  }
  
  @JvmStatic
  public final void setToast(@Nullable QFlutterToast paramQFlutterToast)
  {
    if (paramQFlutterToast != null) {
      QflutterQtoastPlugin.access$setSToast$cp(paramQFlutterToast);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qflutter_qtoast.QflutterQtoastPlugin.Companion
 * JD-Core Version:    0.7.0.1
 */