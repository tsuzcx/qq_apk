package com.qflutter.qflutter_qtoast;

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
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_qtoast/QflutterQtoastPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "qflutter_qtoast_release"}, k=1, mv={1, 1, 11})
public final class QflutterQtoastPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final QflutterQtoastPlugin.Companion Companion = new QflutterQtoastPlugin.Companion(null);
  private static QFlutterToast sToast;
  
  @JvmStatic
  public static final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Companion.registerWith(paramRegistrar);
  }
  
  @JvmStatic
  public static final void setToast(@Nullable QFlutterToast paramQFlutterToast)
  {
    Companion.setToast(paramQFlutterToast);
  }
  
  public void onAttachedToEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "flutterPluginBinding");
    new MethodChannel((BinaryMessenger)paramFlutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.tencent.qflutter/qtoast").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterQtoastPlugin());
  }
  
  public void onDetachedFromEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "binding");
  }
  
  public void onMethodCall(@NonNull @NotNull MethodCall paramMethodCall, @NonNull @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    Object localObject = paramMethodCall.method;
    if (localObject == null) {}
    label180:
    do
    {
      do
      {
        int i;
        do
        {
          paramResult.notImplemented();
          return;
          i = ((String)localObject).hashCode();
          if (i == -1867169789) {
            break label180;
          }
          if (i == 3529469) {
            break;
          }
        } while ((i != 96784904) || (!((String)localObject).equals("error")));
        paramMethodCall = paramMethodCall.arguments;
        if (paramMethodCall != null)
        {
          paramMethodCall = (String)paramMethodCall;
          localObject = sToast;
          if (localObject != null) {
            ((QFlutterToast)localObject).error(paramMethodCall);
          }
          paramResult.success(Integer.valueOf(0));
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      } while (!((String)localObject).equals("show"));
      paramMethodCall = paramMethodCall.arguments;
      if (paramMethodCall != null)
      {
        paramMethodCall = (String)paramMethodCall;
        localObject = sToast;
        if (localObject != null) {
          ((QFlutterToast)localObject).show(paramMethodCall);
        }
        paramResult.success(Integer.valueOf(0));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    } while (!((String)localObject).equals("success"));
    paramMethodCall = paramMethodCall.arguments;
    if (paramMethodCall != null)
    {
      paramMethodCall = (String)paramMethodCall;
      localObject = sToast;
      if (localObject != null) {
        ((QFlutterToast)localObject).success(paramMethodCall);
      }
      paramResult.success(Integer.valueOf(0));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_qtoast.QflutterQtoastPlugin
 * JD-Core Version:    0.7.0.1
 */