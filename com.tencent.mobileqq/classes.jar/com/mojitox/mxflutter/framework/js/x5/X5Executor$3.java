package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import java.util.ArrayList;

class X5Executor$3
  extends JsTask
{
  X5Executor$3(X5Executor paramX5Executor, boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  public void a()
  {
    if ((X5Executor.a(this.this$0)) && (this.jdField_a_of_type_Boolean))
    {
      X5Executor.a(this.this$0, false);
      X5Executor.a(this.this$0).destroy();
      this.this$0.a().destroy();
      X5Executor.a(this.this$0, null);
      X5Executor.a(this.this$0, null);
    }
    if (X5Executor.a(this.this$0) != null) {
      X5Executor.a(this.this$0).clear();
    }
    ExecuteScriptCallback localExecuteScriptCallback = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackExecuteScriptCallback;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor.3
 * JD-Core Version:    0.7.0.1
 */