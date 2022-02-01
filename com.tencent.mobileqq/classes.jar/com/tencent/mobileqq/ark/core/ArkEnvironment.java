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
  static final ArkEnvironmentManager.ILog jdField_a_of_type_ComTencentArkArkEnvironmentManager$ILog = new ArkEnvironment.1();
  static IArkEnvDelegate jdField_a_of_type_ComTencentMobileqqArkApiIArkEnvDelegate;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqArkApiIArkEnvDelegate = null;
  }
  
  private static ArkEnvironmentManager.IDataReport a()
  {
    return new ArkEnvironment.4();
  }
  
  private static ArkEnvironmentManager.LibraryLoader a()
  {
    return new ArkEnvironment.3();
  }
  
  private static ArkEnvironmentManager.ThreadCreater a()
  {
    return new ArkEnvironment.2();
  }
  
  protected static String a()
  {
    IArkEnvDelegate localIArkEnvDelegate = jdField_a_of_type_ComTencentMobileqqArkApiIArkEnvDelegate;
    if (localIArkEnvDelegate != null) {
      return localIArkEnvDelegate.getLibJSCPath();
    }
    return null;
  }
  
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
        a();
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
    }
  }
  
  private static void a(ArkEnvironmentManager paramArkEnvironmentManager)
  {
    ArkAIKeyWordConfBean localArkAIKeyWordConfBean = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
    boolean bool1 = localArkAIKeyWordConfBean.a().c;
    paramArkEnvironmentManager.setEnableAndroid9EmojiSupport(bool1);
    paramArkEnvironmentManager.loadLibrary();
    if (b)
    {
      boolean bool2 = localArkAIKeyWordConfBean.a().b;
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
    if (!jdField_a_of_type_Boolean) {
      try
      {
        if (!jdField_a_of_type_Boolean)
        {
          b(localArkEnvironmentManager);
          jdField_a_of_type_Boolean = true;
        }
      }
      finally {}
    }
    if (!b) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((!b) && (paramBoolean) && (!b)) {
          a(localArkEnvironmentManager);
        }
        return;
      }
    }
  }
  
  public static boolean a()
  {
    if (!b)
    {
      QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: ark library not load");
      return false;
    }
    String str = JSDebuggerSoLoader.a();
    if (a(str, "libjsc_ark.so"))
    {
      ark.arkSetLibraryPath(str, "libjsc_ark.so");
      QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: debug libjsc_ark.so");
      return true;
    }
    str = a();
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
    localStringBuilder.append(b());
    QLog.i("ArkApp.Environment", 1, localStringBuilder.toString());
    return true;
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
    paramArkEnvironmentManager.setThreadCreator(a());
    paramArkEnvironmentManager.setLogCallback(jdField_a_of_type_ComTencentArkArkEnvironmentManager$ILog);
    paramArkEnvironmentManager.setLibraryLoader(a());
    paramArkEnvironmentManager.setDebugFlag(false);
    paramArkEnvironmentManager.setDataReport(a());
  }
  
  public static boolean b()
  {
    if (a(JSDebuggerSoLoader.a(), "libjsc_ark.so")) {
      return true;
    }
    String str = a();
    if (str == null)
    {
      QLog.d("ArkApp.Environment", 1, "isJSCLibExist folder path is null.");
      return false;
    }
    return a(str, "libjsc.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment
 * JD-Core Version:    0.7.0.1
 */