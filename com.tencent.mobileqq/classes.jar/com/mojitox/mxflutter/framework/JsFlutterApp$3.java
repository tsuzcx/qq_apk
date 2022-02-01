package com.mojitox.mxflutter.framework;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.common.JsLoadErrorMsg;

class JsFlutterApp$3
  implements InvokeJSValueCallback
{
  JsFlutterApp$3(JsFlutterApp paramJsFlutterApp, long paramLong, String paramString) {}
  
  public void a(Error paramError)
  {
    JsLoadErrorMsg.a.a(paramError, this.c);
  }
  
  public void a(@Nullable Object paramObject)
  {
    JsFlutterApp.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp.3
 * JD-Core Version:    0.7.0.1
 */