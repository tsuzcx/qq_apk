package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import io.flutter.plugin.common.MethodCall;
import java.util.Map;

public abstract interface IJsEngine<T extends BaseJsExecutor>
{
  public abstract void a(String paramString, MethodCall paramMethodCall, ExecuteScriptCallback paramExecuteScriptCallback);
  
  public abstract void a(String paramString, Map paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.IJsEngine
 * JD-Core Version:    0.7.0.1
 */