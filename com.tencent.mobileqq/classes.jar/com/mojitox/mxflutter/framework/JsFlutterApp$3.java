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
    JsLoadErrorMsg.a.a(paramError, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(@Nullable Object paramObject)
  {
    JsFlutterApp.a(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterApp, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp.3
 * JD-Core Version:    0.7.0.1
 */