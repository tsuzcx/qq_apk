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
  SharedPreferences a;
  public ViewPluginContext a;
  public BaseActivity a;
  public ClassLoader a;
  public String a;
  public HashMap<String, Class> a;
  public String b;
  String c = null;
  public String d = null;
  
  public ViewPluginManager(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir());
    paramBaseActivity.append(paramString3);
    this.c = paramBaseActivity.toString();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPreferences(0);
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
    Object localObject = this.jdField_a_of_type_JavaLangClassLoader;
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
          paramString = (View)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext });
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
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" not find view:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ViewPluginManager", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("plugin:");
        paramString.append(this.b);
        paramString.append(" plugin context is null");
        QLog.d("ViewPluginManager", 2, paramString.toString());
      }
      return null;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_plugin_view_version_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    ThreadManager.post(new ViewPluginManager.3(this), 8, null, true);
  }
  
  public void a(AsyncCallBack paramAsyncCallBack, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("?_bid=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadPlugin:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("mBid:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ViewPluginManager", 2, ((StringBuilder)localObject2).toString());
    }
    HtmlOffline.a();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getLongAccountUin() % 10L == 6L)) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.a = bool;
    a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
    long l = System.currentTimeMillis();
    if ((!HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), (String)localObject1, new ViewPluginManager.2(this, l, (Context)localObject2, paramBoolean, paramAsyncCallBack))) && (QLog.isColorLevel()))
    {
      paramAsyncCallBack = new StringBuilder();
      paramAsyncCallBack.append("plugin:");
      paramAsyncCallBack.append(this.b);
      paramAsyncCallBack.append(" transToLocalUrl: return false");
      QLog.i("ViewPluginManager", 2, paramAsyncCallBack.toString());
    }
  }
  
  public void a(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager
 * JD-Core Version:    0.7.0.1
 */