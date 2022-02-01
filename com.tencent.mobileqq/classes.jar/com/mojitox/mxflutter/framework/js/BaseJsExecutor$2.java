package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.utils.FileUtils;
import com.mojitox.mxflutter.framework.utils.MxLog;

class BaseJsExecutor$2
  extends JsTask
{
  BaseJsExecutor$2(BaseJsExecutor paramBaseJsExecutor, String paramString, InvokeJSValueCallback paramInvokeJSValueCallback) {}
  
  public void a()
  {
    try
    {
      Object localObject = FileUtils.c(this.b);
      String str = FileUtils.d(this.b);
      localObject = this.this$0.b((String)localObject, str);
      BaseJsExecutor.a(this.this$0, this.a, localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      MxLog.b(this.this$0.b(), localThrowable.getMessage(), localThrowable);
      BaseJsExecutor.a(this.this$0, this.a, new Error("load main js failed", localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.2
 * JD-Core Version:    0.7.0.1
 */