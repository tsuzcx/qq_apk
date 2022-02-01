package com.mojitox.mxflutter.framework.common;

import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.JsFlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run", "com/mojitox/mxflutter/framework/common/JsLoadErrorMsg$invokeJsErrorMethodChannel$1$1"}, k=3, mv={1, 1, 11})
final class JsLoadErrorMsg$invokeJsErrorMethodChannel$$inlined$run$lambda$1
  implements Runnable
{
  JsLoadErrorMsg$invokeJsErrorMethodChannel$$inlined$run$lambda$1(Error paramError, String paramString) {}
  
  public final void run()
  {
    MXFlutterPlugin localMXFlutterPlugin = MXFlutterPlugin.a();
    Intrinsics.checkExpressionValueIsNotNull(localMXFlutterPlugin, "MXFlutterPlugin.get()");
    localMXFlutterPlugin.a().a.invokeMethod("mxflutterJSExceptionHandler", JsLoadErrorMsg.a(JsLoadErrorMsg.a, this.jdField_a_of_type_JavaLangError, this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.common.JsLoadErrorMsg.invokeJsErrorMethodChannel..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */