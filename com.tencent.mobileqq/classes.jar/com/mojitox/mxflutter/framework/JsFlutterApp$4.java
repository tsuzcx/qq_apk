package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.MXFlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class JsFlutterApp$4
  implements Runnable
{
  JsFlutterApp$4(JsFlutterApp paramJsFlutterApp) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("success", Boolean.valueOf(true));
    localObject = new MethodCall("mxflutterJSEngineInitSuccessHandler", localObject);
    MXFlutterPlugin.a().a().a.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp.4
 * JD-Core Version:    0.7.0.1
 */