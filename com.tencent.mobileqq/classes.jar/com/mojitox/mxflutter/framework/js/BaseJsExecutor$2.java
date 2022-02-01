package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.utils.FileUtils;

class BaseJsExecutor$2
  extends JsTask
{
  BaseJsExecutor$2(BaseJsExecutor paramBaseJsExecutor, String paramString, InvokeJSValueCallback paramInvokeJSValueCallback) {}
  
  public void a()
  {
    try
    {
      Object localObject = FileUtils.c(this.jdField_a_of_type_JavaLangString);
      String str = FileUtils.d(this.jdField_a_of_type_JavaLangString);
      localObject = this.this$0.b((String)localObject, str);
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, new Error("load main js failed", localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.2
 * JD-Core Version:    0.7.0.1
 */