package com.tencent.mobileqq.app;

import aioi;
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
import anrd;
import anre;
import aozq;
import avxi;
import avzm;
import axqp;
import bgko;
import bgyd;
import bhhy;
import bhon;
import bhyq;
import biij;
import blsk;
import bmfv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
import cooperation.ilive.IliveAppInterface;
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
import nuz;
import nvp;
import nvq;
import nwl;
import nxe;
import ook;
import pvp;

public class BrowserAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static final AtomicBoolean a;
  public static final AtomicBoolean b;
  public static final AtomicBoolean c;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  public Intent a;
  aozq jdField_a_of_type_Aozq = new aozq(this);
  protected axqp a;
  public bhon a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  protected pvp a;
  public boolean a;
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[1];
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
    QbSdk.setTbsLogClient(new anrd(this, BaseApplicationImpl.getContext()));
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
    String str = paramIntent.getAction();
    if (str == null) {
      return false;
    }
    if (IliveAppInterface.a()) {
      return true;
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
          if ((paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay")))) {
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
        paramContext = (PathTraceManager)getManager(QQManagerFactory.PATH_TRACE_MANAGER);
        if ((paramContext != null) && (paramContext.a())) {
          return true;
        }
        if ((!avxi.a()) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, " has floating window， not exit tool process");
          }
          return true;
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
  
  private BusinessHandler b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new ook(this);
  }
  
  public axqp a()
  {
    if (this.jdField_a_of_type_Axqp == null) {
      this.jdField_a_of_type_Axqp = new axqp(this);
    }
    return this.jdField_a_of_type_Axqp;
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public pvp a()
  {
    if (this.jdField_a_of_type_Pvp == null) {
      this.jdField_a_of_type_Pvp = new pvp(this);
    }
    return this.jdField_a_of_type_Pvp;
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
        QbSdk.setTbsListener(new anre(this, (SharedPreferences)localObject, l));
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
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject4 = localObject1;
    if (localObject1 == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (paramInt == QQManagerFactory.DOWNLOADER_FACTORY)
        {
          localObject1 = new bhyq(this);
          if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
            break label215;
          }
          localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = super.getManager(paramInt);
          }
          return localObject1;
        }
        if (paramInt == QQManagerFactory.TROOP_GIFT_MANAGER) {
          localObject1 = new bgko(this);
        }
      }
      Object localObject3;
      if (paramInt == 2)
      {
        localObject3 = new TicketManagerImpl(this);
      }
      else if (paramInt == QQManagerFactory.COMIC_RED_TOUCH_MANAGER)
      {
        localObject3 = new blsk(this);
      }
      else if (paramInt == QQManagerFactory.PATH_TRACE_MANAGER)
      {
        localObject3 = new PathTraceManager(this);
      }
      else if (paramInt == QQManagerFactory.ZHITU_MANAGER)
      {
        localObject3 = new aioi(this);
      }
      else if (paramInt == QQManagerFactory.READER_RED_TOUCH_MANAGER)
      {
        localObject3 = new bmfv();
        continue;
        label215:
        localObject4 = localObject3;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject3);
          localObject4 = localObject3;
        }
      }
    }
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { nxe.class };
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.getEngineInstance(this, paramInt);
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
    bhhy.a(null, "web_browserAppinterface_onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      if (Build.VERSION.SDK_INT >= 28) {
        android.webkit.WebView.setDataDirectorySuffix("tool");
      }
      biij.a(this);
      a();
      str = getAccount();
      if (TextUtils.isEmpty(str))
      {
        paramBundle = null;
        QbSdk.setCurrentID(paramBundle);
        nuz.a(new nwl());
        nuz.a(new nvq());
        nuz.a(new nvp());
        nuz.a(BaseApplicationImpl.getContext());
        if (getLongAccountUin() % 10L != 6L) {
          break label261;
        }
        bool = true;
        nuz.jdField_a_of_type_Boolean = bool;
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
        bihv.A = SystemClock.elapsedRealtime();
        bhhy.a("web_browserAppinterface_onCreate", null);
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
    if (this.jdField_a_of_type_Axqp != null) {}
    try
    {
      this.jdField_a_of_type_Axqp.onDestroy();
      this.jdField_a_of_type_Axqp = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
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
      synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
      {
        BusinessHandler[] arrayOfBusinessHandler2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler;
        int j = arrayOfBusinessHandler2.length;
        i = 0;
        if (i < j)
        {
          BusinessHandler localBusinessHandler = arrayOfBusinessHandler2[i];
          if (localBusinessHandler != null) {
            localBusinessHandler.onDestroy();
          }
        }
        else
        {
          if (InnerDns.mInstance != null) {
            InnerDns.getInstance().onAppDestroy();
          }
          avzm.a();
          UiApiPlugin.f();
          if (this.jdField_a_of_type_Pvp != null) {
            this.jdField_a_of_type_Pvp.b();
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
    if ((WebCoreService.jdField_a_of_type_Boolean) && (DeviceInfoUtil.getSystemAvaialbeMemory() >>> 20 < 20L)) {
      WebCoreService.b();
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.getSystemAvaialbeMemory()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.getCpuNumber()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.getCpuFrequency()));
      localHashMap.put("param_releaseType", String.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "releaseWebCoreServiceReport:" + localHashMap.toString());
      }
      StatisticCollector.getInstance(getApplication()).collectPerformance(getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
    bgyd.a(getApp());
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Aozq.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */