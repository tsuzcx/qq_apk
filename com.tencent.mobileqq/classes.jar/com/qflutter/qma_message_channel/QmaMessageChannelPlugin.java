package com.qflutter.qma_message_channel;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class QmaMessageChannelPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel a;
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.a = new MethodChannel(paramFlutterPluginBinding.getFlutterEngine().getDartExecutor(), "qma_message_channel");
    this.a.setMethodCallHandler(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.a.setMethodCallHandler(null);
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("getPlatformVersion"))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qma_message_channel.QmaMessageChannelPlugin
 * JD-Core Version:    0.7.0.1
 */