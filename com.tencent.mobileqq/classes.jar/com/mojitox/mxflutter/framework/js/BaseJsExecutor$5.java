package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$5
  extends JsTask
{
  BaseJsExecutor$5(BaseJsExecutor paramBaseJsExecutor, JsObjectType paramJsObjectType, InvokeJSValueCallback paramInvokeJSValueCallback, String paramString, Object[] paramArrayOfObject) {}
  
  public void a()
  {
    try
    {
      if (!this.this$0.a(this.c))
      {
        BaseJsExecutor.a(this.this$0, this.b, new Error("jsObjectNull"));
        return;
      }
      this.this$0.b(this.c, this.d, this.b, this.a);
      return;
    }
    catch (Exception localException)
    {
      BaseJsExecutor.a(this.this$0, this.b, new Error(localException.getMessage(), localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.5
 * JD-Core Version:    0.7.0.1
 */