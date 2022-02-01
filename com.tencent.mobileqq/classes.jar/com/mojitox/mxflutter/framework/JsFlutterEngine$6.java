package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.framework.executor.JsTask;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class JsFlutterEngine$6
  extends JsTask
{
  protected void a()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("channelName", this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put("streamParam", this.e);
    ((Map)localObject).put("onDataId", this.b);
    ((Map)localObject).put("onErrorId", this.d);
    ((Map)localObject).put("onDoneId", this.c);
    ((Map)localObject).put("cancelOnError", Boolean.valueOf(this.jdField_a_of_type_Boolean));
    localObject = new MethodCall("mxflutterBridgeEventChannelReceiveBroadcastStreamListenInvoke", localObject);
    this.this$0.a.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.6
 * JD-Core Version:    0.7.0.1
 */