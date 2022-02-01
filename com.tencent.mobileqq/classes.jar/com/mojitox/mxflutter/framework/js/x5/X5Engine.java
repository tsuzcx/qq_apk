package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.tencent.smtt.sdk.JsValue;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;

public class X5Engine
  extends BaseJsEngine<X5Executor>
{
  private void e()
  {
    ((X5Executor)b()).b(new X5Engine.1(this));
  }
  
  protected void a(@NonNull ExecuteScriptCallback paramExecuteScriptCallback)
  {
    ((X5Executor)b()).a(true, new X5Engine.2(this, paramExecuteScriptCallback));
  }
  
  public void a(String paramString, MethodCall paramMethodCall, ExecuteScriptCallback paramExecuteScriptCallback)
  {
    paramString = a(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("method", paramMethodCall.method);
    localHashMap.put("arguments", paramMethodCall.arguments);
    if ((paramString instanceof JsValue))
    {
      ((X5Executor)b()).a((JsValue)paramString, localHashMap, true, paramExecuteScriptCallback);
      return;
    }
    if ((paramString instanceof String)) {
      ((X5Executor)b()).a((String)paramString, localHashMap, paramExecuteScriptCallback);
    }
  }
  
  public void a(String paramString, Map paramMap)
  {
    paramString = a(paramString);
    if ((paramString instanceof JsValue))
    {
      ((X5Executor)b()).a((JsValue)paramString, paramMap);
      return;
    }
    if ((paramString instanceof String)) {
      ((X5Executor)b()).a((String)paramString, paramMap, null);
    }
  }
  
  protected void c()
  {
    e();
  }
  
  @NonNull
  protected X5Executor d()
  {
    return new X5Executor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Engine
 * JD-Core Version:    0.7.0.1
 */