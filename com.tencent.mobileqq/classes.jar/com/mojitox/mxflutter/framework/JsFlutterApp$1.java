package com.mojitox.mxflutter.framework;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.ArrayList;

class JsFlutterApp$1
  implements MethodChannel.MethodCallHandler
{
  JsFlutterApp$1(JsFlutterApp paramJsFlutterApp) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("callJS"))
    {
      if (!JsFlutterApp.a(this.a))
      {
        paramResult = new StringBuilder();
        paramResult.append("jsApp is not running");
        paramResult.append(paramMethodCall.arguments);
        MxLog.c("JsFlutterApp", paramResult.toString());
        paramMethodCall = new MethodCall("nativeCall", paramMethodCall.arguments);
        JsFlutterApp.a(this.a).add(paramMethodCall);
        return;
      }
      MXFlutterPlugin.a().a().a(JsObjectType.CURRENT_APP_OBJECT, "nativeCall", paramMethodCall.arguments, new JsFlutterApp.1.1(this, paramResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp.1
 * JD-Core Version:    0.7.0.1
 */