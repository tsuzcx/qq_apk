package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.framework.executor.JsTask;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

class JsFlutterEngine$4
  extends JsTask
{
  protected void a()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("routeName", this.a);
      ((Map)localObject).put("widgetData", this.b);
      localObject = new MethodCall("reloadApp", localObject);
      this.this$0.b.invokeMethod(((MethodCall)localObject).method, ((MethodCall)localObject).arguments);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.4
 * JD-Core Version:    0.7.0.1
 */