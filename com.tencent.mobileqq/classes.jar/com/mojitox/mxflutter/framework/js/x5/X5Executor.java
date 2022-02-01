package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.JobExecutor;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsValue;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class X5Executor
  extends BaseJsExecutor<JsContext, JsValue>
{
  private static final Pattern a = Pattern.compile("\\\\\"");
  private static final Pattern b = Pattern.compile("(require\\(\"(.*?)\"\\))");
  private volatile boolean c;
  private JsContext d;
  @Nullable
  private IMxJsFlutterApp e;
  private final List<JsTask> f = new ArrayList(5);
  private JsVirtualMachine g;
  private IX5Interface h;
  
  public X5Executor()
  {
    g();
  }
  
  private static Object a(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      localObject = paramObject;
      if (str.contains("\\\""))
      {
        localObject = paramObject;
        if (str.contains("flutterCallNavigatorPushWithName")) {
          localObject = a.matcher((CharSequence)paramObject).replaceAll("\\\\\\\\\"");
        }
      }
    }
    return localObject;
  }
  
  private Object a(String paramString)
  {
    Object localObject2 = b.matcher(paramString);
    Object localObject1 = new LinkedList();
    while (((Matcher)localObject2).find())
    {
      ((Collection)localObject1).add(((Matcher)localObject2).group(2));
      paramString = paramString.replace(((Matcher)localObject2).group(), "");
    }
    paramString = this.d.evaluateScript(paramString);
    if (!((Collection)localObject1).isEmpty())
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        f().a((String)localObject2);
      }
    }
    return paramString;
  }
  
  @Nullable
  private String d(@Nullable String paramString, @Nullable Object paramObject)
  {
    Object localObject = X5EvaluateUtil.a(paramObject);
    if (TextUtils.equals(paramString, "nativeCall"))
    {
      paramString = this.e;
      if (paramString != null)
      {
        paramString.a(localObject);
      }
      else
      {
        paramString = a(localObject);
        if ((f().a()) && (TextUtils.equals(X5EvaluateUtil.b(paramObject), "flutterCallNavigatorPushWithName"))) {
          f().a(X5EvaluateUtil.c(paramObject));
        }
        return String.format("%s.%s('%s')", new Object[] { "MXJSAPI", "invokeNativeCall", paramString });
      }
    }
    return null;
  }
  
  private void i()
  {
    try
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((JsTask)localIterator.next()).run();
      }
      this.f.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void j()
  {
    if (!QbSdk.isTbsCoreInited())
    {
      MxLog.a("X5Executor", "#initX5Actual: start init isTbsCore init");
      WebAccelerator.initTbsEnvironment(JsEngineLoader.a().c(), 2);
    }
    UiThread.c(new X5Executor.1(this));
  }
  
  protected Object a(@NonNull JsValue paramJsValue, Object paramObject, boolean paramBoolean)
  {
    if (paramJsValue.isFunction())
    {
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "";
      }
      paramJsValue.call(new Object[] { localObject });
    }
    return null;
  }
  
  protected Object a(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramObject == null) {
        paramString = String.format("javascript:%s()", new Object[] { paramString });
      } else {
        paramString = String.format("javascript:%s(%s)", new Object[] { paramString, paramObject });
      }
      paramObject = new StringBuilder();
      paramObject.append("invokeJsFunctionInner:");
      paramObject.append(paramString);
      MxLog.a("X5Executor", paramObject.toString());
      return this.d.evaluateScript(paramString);
    }
    return null;
  }
  
  protected Object a(String paramString1, String paramString2)
  {
    return this.d.evaluateScript(paramString1);
  }
  
  public void a(JsTask paramJsTask)
  {
    if (this.c)
    {
      super.a(paramJsTask);
      return;
    }
    this.f.add(paramJsTask);
  }
  
  public void a(boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback)
  {
    a(new X5Executor.3(this, paramBoolean, paramExecuteScriptCallback).a("close#"));
  }
  
  public boolean a(@NonNull JsObjectType paramJsObjectType)
  {
    return this.d != null;
  }
  
  protected Object b(@NonNull JsObjectType paramJsObjectType, String paramString, Object paramObject)
  {
    int i = X5Executor.4.a[paramJsObjectType.ordinal()];
    String str = "";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          paramJsObjectType = null;
          break label160;
        }
        paramJsObjectType = d(paramString, paramObject);
        break label160;
      }
      paramJsObjectType = new StringBuilder();
      paramJsObjectType.append("MXJSAPI.");
      paramJsObjectType.append(paramString);
      if (paramObject == null)
      {
        paramString = str;
        break label149;
      }
      paramString = new StringBuilder();
    }
    else
    {
      paramJsObjectType = new StringBuilder();
      paramJsObjectType.append(paramString);
      if (paramObject == null)
      {
        paramString = str;
        break label149;
      }
      paramString = new StringBuilder();
    }
    paramString.append("('");
    paramString.append(paramObject);
    paramString.append("')");
    paramString = paramString.toString();
    label149:
    paramJsObjectType.append(paramString);
    paramJsObjectType = paramJsObjectType.toString();
    label160:
    if (TextUtils.isEmpty(paramJsObjectType)) {
      return null;
    }
    paramString = new StringBuilder();
    paramString.append("invokeJsValueInner:");
    paramString.append(paramJsObjectType);
    MxLog.a("X5Executor", paramString.toString());
    return this.d.evaluateScript(paramJsObjectType);
  }
  
  protected Object b(String paramString1, String paramString2)
  {
    if (("/main.js".equals(paramString2)) && (paramString1.contains("require"))) {
      return a(paramString1);
    }
    return this.d.evaluateScript(paramString1);
  }
  
  @NonNull
  public String b()
  {
    return "X5Executor";
  }
  
  protected void b(@NonNull JsObjectType paramJsObjectType, String paramString, InvokeJSValueCallback paramInvokeJSValueCallback, Object... paramVarArgs)
  {
    IX5Interface localIX5Interface = f();
    if ((localIX5Interface instanceof X5CallbackInterface)) {
      ((X5CallbackInterface)localIX5Interface).a(paramJsObjectType, paramString, paramInvokeJSValueCallback, paramVarArgs);
    }
  }
  
  public void b(JsTask paramJsTask)
  {
    try
    {
      if (this.c) {
        paramJsTask.run();
      } else {
        this.f.add(paramJsTask);
      }
      return;
    }
    finally {}
  }
  
  protected void c(String paramString, @Nullable Object paramObject)
  {
    if (paramObject == null)
    {
      paramObject = this.d;
      paramString = String.format("%s.%s = {}", new Object[] { "MXJSAPI", paramString });
    }
    for (;;)
    {
      paramObject.evaluateScript(paramString);
      return;
      if ((paramObject instanceof Map)) {
        try
        {
          paramString = String.format("globalThis.%s.%s = %s", new Object[] { "MXJSAPI", paramString, new JSONObject((Map)paramObject) });
          this.d.evaluateScript(paramString);
          return;
        }
        catch (ClassCastException paramString)
        {
          paramObject = new StringBuilder();
          paramObject.append("registerGlobalObjectInner:");
          paramObject.append(paramString.getMessage());
          MxLog.b("X5Executor", paramObject.toString());
          return;
        }
      }
      paramString = String.format("globalThis.%s.%s = %s", new Object[] { "MXJSAPI", paramString, paramObject });
      paramObject = this.d;
    }
  }
  
  public void d() {}
  
  public JsContext e()
  {
    return this.d;
  }
  
  @NonNull
  public IX5Interface f()
  {
    if (this.h == null)
    {
      Object localObject = this.g;
      if ((localObject != null) && (((JsVirtualMachine)localObject).isFallback())) {
        localObject = new X5InterfaceFallback(this);
      } else {
        localObject = new X5Interface(this);
      }
      this.h = ((IX5Interface)localObject);
    }
    return this.h;
  }
  
  void g()
  {
    MxLog.a("X5Executor", "#initX5: begin");
    j();
  }
  
  public void h()
  {
    MxLog.a("X5Executor", "#onViewInitFinished: begin");
    this.g = new JsVirtualMachine(JsEngineLoader.a().c());
    a().a(this.g.isFallback());
    this.d = new JsContext(this.g);
    this.d.setExceptionHandler(new X5Executor.2(this));
    this.c = true;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor
 * JD-Core Version:    0.7.0.1
 */