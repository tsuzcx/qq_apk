package com.tencent.biz.viewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ViewPluginManager
{
  public ViewPluginContext a;
  public ClassLoader b;
  public String c;
  public String d;
  public BaseActivity e;
  public HashMap<String, Class> f;
  String g = null;
  SharedPreferences h;
  public String i = null;
  
  public ViewPluginManager(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.c = paramString2;
    this.e = paramBaseActivity;
    this.f = new HashMap();
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append(this.e.getFilesDir());
    paramBaseActivity.append(paramString3);
    this.g = paramBaseActivity.toString();
    this.h = this.e.getPreferences(0);
  }
  
  public static boolean a(View paramView, String paramString)
  {
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        Method localMethod = paramView.getClass().getMethod("setData", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(paramView, new Object[] { paramString });
        return true;
      }
      catch (Exception paramView)
      {
        ThreadManager.post(new ViewPluginManager.1(paramView), 2, null, true);
      }
    }
    return false;
  }
  
  public View a(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null) {}
    try
    {
      localObject = ((ClassLoader)localObject).loadClass(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          paramString = (View)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.a });
          return paramString;
        }
        catch (Exception paramString) {}
        localClassNotFoundException = localClassNotFoundException;
      }
    }
    localObject = null;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("plugin:");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" not find view:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ViewPluginManager", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (this.a == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("plugin:");
        paramString.append(this.d);
        paramString.append(" plugin context is null");
        QLog.d("ViewPluginManager", 2, paramString.toString());
      }
      return null;
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.post(new ViewPluginManager.3(this), 8, null, true);
  }
  
  public void a(AsyncCallBack paramAsyncCallBack, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("?_bid=");
    ((StringBuilder)localObject1).append(this.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadPlugin:");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append("mBid:");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d("ViewPluginManager", 2, ((StringBuilder)localObject2).toString());
    }
    HtmlOffline.b();
    boolean bool;
    if ((this.e.app != null) && (this.e.app.getLongAccountUin() % 10L == 6L)) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.i = bool;
    a();
    Object localObject2 = this.e.getApplicationContext();
    long l = System.currentTimeMillis();
    if ((!HtmlOffline.a(this.e.getApplicationContext(), (String)localObject1, new ViewPluginManager.2(this, l, (Context)localObject2, paramBoolean, paramAsyncCallBack))) && (QLog.isColorLevel()))
    {
      paramAsyncCallBack = new StringBuilder();
      paramAsyncCallBack.append("plugin:");
      paramAsyncCallBack.append(this.d);
      paramAsyncCallBack.append(" transToLocalUrl: return false");
      QLog.i("ViewPluginManager", 2, paramAsyncCallBack.toString());
    }
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      Method localMethod = paramString.getClass().getMethod("destory", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramString, new Object[0]);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_plugin_view_version_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager
 * JD-Core Version:    0.7.0.1
 */