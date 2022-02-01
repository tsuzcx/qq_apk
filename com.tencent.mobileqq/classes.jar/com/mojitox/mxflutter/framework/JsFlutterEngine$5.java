package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.framework.executor.JsTask;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class JsFlutterEngine$5
  extends JsTask
{
  protected void a()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("channelName", this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put("params", this.jdField_a_of_type_JavaUtilMap);
    ((Map)localObject).put("methodName", this.b);
    localObject = new MethodCall("mxflutterBridgeMethodChannelInvoke", localObject);
    this.this$0.a.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments, this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.5
 * JD-Core Version:    0.7.0.1
 */