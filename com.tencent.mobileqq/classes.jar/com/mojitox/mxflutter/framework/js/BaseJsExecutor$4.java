package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$4
  extends JsTask
{
  BaseJsExecutor$4(BaseJsExecutor paramBaseJsExecutor, JsObjectType paramJsObjectType, InvokeJSValueCallback paramInvokeJSValueCallback, String paramString, Object paramObject) {}
  
  public void a()
  {
    try
    {
      if (!this.this$0.a(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkConstantsJsObjectType))
      {
        BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, new Error("jsObjectNull"));
        return;
      }
      Object localObject = this.this$0.b(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkConstantsJsObjectType, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangObject);
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, localObject);
      return;
    }
    catch (Exception localException)
    {
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, new Error(localException.getMessage(), localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.4
 * JD-Core Version:    0.7.0.1
 */