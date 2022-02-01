package com.mojitox.mxflutter.framework.js;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.utils.MxLog;

public class JsEngineLoader
{
  private Context a;
  private volatile boolean b;
  private BaseJsEngine c;
  private boolean d;
  private volatile boolean e;
  @Nullable
  private InvokeJSValueCallback f;
  
  public static JsEngineLoader a()
  {
    return JsEngineLoader.SingletonHolder.a();
  }
  
  public void a(@NonNull Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(@NonNull ExecuteScriptCallback paramExecuteScriptCallback)
  {
    this.e = false;
    d().a(paramExecuteScriptCallback);
  }
  
  public void a(@Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    this.f = paramInvokeJSValueCallback;
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#closeEngine begin jsEngine=");
    ((StringBuilder)localObject).append(this.c);
    MxLog.a("JsEngineLoader", ((StringBuilder)localObject).toString());
    this.f = null;
    localObject = this.c;
    if (localObject != null) {
      ((BaseJsEngine)localObject).b().a(this.d ^ true, new JsEngineLoader.1(this));
    }
  }
  
  public Context c()
  {
    return this.a;
  }
  
  public BaseJsEngine d()
  {
    if (this.c == null) {
      this.c = JsEngineProvider.a();
    }
    return this.c;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return (this.c != null) && (this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.JsEngineLoader
 * JD-Core Version:    0.7.0.1
 */