package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$6
  extends JsTask
{
  BaseJsExecutor$6(BaseJsExecutor paramBaseJsExecutor, Object paramObject1, Object paramObject2, boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  protected void a()
  {
    Object localObject = this.this$0.b(this.b, this.d, this.c);
    ExecuteScriptCallback localExecuteScriptCallback = this.a;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.6
 * JD-Core Version:    0.7.0.1
 */