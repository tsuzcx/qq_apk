package com.mojitox.mxflutter.framework.common;

import com.mojitox.mxflutter.framework.JsFlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run", "com/mojitox/mxflutter/framework/common/JsLoadErrorMsg$invokeJsErrorMethodChannel$1$1"}, k=3, mv={1, 1, 11})
final class JsLoadErrorMsg$invokeJsErrorMethodChannel$$inlined$run$lambda$1
  implements Runnable
{
  JsLoadErrorMsg$invokeJsErrorMethodChannel$$inlined$run$lambda$1(JsFlutterEngine paramJsFlutterEngine, Error paramError, String paramString) {}
  
  public final void run()
  {
    this.c.b.invokeMethod("mxflutterJSExceptionHandler", JsLoadErrorMsg.a(JsLoadErrorMsg.a, this.a, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.common.JsLoadErrorMsg.invokeJsErrorMethodChannel..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */