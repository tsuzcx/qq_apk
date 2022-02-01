package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.JobExecutor;
import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsValue;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class X5Executor
  extends BaseJsExecutor<JsContext, JsValue>
  implements QbSdk.PreInitCallback
{
  @Nullable
  private IMxJsFlutterApp jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IMxJsFlutterApp;
  private IX5Interface jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IX5Interface;
  private JsContext jdField_a_of_type_ComTencentSmttSdkJsContext;
  private JsVirtualMachine jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
  private final ArrayList<JsTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public X5Executor()
  {
    b();
  }
  
  @Nullable
  private String a(@Nullable String paramString, @Nullable Object paramObject)
  {
    Object localObject = X5EvaluateUtil.a(paramObject);
    String str = null;
    if (localObject == null) {
      return null;
    }
    if (TextUtils.equals(paramString, "nativeCall"))
    {
      paramString = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IMxJsFlutterApp;
      if (paramString != null)
      {
        paramString.a(localObject);
        return null;
      }
      if ((a().a()) && (TextUtils.equals(X5EvaluateUtil.a(paramObject), "flutterCallNavigatorPushWithName"))) {
        a().a(X5EvaluateUtil.b(paramObject));
      }
      str = String.format("%s.%s('%s')", new Object[] { "MXJSAPI", "invokeNativeCall", localObject });
    }
    return str;
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      a((JsTask)localIterator.next());
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  @NonNull
  public IX5Interface a()
  {
    if (this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IX5Interface == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
      if ((localObject != null) && (((JsVirtualMachine)localObject).isFallback())) {
        localObject = new X5InterfaceFallback(this);
      } else {
        localObject = new X5Interface(this);
      }
      this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IX5Interface = ((IX5Interface)localObject);
    }
    return this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5IX5Interface;
  }
  
  public JsContext a()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkJsContext;
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
        paramString = String.format("javascript:%s(%s)", new Object[] { paramString, paramObject.toString() });
      }
      paramObject = new StringBuilder();
      paramObject.append("invokeJsFunctionInner:");
      paramObject.append(paramString);
      MxLog.b("X5Executor", paramObject.toString());
      return a().evaluateScript(paramString);
    }
    return null;
  }
  
  protected Object a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentSmttSdkJsContext.evaluateScript(paramString1);
  }
  
  public void a() {}
  
  public void a(JsTask paramJsTask)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.a(paramJsTask);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramJsTask);
  }
  
  public void a(boolean paramBoolean, ExecuteScriptCallback paramExecuteScriptCallback)
  {
    a(new X5Executor.3(this, paramBoolean, paramExecuteScriptCallback).a("close#"));
  }
  
  public boolean a(@NonNull JsObjectType paramJsObjectType)
  {
    return this.jdField_a_of_type_ComTencentSmttSdkJsContext != null;
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
          break label157;
        }
        paramJsObjectType = a(paramString, paramObject);
        break label157;
      }
      paramJsObjectType = new StringBuilder();
      paramJsObjectType.append("MXJSAPI.");
      paramJsObjectType.append(paramString);
      if (paramObject == null)
      {
        paramString = str;
        break label146;
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
        break label146;
      }
      paramString = new StringBuilder();
    }
    paramString.append("('");
    paramString.append(paramObject);
    paramString.append("')");
    paramString = paramString.toString();
    label146:
    paramJsObjectType.append(paramString);
    paramJsObjectType = paramJsObjectType.toString();
    label157:
    if (TextUtils.isEmpty(paramJsObjectType)) {
      return null;
    }
    paramString = new StringBuilder();
    paramString.append("invokeJsValueInner:");
    paramString.append(paramJsObjectType);
    MxLog.b("X5Executor", paramString.toString());
    return a().evaluateScript(paramJsObjectType);
  }
  
  protected Object b(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentSmttSdkJsContext.evaluateScript(paramString1);
  }
  
  void b()
  {
    a().execute(new X5Executor.1(this).a("initRuntime#"));
  }
  
  protected void b(String paramString, @Nullable Object paramObject)
  {
    if (paramObject == null)
    {
      paramObject = this.jdField_a_of_type_ComTencentSmttSdkJsContext;
      paramString = String.format("%s.%s = {}", new Object[] { "MXJSAPI", paramString });
    }
    for (;;)
    {
      paramObject.evaluateScript(paramString);
      return;
      if ((paramObject instanceof Map)) {
        try
        {
          paramString = String.format("globalThis.%s.%s = %s", new Object[] { "MXJSAPI", paramString, new JSONObject((Map)paramObject).toString() });
          this.jdField_a_of_type_ComTencentSmttSdkJsContext.evaluateScript(paramString);
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
      paramString = String.format("globalThis.%s.%s = %s", new Object[] { "MXJSAPI", paramString, paramObject.toString() });
      paramObject = this.jdField_a_of_type_ComTencentSmttSdkJsContext;
    }
  }
  
  public void onCoreInitFinished()
  {
    MxLog.b("X5Executor", "onViewInitFinished onCoreInitFinished:");
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewInitFinished:");
    localStringBuilder.append(paramBoolean);
    MxLog.b("X5Executor", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine = new JsVirtualMachine(JsEngineLoader.a().a());
    a().a(this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine.isFallback());
    this.jdField_a_of_type_ComTencentSmttSdkJsContext = new JsContext(this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine);
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.setExceptionHandler(new X5Executor.2(this));
    this.jdField_a_of_type_Boolean = true;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor
 * JD-Core Version:    0.7.0.1
 */