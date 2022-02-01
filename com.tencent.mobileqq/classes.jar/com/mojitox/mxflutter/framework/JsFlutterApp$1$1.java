package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.common.JsLoadErrorMsg;
import com.mojitox.mxflutter.framework.executor.UiThread;
import io.flutter.plugin.common.MethodChannel.Result;

class JsFlutterApp$1$1
  implements InvokeJSValueCallback
{
  JsFlutterApp$1$1(JsFlutterApp.1 param1, MethodChannel.Result paramResult) {}
  
  public void a(Error paramError)
  {
    this.b.error(paramError.toString(), null, null);
    JsLoadErrorMsg.a.a(paramError, "");
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    } else {
      paramObject = paramObject.toString();
    }
    UiThread.a(new JsFlutterApp.1.1.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp.1.1
 * JD-Core Version:    0.7.0.1
 */