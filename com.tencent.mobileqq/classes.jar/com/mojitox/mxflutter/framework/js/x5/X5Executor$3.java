package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import java.util.List;

class X5Executor$3
  extends JsTask
{
  X5Executor$3(X5Executor paramX5Executor, boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  public void a()
  {
    if ((X5Executor.a(this.this$0)) && (this.b))
    {
      X5Executor.a(this.this$0, false);
      X5Executor.b(this.this$0).destroy();
      this.this$0.e().destroy();
      X5Executor.a(this.this$0, null);
      X5Executor.a(this.this$0, null);
      X5Executor.a(this.this$0, null);
    }
    if (X5Executor.c(this.this$0) != null) {
      X5Executor.c(this.this$0).clear();
    }
    ExecuteScriptCallback localExecuteScriptCallback = this.a;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor.3
 * JD-Core Version:    0.7.0.1
 */