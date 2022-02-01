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
    QflutterLogPlugin.Log localLog = sLog;
    if (localLog != null) {
      localLog.e("changing logger!");
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
      if (sLog != null)
      {
        paramResult = (String)paramMethodCall.argument("logContent");
        int i = ((Integer)paramMethodCall.argument("logLevel")).intValue();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  return;
                }
                sLog.v(paramResult);
                return;
              }
              sLog.d(paramResult);
              return;
            }
            sLog.i(paramResult);
            return;
          }
          sLog.w(paramResult);
          return;
        }
        sLog.e(paramResult);
      }
    }
    else
    {
      if ("getLogLevel".equals(paramMethodCall.method))
      {
        paramMethodCall = sLog;
        if (paramMethodCall != null) {
          paramMethodCall = Integer.valueOf(paramMethodCall.getLogLevel());
        } else {
          paramMethodCall = Integer.valueOf(1);
        }
      }
      String str;
      do
      {
        paramResult.success(paramMethodCall);
        return;
        if (!"getDylibPath".equals(paramMethodCall.method)) {
          break;
        }
        paramMethodCall = sLog;
        if (paramMethodCall == null)
        {
          paramResult.success(null);
          return;
        }
        str = paramMethodCall.soPath();
        paramMethodCall = str;
      } while (!TextUtils.isEmpty(str));
      paramResult.success(null);
      return;
      paramResult.notImplemented();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.log.qflutter_log.QflutterLogPlugin
 * JD-Core Version:    0.7.0.1
 */