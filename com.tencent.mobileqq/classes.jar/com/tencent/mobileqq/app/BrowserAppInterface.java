package com.tencent.mobileqq.app;

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
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.MyLog;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.game.GamePushServlet;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.utils.BrowserService;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebCoreService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.util.ITbsDownloader;
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

public class BrowserAppInterface
  extends BaseToolAppInterface
  implements ITbsDownloader, IToolProcEventListener
{
  public static final AtomicBoolean c = new AtomicBoolean(false);
  public static final AtomicBoolean k = new AtomicBoolean(false);
  public static final AtomicBoolean l = new AtomicBoolean(false);
  public static final String m = EcshopReportHandler.class.getName();
  long a;
  BrowserService b = new BrowserService(this);
  int d = 0;
  boolean e = false;
  int f = -1;
  Intent g;
  Map<Integer, Manager> h = new HashMap(20);
  public boolean i = false;
  public boolean j = false;
  protected IOldBigDataChannelManager n = null;
  private EntityManagerFactory o;
  private int p = 0;
  private IReadInJoyLogicManager q = null;
  private NetEngineFactory r = null;
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public static void a(int paramInt)
  {
    String str1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.RemoveSessionConfig.name());
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str1)) {
          break label175;
        }
        i1 = Integer.parseInt(str1);
        if ((i1 & paramInt) == paramInt)
        {
          if (Build.VERSION.SDK_INT < 21)
          {
            CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
            if (1 == paramInt) {
              CookieManager.getInstance().removeAllCookie();
            } else if (2 == paramInt) {
              CookieManager.getInstance().removeSessionCookie();
            }
            CookieSyncManager.getInstance().sync();
          }
          else if (1 == paramInt)
          {
            CookieManager.getInstance().removeAllCookies(null);
          }
          else if (2 == paramInt)
          {
            CookieManager.getInstance().removeSessionCookies(null);
          }
          if (1 != paramInt) {
            break label181;
          }
          str1 = "all";
          QLog.e("BrowserAppInterface", 1, String.format("Remove %s cookies", new Object[] { str1 }));
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("BrowserAppInterface", 2, "Not required remove cookies");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("BrowserAppInterface", 1, "Remove all cookies failed", localException);
      }
      return;
      label175:
      int i1 = 15;
      continue;
      label181:
      String str2 = "session";
    }
  }
  
  public static void a(String paramString)
  {
    if (!k.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BrowserAppInterface", 2, "try get lock from sHasRemoveLastCookies");
      }
      synchronized (k)
      {
        if (!k.get())
        {
          SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 4);
          if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, String.format("removeLastUinCookies, last uin: %s, current uin is: %s", new Object[] { localSharedPreferences.getString("LastUIN", ""), paramString }));
          }
          if (!localSharedPreferences.getString("LastUIN", "").equals(paramString))
          {
            long l1 = System.currentTimeMillis();
            a(1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("User account changed, need remove all cookies. cost=");
            localStringBuilder.append(System.currentTimeMillis() - l1);
            QLog.e("BrowserAppInterface", 1, localStringBuilder.toString());
            if (!TextUtils.isEmpty(paramString)) {
              localSharedPreferences.edit().putString("LastUIN", paramString).commit();
            }
          }
          k.set(true);
        }
        return;
      }
    }
  }
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject == null) {
      return false;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("exitBrowserRunTime: receiveAction: ");
    localStringBuilder2.append((String)localObject);
    QLog.e("BrowserAppInterface", 1, localStringBuilder2.toString());
    StringBuilder localStringBuilder1;
    if (((String)localObject).equals("com.tencent.process.exit"))
    {
      localObject = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = null;
      try
      {
        localObject = ((ActivityManager)localObject).getRunningTasks(1);
        paramContext = (Context)localObject;
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
      }
      if ((paramContext != null) && (paramContext.size() >= 1))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("runningActivity=");
          localStringBuilder1.append(paramContext);
          QLog.d("BrowserAppInterface", 2, localStringBuilder1.toString());
        }
        if ((paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay")))) {
          return true;
        }
      }
      if (c.get())
      {
        this.e = true;
        this.g = paramIntent;
        return true;
      }
      try
      {
        paramContext = (IPathTraceManager)getRuntimeService(IPathTraceManager.class, "tool");
        if (paramContext != null)
        {
          boolean bool = paramContext.isRunning();
          if (bool) {
            return true;
          }
        }
      }
      catch (IllegalStateException paramContext)
      {
        QLog.e("BrowserAppInterface", 1, "Error when get RuntimeService IPathTraceManager", paramContext);
        if ((!TogetherWatchFloatingUtil.a()) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, " has floating window， not exit tool process");
          }
          return true;
        }
        return a(paramIntent);
      }
    }
    if ((!localStringBuilder1.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!localStringBuilder1.equals("mqq.intent.action.ACCOUNT_KICKED")))
    {
      if ((!isLogin()) && (localStringBuilder1.equals("mqq.intent.action.ACCOUNT_EXPIRED")))
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_ACCOUNT_EXPIRED, need remove all cookie: ");
        paramContext.append(l.get());
        QLog.e("BrowserAppInterface", 1, paramContext.toString());
        if (l.compareAndSet(false, true)) {
          a(1);
        }
        return true;
      }
      return false;
    }
    a(1);
    return a(paramIntent);
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool2 = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess();
    int i1 = BaseApplicationImpl.getApplication().getRuntime().getRunningModuleSize();
    boolean bool1;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("qq_mode_foreground", false))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = BaseApplicationImpl.getApplication().getRuntime().isModuleRunning("modular_web");
    boolean bool4 = WebAccelerateHelper.isWebViewCache ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, String.format("qq_mode_foreground= %b, runningModuleSize: %d, isPreloadWebProcess: %b, isWebModuleExit: %b, isPreloadSucess: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
    }
    if (bool1)
    {
      if ((bool2) && (bool3) && (bool4) && (i1 <= 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BrowserAppInterface", 2, "don't need kill web process!");
        }
        return true;
      }
      if (SnapshotService.a())
      {
        i1 = this.p;
        if (i1 < 10)
        {
          this.p = (i1 + 1);
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("don't kill web process for debug snapshot, ");
            paramIntent.append(this.p);
            paramIntent.append("times");
            QLog.d("BrowserAppInterface", 2, paramIntent.toString());
          }
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "try restart web process");
      }
      this.p = 0;
      this.i = true;
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, "exit web process");
    }
    if (bool2) {
      this.j = true;
    }
    return false;
  }
  
  private void d()
  {
    QbSdk.setTbsLogClient(new BrowserAppInterface.2(this, BaseApplicationImpl.getContext()));
  }
  
  public String a()
  {
    return null;
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
    if ((!paramBoolean1) && ((!AppNetConnInfo.isNetSupport()) || (!AppNetConnInfo.isWifiConn())))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QbSdk.setUploadCode(BaseApplication.getContext(), 151);
        return;
      }
      if (!AppNetConnInfo.isWifiConn()) {
        QbSdk.setUploadCode(BaseApplication.getContext(), 152);
      }
      return;
    }
    QbSdk.setUploadCode(BaseApplication.getContext(), 153);
    if (c.compareAndSet(false, true))
    {
      QbSdk.setUploadCode(BaseApplication.getContext(), 154);
      long l1 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Context)localObject).getPackageName());
      localStringBuilder.append("_preferences");
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
      QbSdk.setTbsListener(new BrowserAppInterface.3(this, (SharedPreferences)localObject, l1));
      QLog.d("TBS_update", 1, "tbs start download");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("tbs_downloading", true);
      ((SharedPreferences.Editor)localObject).remove("tbs_download_complete");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
      this.d = 0;
      if (AppNetConnInfo.isWifiConn())
      {
        QbSdk.setUploadCode(BaseApplication.getContext(), 155);
        TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean2);
        return;
      }
      TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TBS_update", 2, "tbs has started downloading");
    }
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.h.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.h.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public IOldBigDataChannelManager b()
  {
    if (this.n == null)
    {
      this.n = ((IOldBigDataChannelManager)QRoute.api(IOldBigDataChannelManager.class));
      this.n.init(this);
    }
    return this.n;
  }
  
  public IReadInJoyLogicManager c()
  {
    if (this.q == null) {
      this.q = ((IReadInJoyLogicManagerFactory)QRoute.api(IReadInJoyLogicManagerFactory.class)).createReadInJoyLogicManager(this);
    }
    return this.q;
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
    if (this.o == null) {
      this.o = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.o;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.h.get(Integer.valueOf(paramInt));
    Object localObject4 = localObject1;
    if (localObject1 == null) {
      synchronized (this.h)
      {
        if (paramInt == QQManagerFactory.DOWNLOADER_FACTORY) {
          localObject1 = new DownloaderFactory(this);
        } else if (paramInt == QQManagerFactory.TROOP_GIFT_MANAGER) {
          localObject1 = new TroopGiftManager(this);
        } else if (paramInt == 2) {
          localObject1 = new TicketManagerImpl(this);
        } else if (paramInt == QQManagerFactory.ZHITU_MANAGER) {
          localObject1 = new ZhituManager(this);
        } else if (paramInt == QQManagerFactory.URL_INTECEPT_MANAGER) {
          localObject1 = new URLInterceptManager();
        }
        if (this.h.get(Integer.valueOf(paramInt)) != null)
        {
          localObject4 = (Manager)this.h.get(Integer.valueOf(paramInt));
        }
        else
        {
          localObject4 = localObject1;
          if (localObject1 != null)
          {
            this.h.put(Integer.valueOf(paramInt), localObject1);
            localObject4 = localObject1;
          }
        }
      }
    }
    Object localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = super.getManager(paramInt);
    }
    return localObject3;
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { GamePushServlet.class };
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.b;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onBeforeExitProc, now it will exit web process!");
    }
    boolean bool = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(false);
    Intent localIntent;
    if (this.i)
    {
      this.i = false;
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntent.putExtra("isPreloadWebProcess", bool);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      return;
    }
    if (this.j)
    {
      this.j = false;
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.webprocess.report");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "web_browserAppinterface_onCreate");
    super.onCreate(paramBundle);
    this.a = System.currentTimeMillis();
    try
    {
      if (Build.VERSION.SDK_INT < 28) {
        break label45;
      }
      android.webkit.WebView.setDataDirectorySuffix("tool");
    }
    catch (Throwable paramBundle)
    {
      label36:
      String str;
      boolean bool;
      break label36;
    }
    QLog.e("BrowserAppInterface", 1, "setDataDirectorySuffix error");
    label45:
    SwiftBrowserIdleTaskHelper.a(this);
    d();
    str = getAccount();
    if (TextUtils.isEmpty(str))
    {
      paramBundle = null;
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("QQ:");
      paramBundle.append(str);
      paramBundle = paramBundle.toString();
    }
    QbSdk.setCurrentID(paramBundle);
    HtmlOffline.a(new QQThreadManager());
    HtmlOffline.a(new OfflineDownloader());
    HtmlOffline.a(new MyLog());
    HtmlOffline.a(BaseApplicationImpl.getContext());
    if (getLongAccountUin() % 10L == 6L) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.i = bool;
    if (!k.get())
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
    com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.E = SystemClock.elapsedRealtime();
    StartupTracker.a("web_browserAppinterface_onCreate", null);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IOldBigDataChannelManager localIOldBigDataChannelManager = this.n;
    if (localIOldBigDataChannelManager != null)
    {
      try
      {
        localIOldBigDataChannelManager.onDestroy();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      this.n = null;
    }
    NetEngineFactory localNetEngineFactory = this.r;
    if (localNetEngineFactory != null)
    {
      localNetEngineFactory.onDestroy();
      try
      {
        this.r.onDestroy();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      this.r = null;
    }
    synchronized (this.h)
    {
      Object localObject2 = this.h.keySet();
      if ((localObject2 != null) && (((Set)localObject2).size() > 0))
      {
        localObject2 = ((Set)localObject2).iterator();
        for (;;)
        {
          boolean bool = ((Iterator)localObject2).hasNext();
          if (!bool) {
            break;
          }
          try
          {
            Manager localManager = (Manager)this.h.get(((Iterator)localObject2).next());
            if (localManager == null) {
              continue;
            }
            localManager.onDestroy();
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.e("BrowserAppInterface", 2, "onDesotry", localException3);
          }
        }
      }
      this.h.clear();
      if (InnerDns.mInstance != null) {
        InnerDns.getInstance().onAppDestroy();
      }
      EventApiPlugin.b();
      UiApiPlugin.g();
      ??? = this.q;
      if (??? != null) {
        ((IReadInJoyLogicManager)???).unInitialize();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
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
  
  protected void onRunningBackground()
  {
    super.onRunningBackground();
    boolean bool = com.tencent.smtt.sdk.WebView.getTbsNeedReboot();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tbs need reboot: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("BrowserAppInterface", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      getHandler(BrowserAppInterface.class).postDelayed(new BrowserAppInterface.4(this), 3000L);
    }
    if ((WebCoreService.a) && (DeviceInfoUtil.r() >>> 20 < 20L)) {
      WebCoreService.b();
    }
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
      ((HashMap)localObject).put("param_availableMem", String.valueOf(DeviceInfoUtil.r()));
      ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.h()));
      ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.k()));
      ((HashMap)localObject).put("param_releaseType", String.valueOf(1));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseWebCoreServiceReport:");
        localStringBuilder.append(((HashMap)localObject).toString());
        QLog.d("BrowserAppInterface", 2, localStringBuilder.toString());
      }
      StatisticCollector.getInstance(getApplication()).collectPerformance(getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onRunningForeground()
  {
    super.onRunningForeground();
    this.e = false;
    this.g = null;
    AccessibilityUtil.a(getApp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */