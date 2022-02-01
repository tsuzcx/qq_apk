package com.tencent.mobileqq.ark.core;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkEnvironmentManager.IDataReport;
import com.tencent.ark.ArkEnvironmentManager.ILog;
import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.ark.ArkEnvironmentManager.ThreadCreater;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.ark.config.config.DialogConfig;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ArkEnvironment
{
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  static IArkEnvDelegate c = null;
  static final ArkEnvironmentManager.ILog d = new ArkEnvironment.1();
  private static final Object e = new Object();
  
  public static void a()
  {
    if (!b)
    {
      if (!ArkUtil.sARMv7Compatible) {
        return;
      }
      if ((!b) && (ArkUtil.sARMv7Compatible))
      {
        long l1 = System.currentTimeMillis();
        NativeLibLoader.a(BaseApplication.getContext(), NativeLibLoader.a());
        b = NativeLibLoader.c(BaseApplication.getContext(), "ark");
        long l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load libark.so for ARMv7!, loaded=");
        localStringBuilder.append(b);
        localStringBuilder.append(", time=");
        localStringBuilder.append(l2 - l1);
        QLog.i("ArkApp.Environment", 1, localStringBuilder.toString());
      }
      if (b)
      {
        b();
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
    }
  }
  
  private static void a(ArkEnvironmentManager paramArkEnvironmentManager)
  {
    ArkAIKeyWordConfBean localArkAIKeyWordConfBean = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
    boolean bool1 = localArkAIKeyWordConfBean.c().c;
    paramArkEnvironmentManager.setEnableAndroid9EmojiSupport(bool1);
    paramArkEnvironmentManager.loadLibrary();
    if (b)
    {
      boolean bool2 = localArkAIKeyWordConfBean.c().b;
      ark.SetUseAndroidHTTP(bool2);
      paramArkEnvironmentManager = ((IDisplayConfig)QRoute.api(IDisplayConfig.class)).getDisplayMetrics();
      float f1 = paramArkEnvironmentManager.widthPixels / paramArkEnvironmentManager.density;
      float f2 = paramArkEnvironmentManager.heightPixels / paramArkEnvironmentManager.density;
      ark.arkSetScreenSize(f1, f2);
      boolean bool3 = "true".equals(SharePreferenceUtils.a(BaseApplication.getContext(), "ark_engine_multi_thread"));
      ArkEnvironmentManager.getInstance().setSingleThreadMode(bool3 ^ true);
      ArkEnvironmentManager.getInstance().setThreadMode();
      QLog.i("ArkApp.Environment", 1, String.format("setupArkEnvironment, https=%s, multithreads=%s, supportAndroid9EmojiFeature=%s, screen=%f,%f", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Float.valueOf(f1), Float.valueOf(f2) }));
    }
  }
  
  static void a(boolean paramBoolean)
  {
    ArkEnvironmentManager localArkEnvironmentManager = ArkEnvironmentManager.getInstance();
    if (!a) {
      try
      {
        if (!a)
        {
          b(localArkEnvironmentManager);
          a = true;
        }
      }
      finally {}
    }
    if (!b) {
      synchronized (e)
      {
        if ((!b) && (paramBoolean) && (!b)) {
          a(localArkEnvironmentManager);
        }
        return;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = new File(paramString1, paramString2);
      if ((paramString1.exists()) && (paramString1.isFile())) {
        return true;
      }
      paramString1 = new StringBuilder();
      paramString1.append("load lib ");
      paramString1.append(paramString2);
      paramString1.append(" NOT exist.");
      QLog.d("ArkApp.Environment", 1, paramString1.toString());
    }
    return false;
  }
  
  private static void b(ArkEnvironmentManager paramArkEnvironmentManager)
  {
    paramArkEnvironmentManager.setProfilingLogFlag(true);
    paramArkEnvironmentManager.setThreadCreator(e());
    paramArkEnvironmentManager.setLogCallback(d);
    paramArkEnvironmentManager.setLibraryLoader(f());
    paramArkEnvironmentManager.setDebugFlag(false);
    paramArkEnvironmentManager.setDataReport(g());
  }
  
  public static boolean b()
  {
    if (!b)
    {
      QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: ark library not load");
      return false;
    }
    String str = c();
    if (str == null)
    {
      QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: folder path is null.");
      return false;
    }
    ark.arkSetLibraryPath(str, "libjsc.so");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InitJSCLibPath: folder=");
    localStringBuilder.append(str);
    localStringBuilder.append(", name=");
    localStringBuilder.append("libjsc.so");
    localStringBuilder.append(", exist=");
    localStringBuilder.append(d());
    QLog.i("ArkApp.Environment", 1, localStringBuilder.toString());
    return true;
  }
  
  protected static String c()
  {
    IArkEnvDelegate localIArkEnvDelegate = c;
    if (localIArkEnvDelegate != null) {
      return localIArkEnvDelegate.getLibJSCPath();
    }
    return null;
  }
  
  public static boolean d()
  {
    if (a(JSDebuggerSoLoader.a(), "libjsc_ark.so")) {
      return true;
    }
    String str = c();
    if (str == null)
    {
      QLog.d("ArkApp.Environment", 1, "isJSCLibExist folder path is null.");
      return false;
    }
    return a(str, "libjsc.so");
  }
  
  private static ArkEnvironmentManager.ThreadCreater e()
  {
    return new ArkEnvironment.2();
  }
  
  private static ArkEnvironmentManager.LibraryLoader f()
  {
    return new ArkEnvironment.3();
  }
  
  private static ArkEnvironmentManager.IDataReport g()
  {
    return new ArkEnvironment.4();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment
 * JD-Core Version:    0.7.0.1
 */