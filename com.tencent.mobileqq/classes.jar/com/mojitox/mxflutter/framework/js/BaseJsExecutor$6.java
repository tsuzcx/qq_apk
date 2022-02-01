package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.executor.JsTask;

class BaseJsExecutor$6
  extends JsTask
{
  BaseJsExecutor$6(BaseJsExecutor paramBaseJsExecutor, String paramString, Object paramObject, ExecuteScriptCallback paramExecuteScriptCallback) {}
  
  protected void a()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangObject);
    ExecuteScriptCallback localExecuteScriptCallback = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackExecuteScriptCallback;
    if (localExecuteScriptCallback != null) {
      localExecuteScriptCallback.a(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.6
 * JD-Core Version:    0.7.0.1
 */