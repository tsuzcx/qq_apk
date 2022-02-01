package com.mojitox.mxflutter.framework.js;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;

public class JsEngineLoader
{
  private Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private InvokeJSValueCallback jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback;
  private BaseJsEngine jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private volatile boolean c;
  
  public static JsEngineLoader a()
  {
    return JsEngineLoader.SingletonHolder.a();
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public BaseJsEngine a()
  {
    if (this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine == null) {
      this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine = JsEngineProvider.a();
    }
    return this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback = null;
    BaseJsEngine localBaseJsEngine = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine;
    if (localBaseJsEngine != null) {
      localBaseJsEngine.b().a(this.b ^ true, new JsEngineLoader.1(this));
    }
  }
  
  public void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(@NonNull ExecuteScriptCallback paramExecuteScriptCallback)
  {
    this.c = false;
    a().a(paramExecuteScriptCallback);
  }
  
  public void a(@Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    this.jdField_a_of_type_ComMojitoxMxflutterFrameworkCallbackInvokeJSValueCallback = paramInvokeJSValueCallback;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsEngine != null) && (this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.JsEngineLoader
 * JD-Core Version:    0.7.0.1
 */