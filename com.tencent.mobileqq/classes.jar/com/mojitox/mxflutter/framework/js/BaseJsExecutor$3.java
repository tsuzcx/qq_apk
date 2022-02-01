package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.utils.FileUtils;

class BaseJsExecutor$3
  extends JsTask
{
  public void a()
  {
    try
    {
      Object localObject = FileUtils.d(this.b);
      localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, (String)localObject);
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      BaseJsExecutor.a(this.this$0, this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback, new Error("load bundle js failed", localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.3
 * JD-Core Version:    0.7.0.1
 */