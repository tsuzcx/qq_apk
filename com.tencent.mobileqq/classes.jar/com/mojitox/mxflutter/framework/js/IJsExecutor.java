package com.mojitox.mxflutter.framework.js;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;

public abstract interface IJsExecutor<Runtime>
{
  public abstract void a();
  
  public abstract void a(boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback);
  
  public abstract boolean a(@NonNull JsObjectType paramJsObjectType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.IJsExecutor
 * JD-Core Version:    0.7.0.1
 */