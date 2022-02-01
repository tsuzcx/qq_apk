package com.tencent.comic;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.config.QQComicConfBean.WebBundleConfig;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.webbundle.WebBundleRuntime;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.webbundle.sdk.WebBundleConfig;
import com.tencent.webbundle.sdk.WebBundleManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class VipComicHelper
{
  private static boolean a = false;
  private static boolean b = true;
  
  public static String a()
  {
    String str = AppHelper.b().getAccount();
    Object localObject = AppHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicGlobalConfig_");
    localStringBuilder.append(str);
    str = ((Application)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("defaultComicTab", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ComicGlobalConfig] get default tab is ");
      ((StringBuilder)localObject).append(str);
      QLog.d("ComicHelper", 2, ((StringBuilder)localObject).toString());
    }
    return str;
  }
  
  public static AppRuntime a(MobileQQ paramMobileQQ, String paramString)
  {
    if (paramMobileQQ != null)
    {
      if (paramString == null) {
        return null;
      }
      if ((paramMobileQQ.peekAppRuntime().getRunningModuleSize() > 0) && (VipComicDataHelper.n.get() != 2)) {
        VipComicDataHelper.n.set(3);
      }
    }
    try
    {
      try
      {
        localClass = Class.forName("com.qqcomic.app.VipComicPluginRuntime");
      }
      catch (Exception paramMobileQQ) {}catch (NoSuchMethodException paramMobileQQ) {}catch (InvocationTargetException paramMobileQQ) {}catch (InstantiationException paramMobileQQ) {}catch (IllegalAccessException paramMobileQQ) {}catch (IllegalArgumentException paramMobileQQ) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      label70:
      ClassLoader localClassLoader;
      break label70;
    }
    try
    {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramMobileQQ, "comic_plugin.apk");
      localClass = localClassLoader.loadClass("com.qqcomic.app.VipComicPluginRuntime");
      BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      if (localClass == null)
      {
        if (!QLog.isColorLevel()) {
          break label208;
        }
        QLog.d("ComicHelper", 2, "createCOMICRuntime: load class failed");
        return null;
      }
      paramMobileQQ = localClass.getDeclaredConstructor(new Class[] { MobileQQ.class, String.class }).newInstance(new Object[] { paramMobileQQ, paramString });
      if ((paramMobileQQ == null) || (!(paramMobileQQ instanceof AppRuntime))) {
        break label202;
      }
      paramMobileQQ = (AppRuntime)paramMobileQQ;
      return paramMobileQQ;
    }
    catch (ClassNotFoundException paramMobileQQ)
    {
      paramMobileQQ.printStackTrace();
    }
    paramMobileQQ.printStackTrace();
    return null;
    paramMobileQQ.printStackTrace();
    return null;
    paramMobileQQ.printStackTrace();
    return null;
    paramMobileQQ.printStackTrace();
    return null;
    paramMobileQQ.printStackTrace();
    return null;
    paramMobileQQ.printStackTrace();
    return null;
    label202:
    return null;
    label208:
    return null;
  }
  
  public static void a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    b = bool;
    if (!b) {
      ThreadManager.getUIHandler().post(new VipComicHelper.2());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handle setWebBundleOption enable = ");
    localStringBuilder.append(b);
    QLog.d("WebBundle.Comic", 2, localStringBuilder.toString());
  }
  
  public static void a(int paramInt, AppRuntime paramAppRuntime)
  {
    if (!NetworkUtil.isNetworkAvailable(paramAppRuntime.getApplication()))
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("no network. skip update offline pkg. entry = ");
        paramAppRuntime.append(paramInt);
        QLog.d("ComicHelper", 2, paramAppRuntime.toString());
      }
      return;
    }
    ThreadManager.post(new VipComicHelper.1(new WeakReference(paramAppRuntime), paramInt), 5, null, false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramActivity != null)
    {
      if (paramIntent == null) {
        return;
      }
      a(paramIntent);
      try
      {
        paramActivity.startActivityForResult(paramIntent, paramInt);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("ComicHelper", 2, "openQQBrowserActivityForComic", paramActivity);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("WebBundle.Comic", 2, "init webbundle failed because context is null.");
      return;
    }
    if (!b)
    {
      QLog.w("WebBundle.Comic", 2, "init webbundle failed because jsApi forbid.");
      return;
    }
    Object localObject = (QQComicConfBean)QConfigManager.b().b(534);
    if ((localObject != null) && (((QQComicConfBean)localObject).a.a()))
    {
      if (WebBundleManager.getInstance("comic").isInit()) {
        return;
      }
      SharedPreferences localSharedPreferences = AppHelper.a().getSharedPreferences("webbundle", 4);
      if (!localSharedPreferences.getBoolean("webbundle_enable", true))
      {
        QLog.w("WebBundle.Comic", 2, "init webbundle failed because local config forbid.");
        return;
      }
      paramContext = new WebBundleRuntime(paramContext);
      localObject = new WebBundleConfig().setCarrierActivityClass(QQBrowserActivity.class).setPreloadUrl(((QQComicConfBean)localObject).a.b).setLogListener(new VipComicHelper.4()).setOptionListener(new VipComicHelper.3(localSharedPreferences));
      WebBundleManager.getInstance("comic").init(paramContext, (WebBundleConfig)localObject);
      WebBundleManager.getInstance("comic").triggerPreload(1500L);
      return;
    }
    QLog.w("WebBundle.Comic", 2, "init webbundle failed because config forbid.");
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
    paramIntent.putExtra("fragmentStyle", 1);
    paramIntent.putExtra("tabBarStyle", 1);
    paramIntent.putExtra("titleBarStyle", 1);
    paramIntent.putExtra("hide_operation_bar", true);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!paramIntent.hasExtra("big_brother_source_key")) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
    }
    if ((paramIntent.hasExtra("url")) && (!TextUtils.isEmpty(VipComicDataHelper.k)))
    {
      String str = paramIntent.getStringExtra("url");
      IQQComicUtil localIQQComicUtil = (IQQComicUtil)QRoute.api(IQQComicUtil.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mod=");
      localStringBuilder.append(VipComicDataHelper.k);
      paramIntent.putExtra("url", localIQQComicUtil.addParamToUrl(str, localStringBuilder.toString()));
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = AppHelper.b().getAccount();
    Application localApplication = AppHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicGlobalConfig_");
    localStringBuilder.append((String)localObject);
    localObject = localApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    if (!TextUtils.isEmpty(paramString))
    {
      ((SharedPreferences)localObject).edit().putString("sp_key_danmu_answer_url", paramString).commit();
      return;
    }
    ((SharedPreferences)localObject).edit().remove("sp_key_danmu_answer_url").commit();
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if (a) {
        return;
      }
      MagnifierSDK.a(paramAppRuntime.getLongAccountUin());
      try
      {
        QLog.i("ComicHelper", 4, "MagnifierSDK is enable, current process is QQComic");
        ReporterMachine.b();
      }
      catch (Exception paramAppRuntime)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Magnifier startMachine error]");
        localStringBuilder.append(paramAppRuntime);
        QLog.e("ComicHelper", 4, localStringBuilder.toString());
      }
      UnifiedMonitor.a().c();
      a = true;
    }
  }
  
  public static boolean a(String paramString, Intent paramIntent)
  {
    int i = 100;
    Object localObject;
    if (paramString != null)
    {
      localObject = Uri.parse(paramString);
      if ((localObject != null) && (((Uri)localObject).isHierarchical()))
      {
        bool = "1".equals(((Uri)localObject).getQueryParameter("init_player"));
        paramString = ((Uri)localObject).getQueryParameter("id");
        localObject = ((Uri)localObject).getQueryParameter("type");
      }
    }
    try
    {
      int j = Integer.parseInt((String)localObject);
      i = j;
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    break label80;
    paramString = null;
    boolean bool = false;
    label80:
    if ((!TextUtils.isEmpty(paramString)) && (bool))
    {
      paramIntent.putExtra("key_comic_id", paramString);
      paramIntent.putExtra("key_type", i);
      paramIntent.putExtra("key_is_fullscreen", false);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      return true;
    }
    return false;
  }
  
  public static void b(String paramString)
  {
    Object localObject1 = AppHelper.b().getAccount();
    Object localObject2 = AppHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicGlobalConfig_");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((Application)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject2 = ((SharedPreferences)localObject1).getString("defaultComicTab", null);
    if (TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((SharedPreferences)localObject1).edit().remove("defaultComicTab").apply();
        if (QLog.isColorLevel()) {
          QLog.d("ComicHelper", 2, "[ComicGlobalConfig] erase default tab");
        }
      }
    }
    else if (!paramString.equals(localObject2))
    {
      ((SharedPreferences)localObject1).edit().putString("defaultComicTab", paramString).apply();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[ComicGlobalConfig] update default tab to ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ComicHelper", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper
 * JD-Core Version:    0.7.0.1
 */