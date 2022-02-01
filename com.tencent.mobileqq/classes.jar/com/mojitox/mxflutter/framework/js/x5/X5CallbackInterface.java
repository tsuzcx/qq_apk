package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.utils.MxLog;
import com.tencent.smtt.sdk.JsContext;
import java.util.Map;

class X5CallbackInterface
{
  @NonNull
  protected final X5Executor a;
  private int b;
  private Map<Integer, InvokeJSValueCallback> c;
  
  public X5CallbackInterface(@NonNull X5Executor paramX5Executor)
  {
    this.a = paramX5Executor;
  }
  
  private int a(InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    try
    {
      if (this.c != null) {
        break label73;
      }
      this.c = new ArrayMap();
    }
    finally {}
    int i = this.b;
    this.b = (i + 1);
    if (this.b >= 2147483647) {
      this.b = 0;
    }
    this.c.put(Integer.valueOf(i), paramInvokeJSValueCallback);
    for (;;)
    {
      return i;
      label73:
      if (paramInvokeJSValueCallback != null) {
        break;
      }
      i = -1;
    }
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("function(msg){MXJSAPI.");
    localStringBuilder.append(paramString);
    localStringBuilder.append('(');
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg);}");
    return localStringBuilder.toString();
  }
  
  private static boolean a(@NonNull JsObjectType paramJsObjectType, InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    if ((paramJsObjectType != JsObjectType.APP_OBJECT) && (paramJsObjectType != JsObjectType.RUNTIME))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jsObjectType is not supported: ");
      localStringBuilder.append(paramJsObjectType);
      paramInvokeJSValueCallback.a(new Error(localStringBuilder.toString()));
      return false;
    }
    return true;
  }
  
  public void a(@NonNull JsObjectType paramJsObjectType, String paramString, InvokeJSValueCallback paramInvokeJSValueCallback, Object... paramVarArgs)
  {
    if (!a(paramJsObjectType, paramInvokeJSValueCallback)) {
      return;
    }
    int j = a(paramInvokeJSValueCallback);
    paramInvokeJSValueCallback = new StringBuilder();
    if (paramJsObjectType == JsObjectType.APP_OBJECT)
    {
      paramInvokeJSValueCallback.append("MXJSAPI");
      paramInvokeJSValueCallback.append('.');
    }
    paramInvokeJSValueCallback.append(paramString);
    paramInvokeJSValueCallback.append('(');
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      int i = 0;
      while (i < k)
      {
        paramJsObjectType = paramVarArgs[i];
        paramInvokeJSValueCallback.append('\'');
        paramInvokeJSValueCallback.append(paramJsObjectType);
        paramInvokeJSValueCallback.append('\'');
        paramInvokeJSValueCallback.append(',');
        i += 1;
      }
    }
    paramInvokeJSValueCallback.append(a("androidCallback1", j));
    paramInvokeJSValueCallback.append(')');
    paramJsObjectType = paramInvokeJSValueCallback.toString();
    paramString = new StringBuilder();
    paramString.append("invokeJsWithJavaCallback1:");
    paramString.append(paramJsObjectType);
    MxLog.a("X5CallbackInterface", paramString.toString());
    this.a.e().evaluateScript(paramJsObjectType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5CallbackInterface
 * JD-Core Version:    0.7.0.1
 */