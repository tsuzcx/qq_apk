package com.tencent.mobileqq.app;

import ahbf;
import alpb;
import alpc;
import alpd;
import amqu;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import atfm;
import athj;
import auxd;
import awgg;
import azri;
import baue;
import bavd;
import bazo;
import bcod;
import bczz;
import bdgk;
import bdnm;
import bdtz;
import beag;
import bejq;
import bioj;
import bjas;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebCoreService;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.IToolProcEventListener;
import mqq.app.MSFServlet;
import mqq.app.TicketManagerImpl;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import nbv;
import ncl;
import ncm;
import ndn;
import nef;
import nup;
import oxd;

public class BrowserAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static final AtomicBoolean a;
  public static final AtomicBoolean b;
  public static final AtomicBoolean c;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  amqu jdField_a_of_type_Amqu = new amqu(this);
  public Intent a;
  protected auxd a;
  private awgg jdField_a_of_type_Awgg;
  private bavd jdField_a_of_type_Bavd;
  public bdtz a;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  protected oxd a;
  public boolean a;
  private alpd[] jdField_a_of_type_ArrayOfAlpd = new alpd[1];
  public int b;
  public boolean b;
  private int c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
  }
  
  private void a()
  {
    QbSdk.setTbsLogClient(new alpb(this, BaseApplicationImpl.getContext()));
  }
  
  public static void a(int paramInt)
  {
    String str1 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.RemoveSessionConfig.name());
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(str1)) {
          break label162;
        }
        i = Integer.parseInt(str1);
        if ((i & paramInt) != paramInt) {
          break label147;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
          if (1 == paramInt)
          {
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
            if (1 != paramInt) {
              break label168;
            }
            str1 = "all";
            QLog.e("BrowserAppInterface", 1, String.format("Remove %s cookies", new Object[] { str1 }));
            return;
          }
          if (2 != paramInt) {
            continue;
          }
          CookieManager.getInstance().removeSessionCookie();
          continue;
        }
        if (1 != paramInt) {
          break label132;
        }
      }
      catch (Exception localException)
      {
        QLog.e("BrowserAppInterface", 1, "Remove all cookies failed", localException);
        return;
      }
      CookieManager.getInstance().removeAllCookies(null);
      continue;
      label132:
      if (2 == paramInt)
      {
        CookieManager.getInstance().removeSessionCookies(null);
        continue;
        label147:
        if (QLog.isColorLevel()) {
          QLog.d("BrowserAppInterface", 2, "Not required remove cookies");
        }
        return;
        label162:
        i = 15;
        continue;
        label168:
        String str2 = "session";
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BrowserAppInterface", 2, "try get lock from sHasRemoveLastCookies");
      }
      synchronized (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 4);
          if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, String.format("removeLastUinCookies, last uin: %s, current uin is: %s", new Object[] { localSharedPreferences.getString("LastUIN", ""), paramString }));
          }
          if (!localSharedPreferences.getString("LastUIN", "").equals(paramString))
          {
            long l = System.currentTimeMillis();
            a(1);
            QLog.e("BrowserAppInterface", 1, "User account changed, need remove all cookies. cost=" + (System.currentTimeMillis() - l));
            if (!TextUtils.isEmpty(paramString)) {
              localSharedPreferences.edit().putString("LastUIN", paramString).commit();
            }
          }
          jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        return;
      }
    }
  }
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    String str = paramIntent.getAction();
    if (str == null) {
      return false;
    }
    QLog.e("BrowserAppInterface", 1, "exitBrowserRunTime: receiveAction: " + str);
    if (str.equals("com.tencent.process.exit"))
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      try
      {
        paramContext = paramContext.getRunningTasks(1);
        if ((paramContext != null) && (paramContext.size() >= 1))
        {
          paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, "runningActivity=" + paramContext);
          }
          if ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay")))) {
            return true;
          }
        }
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          return true;
        }
        paramContext = (PathTraceManager)getManager(210);
        if ((paramContext != null) && (paramContext.a())) {
          return true;
        }
        if (!atfm.a())
        {
          int i = j;
          if (paramIntent != null)
          {
            i = j;
            if (paramIntent.getBooleanExtra("qq_mode_foreground", false)) {
              i = 1;
            }
          }
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BrowserAppInterface", 2, " has floating window， not exit tool process");
            }
            return true;
          }
        }
        return a(paramIntent);
      }
    }
    if ((str.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (str.equals("mqq.intent.action.ACCOUNT_KICKED")))
    {
      a(1);
      return a(paramIntent);
    }
    if ((!isLogin()) && (str.equals("mqq.intent.action.ACCOUNT_EXPIRED")))
    {
      QLog.e("BrowserAppInterface", 1, "ACTION_ACCOUNT_EXPIRED, need remove all cookie: " + jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      if (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        a(1);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool3 = WebProcessManager.b();
    int i = BaseApplicationImpl.getApplication().getRuntime().getRunningModuleSize();
    boolean bool1;
    boolean bool2;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
    {
      bool1 = true;
      boolean bool4 = BaseApplicationImpl.getApplication().getRuntime().isModuleRunning("modular_web");
      if (WebAccelerateHelper.isWebViewCache) {
        break label161;
      }
      bool2 = true;
      label55:
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, String.format("qq_mode_foreground= %b, runningModuleSize: %d, isPreloadWebProcess: %b, isWebModuleExit: %b, isPreloadSucess: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) }));
      }
      if (!bool1) {
        break label262;
      }
      if ((!bool3) || (!bool4) || (!bool2) || (i > 1)) {
        break label167;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "don't need kill web process!");
      }
    }
    label161:
    label167:
    do
    {
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label55;
      if ((!SnapshotService.a()) || (this.jdField_c_of_type_Int >= 10)) {
        break label235;
      }
      this.jdField_c_of_type_Int += 1;
    } while (!QLog.isColorLevel());
    QLog.d("BrowserAppInterface", 2, "don't kill web process for debug snapshot, " + this.jdField_c_of_type_Int + "times");
    return true;
    label235:
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, "try restart web process");
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    for (;;)
    {
      return false;
      label262:
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "exit web process");
      }
      if (bool3) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  private alpd b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new nup(this);
  }
  
  public alpd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAlpd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAlpd)
    {
      alpd localalpd = this.jdField_a_of_type_ArrayOfAlpd[paramInt];
      localObject1 = localalpd;
      if (localalpd == null)
      {
        localalpd = b(paramInt);
        localObject1 = localalpd;
        if (localalpd != null)
        {
          this.jdField_a_of_type_ArrayOfAlpd[paramInt] = localalpd;
          localObject1 = localalpd;
        }
      }
      return localObject1;
    }
  }
  
  public auxd a()
  {
    if (this.jdField_a_of_type_Auxd == null) {
      this.jdField_a_of_type_Auxd = new auxd(this);
    }
    return this.jdField_a_of_type_Auxd;
  }
  
  public String a()
  {
    return null;
  }
  
  public oxd a()
  {
    if (this.jdField_a_of_type_Oxd == null) {
      this.jdField_a_of_type_Oxd = new oxd(this);
    }
    return this.jdField_a_of_type_Oxd;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = BaseApplication.getContext();
    if ((!paramBoolean1) && ((!AppNetConnInfo.isNetSupport()) || (!AppNetConnInfo.isWifiConn()))) {
      if (!AppNetConnInfo.isNetSupport()) {
        QbSdk.setUploadCode(BaseApplication.getContext(), 151);
      }
    }
    do
    {
      do
      {
        return;
      } while (AppNetConnInfo.isWifiConn());
      QbSdk.setUploadCode(BaseApplication.getContext(), 152);
      return;
      QbSdk.setUploadCode(BaseApplication.getContext(), 153);
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        QbSdk.setUploadCode(BaseApplication.getContext(), 154);
        long l = System.currentTimeMillis();
        localObject = ((Context)localObject).getSharedPreferences(((Context)localObject).getPackageName() + "_preferences", 4);
        QbSdk.setTbsListener(new alpc(this, (SharedPreferences)localObject, l));
        QLog.d("TBS_update", 1, "tbs start download");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_downloading", true);
        ((SharedPreferences.Editor)localObject).remove("tbs_download_complete");
        ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
        ((SharedPreferences.Editor)localObject).commit();
        this.jdField_a_of_type_Int = 0;
        if (AppNetConnInfo.isWifiConn())
        {
          QbSdk.setUploadCode(BaseApplication.getContext(), 155);
          TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean2);
          return;
        }
        TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean3);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TBS_update", 2, "tbs has started downloading");
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public awgg getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Awgg == null) {
      this.jdField_a_of_type_Awgg = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Awgg;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject4 = localObject1;
    Map localMap;
    if (localObject1 == null)
    {
      localMap = this.jdField_a_of_type_JavaUtilMap;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
          break label239;
        }
        localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = super.getManager(paramInt);
        }
        return localObject1;
      }
      finally {}
      localObject1 = new beag(this);
      continue;
      Object localObject3 = new bcod(this);
      continue;
      localObject3 = new TicketManagerImpl(this);
      continue;
      localObject3 = new bioj(this);
      continue;
      localObject3 = new PathTraceManager(this);
      continue;
      localObject3 = new ahbf(this);
      continue;
      localObject3 = new bjas();
      continue;
      label239:
      localObject4 = localObject3;
      if (localObject3 != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject3);
        localObject4 = localObject3;
      }
    }
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { nef.class };
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public baue getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bavd == null) {
      this.jdField_a_of_type_Bavd = new bavd();
    }
    return this.jdField_a_of_type_Bavd.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onBeforeExitProc, now it will exit web process!");
    }
    boolean bool = WebProcessManager.b();
    WebProcessManager.b(false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntent.putExtra("isPreloadWebProcess", bool);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.report");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bdnm.a(null, "web_browserAppinterface_onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      if (Build.VERSION.SDK_INT >= 28) {
        android.webkit.WebView.setDataDirectorySuffix("tool");
      }
      bejq.a(this);
      a();
      str = getAccount();
      if (TextUtils.isEmpty(str))
      {
        paramBundle = null;
        QbSdk.setCurrentID(paramBundle);
        nbv.a(new ndn());
        nbv.a(new ncm());
        nbv.a(new ncl());
        nbv.a(BaseApplicationImpl.getContext());
        if (getLongAccountUin() % 10L != 6L) {
          break label261;
        }
        bool = true;
        nbv.jdField_a_of_type_Boolean = bool;
        if (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, "BrowserAppInterface.onCreate: try removeLastUinCookies!");
          }
          ThreadManager.getSubThreadHandler().post(new BrowserAppInterface.1(this, str));
        }
        paramBundle = BaseApplication.getContext().getSharedPreferences("webview_report_config", 0);
        if (!paramBundle.getBoolean("is_set", false)) {
          paramBundle.edit().putBoolean("hide_back_text", true).putBoolean("is_set", true).commit();
        }
        beiy.A = SystemClock.elapsedRealtime();
        bdnm.a("web_browserAppinterface_onCreate", null);
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        String str;
        QLog.e("BrowserAppInterface", 1, "setDataDirectorySuffix error");
        continue;
        paramBundle = "QQ:" + str;
        continue;
        label261:
        boolean bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Auxd != null) {}
    try
    {
      this.jdField_a_of_type_Auxd.onDestroy();
      this.jdField_a_of_type_Auxd = null;
      if (this.jdField_a_of_type_Bavd != null) {
        this.jdField_a_of_type_Bavd.onDestroy();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_Bavd.onDestroy();
        this.jdField_a_of_type_Bavd = null;
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet();
          if ((localObject1 == null) || (((Set)localObject1).size() <= 0)) {
            break label196;
          }
          localObject1 = ((Set)localObject1).iterator();
          do
          {
            for (;;)
            {
              boolean bool = ((Iterator)localObject1).hasNext();
              if (!bool) {
                break label196;
              }
              try
              {
                Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject1).next());
                if (localManager != null) {
                  localManager.onDestroy();
                }
              }
              catch (Exception localException3)
              {
                localException3.printStackTrace();
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("BrowserAppInterface", 2, "onDesotry", localException3);
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        label196:
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAlpd)
      {
        alpd[] arrayOfalpd2 = this.jdField_a_of_type_ArrayOfAlpd;
        int j = arrayOfalpd2.length;
        i = 0;
        if (i < j)
        {
          alpd localalpd = arrayOfalpd2[i];
          if (localalpd != null) {
            localalpd.onDestroy();
          }
        }
        else
        {
          if (bazo.a != null) {
            bazo.a().a();
          }
          athj.a();
          UiApiPlugin.f();
          if (this.jdField_a_of_type_Oxd != null) {
            this.jdField_a_of_type_Oxd.b();
          }
          return;
        }
      }
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onReceiveAccountAction");
    }
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onReceiveLegalExitProcAction");
    }
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public void onRunningBackground()
  {
    super.onRunningBackground();
    boolean bool = com.tencent.smtt.sdk.WebView.getTbsNeedReboot();
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, "tbs need reboot: " + bool);
    }
    if (bool) {
      getHandler(BrowserAppInterface.class).postDelayed(new BrowserAppInterface.4(this), 3000L);
    }
    if ((WebCoreService.jdField_a_of_type_Boolean) && (bdgk.e() >>> 20 < 20L)) {
      WebCoreService.b();
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(bdgk.d()));
      localHashMap.put("param_availableMem", String.valueOf(bdgk.e()));
      localHashMap.put("param_cpuNum", String.valueOf(bdgk.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(bdgk.a()));
      localHashMap.put("param_releaseType", String.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "releaseWebCoreServiceReport:" + localHashMap.toString());
      }
      azri.a(getApplication()).a(getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
    bczz.a(getApp());
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Amqu.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */