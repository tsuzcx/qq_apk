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
    ((Map)localObject).put("channelName", this.b);
    ((Map)localObject).put("params", this.d);
    ((Map)localObject).put("methodName", this.c);
    localObject = new MethodCall("mxflutterBridgeMethodChannelInvoke", localObject);
    this.this$0.b.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.6
 * JD-Core Version:    0.7.0.1
 */