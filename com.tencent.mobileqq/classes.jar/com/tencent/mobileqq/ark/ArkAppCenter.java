package com.tencent.mobileqq.ark;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkPlatformConfigBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.mobileqq.config.business.ArkManageConfig.ArkPlatformConfig;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.manager.Manager;

public class ArkAppCenter
  implements Manager
{
  private static double jdField_a_of_type_Double;
  private static String jdField_a_of_type_JavaLangString;
  public static volatile boolean a;
  private static double jdField_b_of_type_Double;
  public static volatile boolean b;
  static boolean jdField_c_of_type_Boolean = false;
  private static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g = false;
  private final int jdField_a_of_type_Int = 0;
  private ArkAiAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter;
  private ArkAppCGI jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  private ArkAppCenter.ProxyChangeNotifier jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier = new ArkAppCenter.ProxyChangeNotifier(null);
  private ArkAppEntityManagerFactory jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory;
  private ArkAppPreDownloadMgr jdField_a_of_type_ComTencentMobileqqArkArkAppPreDownloadMgr;
  private ArkAppSSO jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  private ArkMessagePreprocessorMgr jdField_a_of_type_ComTencentMobileqqArkShareArkMessagePreprocessorMgr;
  private ArkAsyncShareMsgManager jdField_a_of_type_ComTencentMobileqqArkShareCoreArkAsyncShareMsgManager;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ArkAppCenter.2(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int = 1;
  private final int jdField_c_of_type_Int = 2;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    d = false;
    e = false;
    f = false;
    jdField_a_of_type_Double = 0.0D;
    jdField_b_of_type_Double = 0.0D;
    e = BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", e);
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  public ArkAppCenter(QQAppInterface paramQQAppInterface)
  {
    g();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI = new ArkAppCGI(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO = new ArkAppSSO(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory = new ArkAppEntityManagerFactory(paramQQAppInterface.getCurrentAccountUin());
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PROXY_CHANGE");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter = new ArkAiAppCenter(this);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppPreDownloadMgr = new ArkAppPreDownloadMgr(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkShareArkMessagePreprocessorMgr = new ArkMessagePreprocessorMgr(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkShareCoreArkAsyncShareMsgManager = new ArkAsyncShareMsgManager(paramQQAppInterface);
  }
  
  public static ArkDispatchTask a()
  {
    b(true);
    return ArkDispatchTask.getInstance();
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      ArkAppContainer.setArkHttpProxy();
      return;
    }
    ArkAppContainer.clearArkHttpProxy();
  }
  
  public static void a(Intent paramIntent)
  {
    a(paramIntent, null);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "biz_src_jc_ark";
      }
      paramIntent.putExtra("big_brother_source_key", str);
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("big_brother_source_key", "biz_src_jc_ark");
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    a().post("logicqueue", paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a().postDelayed("logicqueue", paramRunnable, paramLong);
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        e = "1".equalsIgnoreCase(paramString);
        BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", e).apply();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        c("ArkApp", "updatePANShowSwitch, value = null");
      }
      if (paramString == null) {
        continue;
      }
      c("ArkApp", "updatePANShowSwitch, value = " + paramString);
      return;
      e = false;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean) {}
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    do
    {
      return bool;
      paramString1 = new File(paramString1, paramString2);
    } while ((paramString1 != null) && (paramString1.exists()) && (paramString1.isFile()));
    QLog.d("ArkApp", 1, "load lib " + paramString2 + " NOT exist.");
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b(true);
    return ark.arkNotify(paramString1, paramString2, paramString3, paramString4);
  }
  
  public static double[] a()
  {
    if (!f) {
      return null;
    }
    return new double[] { jdField_a_of_type_Double, jdField_b_of_type_Double };
  }
  
  public static String b()
  {
    return ArkAppEnvConfig.a().b();
  }
  
  public static void b()
  {
    c("ArkApp", "cleanArkAppCache");
    c();
    e();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject1 = ArkEnvironmentManager.getInstance();
    if (!jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        if (!jdField_a_of_type_Boolean)
        {
          ((ArkEnvironmentManager)localObject1).setThreadCreator(new ArkAppCenter.4());
          ((ArkEnvironmentManager)localObject1).setLogCallback(new ArkAppCenter.5());
          ((ArkEnvironmentManager)localObject1).setLibraryLoader(new ArkAppCenter.6());
          ((ArkEnvironmentManager)localObject1).setDebugFlag(false);
          ((ArkEnvironmentManager)localObject1).setProfilingLogFlag(true);
          ((ArkEnvironmentManager)localObject1).setDataReport(new ArkAppCenter.7());
          jdField_a_of_type_Boolean = true;
        }
        if ((paramBoolean) && (!jdField_b_of_type_Boolean))
        {
          boolean bool1 = ArkAiAppCenter.b();
          ((ArkEnvironmentManager)localObject1).setEnableAndroid9EmojiSupport(bool1);
          ((ArkEnvironmentManager)localObject1).loadLibrary();
          if (jdField_b_of_type_Boolean)
          {
            boolean bool2 = ArkAiAppCenter.a();
            ark.SetUseAndroidHTTP(bool2);
            if (BaseApplicationImpl.getContext() != null)
            {
              localObject1 = ArkAppCenterUtil.a;
              ark.arkSetScreenSize(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density, ((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
            }
            boolean bool3 = "true".equals(ArkAiAppCenter.a("ark_engine_multi_thread"));
            localObject1 = ArkEnvironmentManager.getInstance();
            if (bool3) {
              break label247;
            }
            paramBoolean = true;
            ((ArkEnvironmentManager)localObject1).setSingleThreadMode(paramBoolean);
            ArkEnvironmentManager.getInstance().setThreadMode();
            c("ArkApp", String.format("setupArkEnvironment, https=%s, multithreads=%s, supportAndroid9EmojiFeature=%s", new Object[] { Boolean.toString(bool2), Boolean.toString(bool3), Boolean.toString(bool1) }));
          }
        }
        return;
      }
      finally {}
      label247:
      paramBoolean = false;
    }
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ArkApp", 4, "isPANonShow,  bRet = " + e);
    }
    return (e) || (!ArkUtil.isDeviceSupportArkMsg());
  }
  
  public static String c()
  {
    return ArkAppEnvConfig.a().c();
  }
  
  public static void c()
  {
    int i = 0;
    File localFile = new File(ArkEnvironmentManager.getInstance().getCacheDirectory());
    File[] arrayOfFile = localFile.listFiles(new ArkAppCenter.3());
    if (arrayOfFile != null)
    {
      c("ArkApp", String.format(Locale.CHINA, "cleanWebCache, count=%d, path=%s", new Object[] { Integer.valueOf(arrayOfFile.length), localFile.getAbsolutePath() }));
      int j = arrayOfFile.length;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static boolean c()
  {
    String str = JSDebuggerSoLoader.a();
    if (a(str, "libjsc_ark.so"))
    {
      ark.arkSetLibraryPath(str, "libjsc_ark.so");
      if (QLog.isDevelopLevel()) {
        QLog.i("ArkApp", 4, "InitJSCLibPath with debug libjsc_ark.so ");
      }
      return true;
    }
    str = SOPreLoader.b();
    if (str == null)
    {
      QLog.d("ArkApp", 1, "InitJSCLibPath folder path is null.");
      return false;
    }
    ark.arkSetLibraryPath(str, "libjsc.so");
    QLog.i("ArkApp", 4, "InitJSCLibPath with  libjsc.so");
    return true;
  }
  
  public static String d()
  {
    String str = ArkAppEnvConfig.a().e();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static void d()
  {
    new File(ArkEnvironmentManager.getInstance().getStorageDirectory() + "/storage.db").delete();
  }
  
  public static boolean d()
  {
    if (a(JSDebuggerSoLoader.a(), "libjsc_ark.so")) {}
    String str;
    do
    {
      return true;
      str = SOPreLoader.b();
      if (str == null)
      {
        QLog.d("ArkApp", 1, "isJSCLibExist folder path is null.");
        return false;
      }
    } while (a(str, "libjsc.so"));
    return false;
  }
  
  public static void e()
  {
    String str = ArkEnvironmentManager.getInstance().getResDirectory();
    String[] arrayOfString = new File(str).list();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        File localFile = new File(str + "/" + arrayOfString[i]);
        if (localFile.isDirectory())
        {
          File[] arrayOfFile = localFile.listFiles();
          if (arrayOfFile != null)
          {
            c("ArkApp", String.format(Locale.CHINA, "cleanAppRes, count=%d, path=%s", new Object[] { Integer.valueOf(arrayOfFile.length), localFile.getAbsolutePath() }));
            int j = 0;
            while (j < arrayOfFile.length)
            {
              arrayOfFile[j].delete();
              j += 1;
            }
          }
        }
        else
        {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean e()
  {
    return g;
  }
  
  public static void f()
  {
    if ((jdField_b_of_type_Boolean) || (!ArkUtil.sARMv7Compatible)) {}
    do
    {
      return;
      if ((!jdField_b_of_type_Boolean) && (ArkUtil.sARMv7Compatible))
      {
        long l1 = System.currentTimeMillis();
        UpdateArkSo.a(BaseApplicationImpl.getContext(), UpdateArkSo.a());
        jdField_b_of_type_Boolean = UpdateArkSo.b(BaseApplicationImpl.getContext(), "ark");
        long l2 = System.currentTimeMillis();
        QLog.d("ArkApp", 1, "load libark.so for ARMv7!, loaded=" + Boolean.toString(jdField_b_of_type_Boolean) + ", time=" + (l2 - l1));
      }
    } while (d);
    d = true;
    if (jdField_b_of_type_Boolean)
    {
      c();
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
  }
  
  private void g()
  {
    Object localObject = ArkConfProcessor.b(380).a();
    if ((localObject != null) && (((ArkConfBean.ArkPlatformConfigBean)localObject).a() != null))
    {
      QLog.d("ArkApp", 1, "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.loadConfig content = " + ((ArkConfBean.ArkPlatformConfigBean)localObject).a());
      localObject = ((ArkConfBean.ArkPlatformConfigBean)localObject).a();
      ArkAppConfigMgr.getInstance().initGlobalWhiteListAndUrlCheckStatus(((ArkManageConfig.ArkPlatformConfig)localObject).jdField_a_of_type_Boolean, ((ArkManageConfig.ArkPlatformConfig)localObject).jdField_b_of_type_JavaUtilArrayList, ((ArkManageConfig.ArkPlatformConfig)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
    }
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ArkAiAppCenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter;
  }
  
  public ArkAppCGI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  }
  
  public ArkAppPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppPreDownloadMgr;
  }
  
  public ArkAppSSO a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  }
  
  public ArkMessagePreprocessorMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkShareArkMessagePreprocessorMgr;
  }
  
  public ArkAsyncShareMsgManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkShareCoreArkAsyncShareMsgManager;
  }
  
  public void a()
  {
    ArkAppMgr.getInstance().updateInstalledApps();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter.b();
    }
  }
  
  public boolean a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI.a(paramString, paramObject, paramArkAppCGICallback);
    return true;
  }
  
  public QQAppInterface b()
  {
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void onDestroy()
  {
    ArkAppMgr.getInstance().onDestroy();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */