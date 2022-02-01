package com.mojitox.mxflutter.framework;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.constants.MxConfig;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class JsFlutterEngine$1
  implements MethodChannel.MethodCallHandler
{
  JsFlutterEngine$1(JsFlutterEngine paramJsFlutterEngine) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    Object localObject = paramMethodCall.method;
    int i = ((String)localObject).hashCode();
    if (i != -1299635294)
    {
      if (i != 104315289)
      {
        if ((i == 2018123172) && (((String)localObject).equals("callJsCallbackFunction")))
        {
          i = 1;
          break label80;
        }
      }
      else if (((String)localObject).equals("mxLog"))
      {
        i = 2;
        break label80;
      }
    }
    else if (((String)localObject).equals("callNativeRunJSApp"))
    {
      i = 0;
      break label80;
    }
    i = -1;
    label80:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        MxLog.c("MXJSFlutterEngine", paramMethodCall.arguments.toString());
        return;
      }
      localObject = (String)paramMethodCall.argument("callbackId");
      paramMethodCall = (Map)paramMethodCall.argument("param");
      JsEngineLoader.a().a().a((String)localObject, paramMethodCall);
    }
    else
    {
      localObject = (Map)paramMethodCall.argument("flutterAppEnvironmentInfo");
      MxConfig.a(paramMethodCall);
      this.a.a((Map)localObject);
    }
    paramResult.success("success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.1
 * JD-Core Version:    0.7.0.1
 */