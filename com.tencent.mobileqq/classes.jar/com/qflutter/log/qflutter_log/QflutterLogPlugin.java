package com.qflutter.log.qflutter_log;

import android.text.TextUtils;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class QflutterLogPlugin
  implements MethodChannel.MethodCallHandler
{
  public static QflutterLogPlugin.Log sLog;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/log_channel").setMethodCallHandler(new QflutterLogPlugin());
  }
  
  public static void setLog(QflutterLogPlugin.Log paramLog)
  {
    if (sLog != null) {
      sLog.e("changing logger!");
    }
    sLog = paramLog;
    paramLog = sLog.soPath();
    if (TextUtils.isEmpty(paramLog))
    {
      System.loadLibrary("QFlutterLog");
      return;
    }
    System.load(paramLog);
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if ("printLog".equals(paramMethodCall.method))
    {
      if (sLog != null) {
        paramResult = (String)paramMethodCall.argument("logContent");
      }
      switch (((Integer)paramMethodCall.argument("logLevel")).intValue())
      {
      default: 
        return;
      case 5: 
        sLog.v(paramResult);
        return;
      case 4: 
        sLog.d(paramResult);
        return;
      case 3: 
        sLog.i(paramResult);
        return;
      case 2: 
        sLog.w(paramResult);
        return;
      }
      sLog.e(paramResult);
      return;
    }
    if ("getLogLevel".equals(paramMethodCall.method))
    {
      if (sLog != null)
      {
        paramResult.success(Integer.valueOf(sLog.getLogLevel()));
        return;
      }
      paramResult.success(Integer.valueOf(1));
      return;
    }
    if ("getDylibPath".equals(paramMethodCall.method))
    {
      if (sLog == null)
      {
        paramResult.success(null);
        return;
      }
      paramMethodCall = sLog.soPath();
      if (TextUtils.isEmpty(paramMethodCall))
      {
        paramResult.success(null);
        return;
      }
      paramResult.success(paramMethodCall);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.log.qflutter_log.QflutterLogPlugin
 * JD-Core Version:    0.7.0.1
 */