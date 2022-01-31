package com.tencent.mobileqq.ark;

import abal;
import abam;
import aban;
import abaq;
import abar;
import abas;
import abat;
import abau;
import abav;
import abaw;
import abax;
import abay;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.manager.Manager;

public class ArkAppCenter
  implements Manager
{
  private static double jdField_a_of_type_Double;
  private static String jdField_a_of_type_JavaLangString;
  public static Map a;
  public static volatile boolean a;
  private static double jdField_b_of_type_Double;
  private static Map jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public static volatile boolean b;
  public static volatile boolean c;
  static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private final int jdField_a_of_type_Int = 0;
  private abay jdField_a_of_type_Abay = new abay(null);
  private ArkActionAppMgr jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr;
  private ArkAiAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter;
  private ArkAppCGI jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  private ArkAppEntityManagerFactory jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory;
  private ArkAppSSO jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  private ArkLocalAppMgr jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new abar(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int = 1;
  private final int c;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    f = BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", f);
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((a(str1).booleanValue()) || (a(str2).booleanValue())) {
      jdField_c_of_type_Boolean = true;
    }
  }
  
  public ArkAppCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI = new ArkAppCGI(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO = new ArkAppSSO(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr = new ArkLocalAppMgr(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr = new ArkActionAppMgr(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppEntityManagerFactory = new ArkAppEntityManagerFactory(paramQQAppInterface.getCurrentAccountUin());
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PROXY_CHANGE");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_Abay, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter = new ArkAiAppCenter(this);
  }
  
  public static int a(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localApplicationInformation != null) {
      return localApplicationInformation.jdField_a_of_type_Int;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public static ArkDispatchTask a()
  {
    a(false);
    return ArkDispatchTask.getInstance();
  }
  
  protected static ArkAppCenter.ApplicationInformation a(String paramString)
  {
    a(true);
    if (!jdField_b_of_type_Boolean) {
      return null;
    }
    a().send(new abal(paramString));
    return (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private static Boolean a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localApplicationInformation != null) && (!TextUtils.isEmpty(localApplicationInformation.jdField_a_of_type_JavaLangString))) {
      return localApplicationInformation.jdField_a_of_type_JavaLangString;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static Map a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    paramString1 = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(120)).a().a(paramString1, paramString2);
    if (paramString1 != null)
    {
      localHashMap.put("desc", b(paramString1));
      localHashMap.put("version", d(paramString1));
      return localHashMap;
    }
    return null;
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
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    abax localabax;
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      localabax = (abax)jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localabax == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 1, String.format("releaseAppIcon.notfound!! path: %s", new Object[] { paramString }));
        }
        return;
      }
    }
    int i = localabax.jdField_a_of_type_Int - 1;
    localabax.jdField_a_of_type_Int = i;
    if (i != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 1, String.format("releaseAppIcon.release!! path: %s", new Object[] { paramString }));
    }
    jdField_b_of_type_JavaUtilMap.remove(paramString);
    a().post(new abaq(localabax));
  }
  
  public static void a(String paramString, ArkAppCenter.OnGetAppIcon paramOnGetAppIcon)
  {
    if ((paramString == null) || (paramOnGetAppIcon == null)) {
      return;
    }
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      abax localabax = (abax)jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localabax != null) {
        localabax.jdField_a_of_type_Int += 1;
      }
      if (localabax != null)
      {
        paramOnGetAppIcon.a(paramString, localabax.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
      }
    }
    a().post(new aban(paramString, paramOnGetAppIcon));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    ArkEnvironmentManager localArkEnvironmentManager = ArkEnvironmentManager.getInstance();
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        localArkEnvironmentManager.setThreadCreator(new abat());
        localArkEnvironmentManager.setLogCallback(new abau());
        localArkEnvironmentManager.setLibraryLoader(new abav());
        localArkEnvironmentManager.setDebugFlag(false);
        localArkEnvironmentManager.setProfilingLogFlag(false);
        jdField_a_of_type_Boolean = true;
      }
      if ((paramBoolean) && (!jdField_b_of_type_Boolean)) {
        localArkEnvironmentManager.loadLibrary();
      }
      if ((paramBoolean) && (jdField_b_of_type_Boolean)) {
        ThreadManager.post(new abaw(), 5, null, true);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return d;
  }
  
  public static double[] a()
  {
    if (!g) {
      return null;
    }
    return new double[] { jdField_a_of_type_Double, jdField_b_of_type_Double };
  }
  
  public static String b()
  {
    return ArkAppEnvConfig.a().a();
  }
  
  public static String b(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localApplicationInformation != null) && (!TextUtils.isEmpty(localApplicationInformation.b))) {
      return localApplicationInformation.b;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return "";
  }
  
  public static void b()
  {
    b("ArkApp", "cleanArkAppCache");
    c();
  }
  
  public static void b(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        f = "1".equalsIgnoreCase(paramString);
        BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", f).apply();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        b("ArkApp", "updatePANShowSwitch, value = null");
      }
      if (paramString == null) {
        continue;
      }
      b("ArkApp", "updatePANShowSwitch, value = " + paramString);
      return;
      f = false;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static boolean b()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static String c()
  {
    return ArkAppEnvConfig.a().b();
  }
  
  public static String c(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localApplicationInformation != null) && (!TextUtils.isEmpty(localApplicationInformation.b))) {
      return localApplicationInformation.e;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.e;
    }
    return "";
  }
  
  public static void c()
  {
    File[] arrayOfFile = new File(c()).listFiles(new abas());
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public static boolean c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ArkApp", 4, "isPANonShow,  bRet = " + f);
    }
    return (f) || (!b());
  }
  
  public static String d()
  {
    return ArkAppEnvConfig.a().c();
  }
  
  public static String d(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localApplicationInformation != null) && (!TextUtils.isEmpty(localApplicationInformation.c))) {
      return localApplicationInformation.c;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.c;
    }
    return "0.0.0.1";
  }
  
  public static void d()
  {
    new File(b() + "/storage.db").delete();
  }
  
  public static boolean d()
  {
    boolean bool = true;
    File localFile = new File(SOPreLoader.a(), "libjsc.so");
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
    {
      QLog.d("ArkApp", 1, "load lib libjsc.so NOT exist.");
      bool = false;
    }
    return bool;
  }
  
  public static String e()
  {
    return ArkAppEnvConfig.a().d();
  }
  
  public static String e(String paramString)
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = (ArkAppCenter.ApplicationInformation)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localApplicationInformation != null) && (!TextUtils.isEmpty(localApplicationInformation.d))) {
      return localApplicationInformation.d;
    }
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return "";
  }
  
  public static void e()
  {
    if ((jdField_b_of_type_Boolean) || (!jdField_c_of_type_Boolean)) {
      return;
    }
    ArkDispatchTask.getInstance().send(new abam());
  }
  
  public static String f()
  {
    return ArkAppEnvConfig.a().e();
  }
  
  public static String g()
  {
    return String.format(Locale.CHINA, "%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
  }
  
  private static boolean g()
  {
    String str = SOPreLoader.a();
    if (str == null)
    {
      QLog.d("ArkApp", 1, "InitJSCLibPath folder path is null.");
      return false;
    }
    ark.arkSetLibraryPath(str);
    return true;
  }
  
  public static String h()
  {
    return String.format(Locale.CHINA, "%d", new Object[] { Integer.valueOf(ark.arkGetMinPlatformVersion()) });
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ArkActionAppMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr;
  }
  
  public ArkAiAppCenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter;
  }
  
  public ArkAppCGI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI;
  }
  
  public ArkAppSSO a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppSSO;
  }
  
  public ArkLocalAppMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter != null) {}
  }
  
  public boolean a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI.b(paramString, paramObject, paramArkAppCGICallback);
    return true;
  }
  
  public QQAppInterface b()
  {
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.a();
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_Abay);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */