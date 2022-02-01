package com.tencent.biz.viewplugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.mobileqq.pluginsdk.DebugHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewPluginContext
  extends ContextThemeWrapper
{
  private int jdField_a_of_type_Int;
  private AssetManager jdField_a_of_type_AndroidContentResAssetManager = null;
  private Resources.Theme jdField_a_of_type_AndroidContentResResources$Theme = null;
  private Resources jdField_a_of_type_AndroidContentResResources = null;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public ViewPluginContext(Context paramContext, int paramInt, ViewPluginContext paramViewPluginContext)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangClassLoader = paramViewPluginContext.jdField_a_of_type_JavaLangClassLoader;
    this.jdField_a_of_type_AndroidContentResAssetManager = paramViewPluginContext.jdField_a_of_type_AndroidContentResAssetManager;
    this.jdField_a_of_type_AndroidContentResResources$Theme = paramViewPluginContext.jdField_a_of_type_AndroidContentResResources$Theme;
    this.jdField_a_of_type_AndroidContentResResources = paramViewPluginContext.jdField_a_of_type_AndroidContentResResources;
    this.jdField_a_of_type_Int = paramViewPluginContext.jdField_a_of_type_Int;
  }
  
  public ViewPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null, true);
  }
  
  public ViewPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
    if (paramResources != null)
    {
      this.jdField_a_of_type_AndroidContentResAssetManager = paramResources.getAssets();
      this.jdField_a_of_type_AndroidContentResResources = paramResources;
    }
    else
    {
      paramResources = a(paramContext);
      if ((!TextUtils.isEmpty(paramResources)) && (paramBoolean))
      {
        paramClassLoader = new String[2];
        paramClassLoader[0] = paramResources;
        paramClassLoader[1] = paramString;
      }
      else
      {
        paramClassLoader = new String[1];
        paramClassLoader[0] = paramString;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq path:");
        localStringBuilder.append(paramResources);
        localStringBuilder.append(", apk path:");
        localStringBuilder.append(paramString);
        QLog.d("ViewPluginContext", 2, localStringBuilder.toString());
      }
      if (Build.VERSION.SDK_INT >= 27)
      {
        paramContext = paramContext.getPackageManager();
        paramClassLoader = paramContext.getPackageArchiveInfo(paramString, 143);
        if (paramClassLoader.applicationInfo != null)
        {
          paramClassLoader.applicationInfo.sourceDir = paramString;
          paramClassLoader.applicationInfo.publicSourceDir = paramString;
          if (TextUtils.isEmpty(paramClassLoader.applicationInfo.processName)) {
            paramClassLoader.applicationInfo.processName = "com.tencent.mobileqq";
          }
          try
          {
            this.jdField_a_of_type_AndroidContentResResources = paramContext.getResourcesForApplication(paramClassLoader.applicationInfo);
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            QLog.e("ViewPluginContext arendgx", 1, paramContext, new Object[0]);
          }
          paramContext = this.jdField_a_of_type_AndroidContentResResources;
          if (paramContext != null) {
            this.jdField_a_of_type_AndroidContentResAssetManager = paramContext.getAssets();
          }
        }
        else
        {
          QLog.e("ViewPluginContext arendgx", 1, "error : mPackageInfo.applicationInfo == null");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidContentResAssetManager = a(paramClassLoader);
        this.jdField_a_of_type_AndroidContentResResources = a(paramContext, this.jdField_a_of_type_AndroidContentResAssetManager);
      }
    }
    paramContext = this.jdField_a_of_type_AndroidContentResResources;
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentResResources$Theme = a(paramContext);
    }
  }
  
  private int a(String paramString)
  {
    int j = -1;
    int i = j;
    int k;
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = j;
      k = paramString.lastIndexOf(".");
      i = j;
      String str1 = paramString.substring(k + 1, paramString.length());
      i = j;
      paramString = paramString.substring(0, k);
      i = j;
      Object localObject = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append(str2);
      i = j;
      localStringBuilder.append("$");
      i = j;
      localStringBuilder.append((String)localObject);
      i = j;
      str2 = localStringBuilder.toString();
      i = j;
      j = Class.forName(str2).getDeclaredField(str1).getInt(null);
      i = j;
      k = j;
      if (DebugHelper.sDebug)
      {
        i = j;
        localObject = new StringBuilder();
        i = j;
        ((StringBuilder)localObject).append("getInnderR rStrnig:");
        i = j;
        ((StringBuilder)localObject).append(paramString);
        i = j;
        DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
        i = j;
        paramString = new StringBuilder();
        i = j;
        paramString.append("getInnderR className:");
        i = j;
        paramString.append(str2);
        i = j;
        DebugHelper.log("plugin_tag", paramString.toString());
        i = j;
        paramString = new StringBuilder();
        i = j;
        paramString.append("getInnderR fieldName:");
        i = j;
        paramString.append(str1);
        i = j;
        DebugHelper.log("plugin_tag", paramString.toString());
        return j;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      k = i;
    }
    return k;
  }
  
  private AssetManager a(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = (AssetManager)AssetManager.class.newInstance();
      try
      {
        AssetManager.class.getDeclaredMethod("addAssetPaths", new Class[] { [Ljava.lang.String.class }).invoke(localObject, new Object[] { paramArrayOfString });
        return localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramArrayOfString = (String[])localObject;
        localObject = localThrowable2;
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      paramArrayOfString = null;
    }
    return paramArrayOfString;
  }
  
  private Resources.Theme a(Resources paramResources)
  {
    paramResources = paramResources.newTheme();
    this.jdField_a_of_type_Int = a("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.jdField_a_of_type_Int, true);
    return paramResources;
  }
  
  private Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  public static String a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext, 8192);
      if (paramContext != null)
      {
        paramContext = paramContext.sourceDir;
        return paramContext;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public AssetManager getAssets()
  {
    return this.jdField_a_of_type_AndroidContentResAssetManager;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader = this.jdField_a_of_type_JavaLangClassLoader;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.jdField_a_of_type_AndroidContentResResources$Theme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginContext
 * JD-Core Version:    0.7.0.1
 */