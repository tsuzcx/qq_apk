package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$7
  extends JsTask
{
  BaseJsExecutor$7(BaseJsExecutor paramBaseJsExecutor, String paramString, Object paramObject, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  protected void a()
  {
    Object localObject = this.this$0.a(this.b, this.c);
    ExecuteScriptCallback localExecuteScriptCallback = this.a;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.7
 * JD-Core Version:    0.7.0.1
 */