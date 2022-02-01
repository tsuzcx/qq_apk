package com.tencent.mobileqq.app.multilanguage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MultiLanguageEngine
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_MultiLanguageFactory.yml", version=1)
  public static ArrayList<Class<? extends LayoutInflater.Factory2>> a = new ArrayList();
  private static String b = "en.lang";
  private static String c = "en-release.zip";
  private DelegateResources d;
  private QQResourcesImpl e;
  
  static
  {
    a.add(MultiLanguageFactory.class);
  }
  
  public static MultiLanguageEngine a()
  {
    return MultiLanguageEngine.EngineHolder.a();
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    b(paramContext, paramString);
    try
    {
      long l = System.currentTimeMillis();
      AssetManager localAssetManager = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Object localObject = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(localAssetManager, new Object[] { paramString });
      Resources localResources = new Resources(localAssetManager, this.e.b().getDisplayMetrics(), this.e.b().getConfiguration());
      localObject = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (paramContext != null)
      {
        paramContext = paramContext.packageName;
      }
      else
      {
        QLog.d("MultiLanguageEngine", 1, "pkgInfo is null");
        paramContext = (Context)localObject;
      }
      this.e.a(localResources, paramContext);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLangPkg:", localAssetManager.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.d("MultiLanguageEngine", 1, paramContext, new Object[0]);
    }
    return false;
  }
  
  private static String b()
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir(), "/multi_language");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private void b(Context paramContext, String paramString)
  {
    if (!new File(paramString).exists())
    {
      QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLanguage need unzip:", c });
      long l = System.currentTimeMillis();
      paramString = new StringBuilder();
      paramString.append("language");
      paramString.append(File.separator);
      paramString.append(c);
      paramString = paramString.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(c);
      localObject = ((StringBuilder)localObject).toString();
      FileUtils.copyAssetToFile(paramContext, paramString, (String)localObject);
      try
      {
        ZipUtils.unZipFile(new File((String)localObject), b());
        if (QLog.isColorLevel())
        {
          QLog.e("MultiLanguageEngine", 2, new Object[] { "copy and unzip success! cost:", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
          return;
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void e(Context paramContext)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = Class.forName("android.app.ContextImpl");
      Object localObject2 = ((Class)localObject1).getDeclaredField("mResources");
      ((Field)localObject2).setAccessible(true);
      Object localObject3 = ((Field)localObject2).get(paramContext);
      ((Field)localObject2).set(paramContext, this.d);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate ContextImpl resources:", this.d.toString(), " ,old:", localObject3.toString() });
      localObject1 = ((Class)localObject1).getDeclaredField("mPackageInfo");
      ((Field)localObject1).setAccessible(true);
      paramContext = ((Field)localObject1).get(paramContext);
      localObject1 = Class.forName("android.app.LoadedApk").getDeclaredField("mResources");
      ((Field)localObject1).setAccessible(true);
      localObject2 = ((Field)localObject1).get(paramContext);
      ((Field)localObject1).set(paramContext, this.d);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate LoadedApk resources:", this.d.toString(), " ,old:", localObject2.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (LocaleManager.a()) {
      return;
    }
    long l = System.currentTimeMillis();
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramActivity);
    try
    {
      localLayoutInflater.setFactory2((LayoutInflater.Factory2)((Class)a.get(0)).getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { paramActivity }));
      if (QLog.isColorLevel())
      {
        QLog.d("MultiLanguageEngine", 2, new Object[] { "register cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.d("MultiLanguageEngine", 1, "register error:", paramActivity);
    }
  }
  
  public void a(Context paramContext)
  {
    QLog.d("MultiLanguageEngine", 1, new Object[] { "initAndDelegate:", Boolean.valueOf(LocaleManager.a() ^ true), ", context:", paramContext });
    if (paramContext == null) {
      return;
    }
    if (LocaleManager.a()) {
      return;
    }
    this.e = new QQResourcesImpl(paramContext);
    this.d = new DelegateResources(this.e);
    e(paramContext);
  }
  
  public void b(Context paramContext)
  {
    if (LocaleManager.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(b);
      a(paramContext, localStringBuilder.toString());
      return;
    }
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.a(null, null);
    }
  }
  
  public void c(Context paramContext)
  {
    long l = System.currentTimeMillis();
    FileUtils.deleteDirectory(b());
    b(paramContext);
    QLog.d("MultiLanguageEngine", 1, new Object[] { "update lang pkg! cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void d(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(b);
    b(paramContext, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine
 * JD-Core Version:    0.7.0.1
 */