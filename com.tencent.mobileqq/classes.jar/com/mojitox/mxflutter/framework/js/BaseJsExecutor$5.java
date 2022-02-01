package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$5
  extends JsTask
{
  BaseJsExecutor$5(BaseJsExecutor paramBaseJsExecutor, Object paramObject1, Object paramObject2, boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  protected void a()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangObject, this.b, this.jdField_a_of_type_Boolean);
    ExecuteScriptCallback localExecuteScriptCallback = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackExecuteScriptCallback;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.5
 * JD-Core Version:    0.7.0.1
 */