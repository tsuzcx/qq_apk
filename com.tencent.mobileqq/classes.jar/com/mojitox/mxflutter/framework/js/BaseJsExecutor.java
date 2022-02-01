package com.mojitox.mxflutter.framework.js;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.JobExecutor;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.executor.UiThread;
import java.util.Map;

public abstract class BaseJsExecutor<T, S>
  implements IJsExecutor<T>
{
  private JobExecutor a;
  
  private void a(InvokeJSValueCallback paramInvokeJSValueCallback, Error paramError)
  {
    if (paramInvokeJSValueCallback != null) {
      UiThread.c(new BaseJsExecutor.9(this, paramInvokeJSValueCallback, paramError));
    }
  }
  
  private void a(InvokeJSValueCallback paramInvokeJSValueCallback, Object paramObject)
  {
    if (paramInvokeJSValueCallback != null)
    {
      if (!c())
      {
        paramInvokeJSValueCallback.a(paramObject);
        return;
      }
      UiThread.c(new BaseJsExecutor.8(this, paramInvokeJSValueCallback, paramObject));
    }
  }
  
  @NonNull
  public JobExecutor a()
  {
    if (this.a == null) {
      this.a = new JobExecutor();
    }
    return this.a;
  }
  
  @Nullable
  public Object a(@NonNull JsObjectType paramJsObjectType, String paramString, Object paramObject)
  {
    try
    {
      if (!a(paramJsObjectType)) {
        return null;
      }
      paramJsObjectType = b(paramJsObjectType, paramString, paramObject);
      return paramJsObjectType;
    }
    catch (Exception paramJsObjectType) {}
    return null;
  }
  
  protected abstract Object a(String paramString, Object paramObject);
  
  protected abstract Object a(String paramString1, String paramString2);
  
  public void a(@NonNull JsObjectType paramJsObjectType, String paramString, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback, Object... paramVarArgs)
  {
    paramJsObjectType = new BaseJsExecutor.5(this, paramJsObjectType, paramInvokeJSValueCallback, paramString, paramVarArgs);
    paramInvokeJSValueCallback = new StringBuilder();
    paramInvokeJSValueCallback.append("invokeJSValueWithJsCallback#");
    paramInvokeJSValueCallback.append(paramString);
    a(paramJsObjectType.a(paramInvokeJSValueCallback.toString()));
  }
  
  public void a(@NonNull JsObjectType paramJsObjectType, String paramString, Object paramObject, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    paramJsObjectType = new BaseJsExecutor.4(this, paramJsObjectType, paramInvokeJSValueCallback, paramString, paramObject);
    paramObject = new StringBuilder();
    paramObject.append("invokeJSValue#");
    paramObject.append(paramString);
    a(paramJsObjectType.a(paramObject.toString()));
  }
  
  public void a(JsTask paramJsTask)
  {
    a().execute(paramJsTask);
  }
  
  public void a(@NonNull S paramS, Object paramObject, boolean paramBoolean)
  {
    a(paramS, paramObject, paramBoolean, null);
  }
  
  public void a(@NonNull S paramS, Object paramObject, boolean paramBoolean, @Nullable ExecuteScriptCallback paramExecuteScriptCallback)
  {
    a(new BaseJsExecutor.6(this, paramS, paramObject, paramBoolean, paramExecuteScriptCallback).a("invokeJsFunction#"));
  }
  
  public void a(@NonNull S paramS, Map paramMap)
  {
    a(paramS, paramMap, true, null);
  }
  
  public void a(String paramString, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    paramInvokeJSValueCallback = new BaseJsExecutor.2(this, paramString, paramInvokeJSValueCallback);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("executeScriptPath#");
    localStringBuilder.append(paramString);
    a(paramInvokeJSValueCallback.a(localStringBuilder.toString()));
  }
  
  public void a(String paramString, Object paramObject, @Nullable ExecuteScriptCallback paramExecuteScriptCallback)
  {
    a(new BaseJsExecutor.7(this, paramString, paramObject, paramExecuteScriptCallback).a("invokeJsFunction#"));
  }
  
  public void a(String paramString, Object paramObject, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    a(JsObjectType.APP_OBJECT, paramString, paramObject, paramInvokeJSValueCallback);
  }
  
  protected abstract Object b(@NonNull JsObjectType paramJsObjectType, String paramString, Object paramObject);
  
  protected abstract Object b(@NonNull S paramS, Object paramObject, boolean paramBoolean);
  
  protected abstract Object b(String paramString1, String paramString2);
  
  @NonNull
  protected abstract String b();
  
  protected abstract void b(@NonNull JsObjectType paramJsObjectType, String paramString, InvokeJSValueCallback paramInvokeJSValueCallback, Object... paramVarArgs);
  
  public void b(String paramString, @Nullable Object paramObject)
  {
    paramObject = new BaseJsExecutor.1(this, paramString, paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerGlobalObject#");
    localStringBuilder.append(paramString);
    a(paramObject.a(localStringBuilder.toString()));
  }
  
  protected abstract void c(String paramString, @Nullable Object paramObject);
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor
 * JD-Core Version:    0.7.0.1
 */