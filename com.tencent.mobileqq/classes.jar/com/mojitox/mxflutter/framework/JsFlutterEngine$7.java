package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.framework.executor.JsTask;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class JsFlutterEngine$7
  extends JsTask
{
  protected void a()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("channelName", this.b);
    ((Map)localObject).put("streamParam", this.f);
    ((Map)localObject).put("onDataId", this.c);
    ((Map)localObject).put("onErrorId", this.e);
    ((Map)localObject).put("onDoneId", this.d);
    ((Map)localObject).put("cancelOnError", Boolean.valueOf(this.a));
    localObject = new MethodCall("mxflutterBridgeEventChannelReceiveBroadcastStreamListenInvoke", localObject);
    this.this$0.b.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.7
 * JD-Core Version:    0.7.0.1
 */