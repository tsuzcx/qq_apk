package com.tencent.common.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.alpha.DCLBridge;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.pushnotice.ThirdPushSupportImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteConfigBuilder;
import com.tencent.mobileqq.qroute.remote.IQRemoteProxy;
import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.mobileqq.qroute.utils.IProcessCheck;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.qqperf.monitor.sp.SPStatInspector;
import com.tencent.shadow.core.common.LoggerFactory;
import cooperation.plugin.PluginQRoutePluginFactoryImpl;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.ThirdAppReportHelper;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class BaseApplicationImpl
  extends MobileQQ
{
  public static String ASanEscapedMsg;
  public static boolean IS_SUPPORT_THEME = true;
  private static final String TAG = "BaseApplicationImpl";
  public static final String[] TOOL_PROCS = { ":tool", ":peak", ":qzone" };
  public static boolean appMainActivityHasLanuch = false;
  public static long appStartTime = 0L;
  public static final String bootBroadcastName = "com.tencent.mobileqq.broadcast.qq";
  public static boolean isInActionS = true;
  private static volatile AppRuntimeFactory sAppRuntimeFactory = new AppRuntimeFactoryImpl();
  public static BaseApplicationImpl sApplication;
  public static StartupDirector sDirector;
  public static String sFoo2Version = "";
  public static String sFooVersion = "";
  public static boolean sIsBgStartup = false;
  public static long sLaunchTime = 0L;
  public static String sNativeMonitorEscapedMsg;
  public static String sQQAppInterfaceEscapedMsg = "";
  public static long sShowTime = 0L;
  public static String sSplashActivityEscapedMsg = "";
  public static long sToolShowTime;
  public static MqqHandler sUiHandler;
  private MSFInterfaceAdapter mMSFInterfaceAdapter;
  private final ILogger mQRouteLogger = new BaseApplicationImpl.1(this);
  private final IQRemoteProxy mQRouteRemoteProxy = new BaseApplicationImpl.3(this);
  private final IProcessCheck mQRouterProcessCheck = new BaseApplicationImpl.2(this);
  private Intent pcActiveNoticeIntent = null;
  private String pcactiveContent = null;
  private String pcactiveLButton = null;
  private String pcactiveRButton = null;
  private String pcactiveUin = null;
  
  public BaseApplicationImpl()
  {
    buildNum = "5295";
    reportVersionName = "8.7.0.5295";
  }
  
  private void attachThreadContext()
  {
    com.tencent.mobileqq.app.ThreadSetting.isPublicVersion = true;
    com.tencent.mobileqq.app.ThreadSetting.isGrayVersion = false;
    com.tencent.mobileqq.app.ThreadSetting.revision = "01328a87";
    com.tencent.mobileqq.app.ThreadSetting.sProcessId = sProcessId;
    com.tencent.mobileqq.app.ThreadSetting.PROCESS_QQ = 1;
    com.tencent.mobileqq.app.ThreadSetting.CLR = 2;
  }
  
  public static BaseApplicationImpl getApplication()
  {
    return sApplication;
  }
  
  public static String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    int i;
    if (paramBoolean) {
      i = ((Time)localObject).minute - 1;
    } else {
      i = ((Time)localObject).minute;
    }
    localStringBuilder.append(i);
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  private void initQLog()
  {
    long l = 3000L;
    try
    {
      if (sProcessId == 1)
      {
        localObject1 = QConfigLocalLoader.a(this);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getLogExternalPath(context));
        ((StringBuilder)localObject2).append("/tencent/msflogs/");
        ((StringBuilder)localObject2).append(getPackageName().replace(".", "/"));
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append("QLogConfig_C");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("base=");
        localStringBuilder.append(((QConfLogBean)localObject1).toString());
        localStringBuilder.append(" logConfigPath=");
        localStringBuilder.append(((File)localObject2).getAbsolutePath());
        Log.d("init_log", localStringBuilder.toString());
        if ((!((QConfLogBean)localObject1).a()) && (!((File)localObject2).exists())) {
          ((File)localObject2).createNewFile();
        } else if ((((QConfLogBean)localObject1).a()) && (((File)localObject2).exists())) {
          ((File)localObject2).delete();
        }
        QLog.init("com.tencent.mobileqq", BaseApplication.processName, AppSetting.a, 3000L);
        return;
      }
      QLog.init("com.tencent.mobileqq", BaseApplication.processName, AppSetting.a, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject2;
      label225:
      break label225;
    }
    localObject1 = BaseApplication.processName;
    localObject2 = AppSetting.a;
    if (sProcessId != 1) {
      l = 0L;
    }
    QLog.init("com.tencent.mobileqq", (String)localObject1, (String)localObject2, l);
  }
  
  private void initQRoute()
  {
    QRoute.init(new QRouteConfigBuilder(getProcessSuffix(BaseApplication.processName, "com.tencent.mobileqq")).setForceCheck(false).setLogger(this.mQRouteLogger).setProcessCheck(this.mQRouterProcessCheck).setRemoteProxy(this.mQRouteRemoteProxy).setPluginFactory(new PluginQRoutePluginFactoryImpl()).create());
  }
  
  public static void setAppRuntimeFactory(AppRuntimeFactory paramAppRuntimeFactory)
  {
    sAppRuntimeFactory = paramAppRuntimeFactory;
  }
  
  private void setupAppSettings()
  {
    AppSetting.b(false);
    AppSetting.a(false);
    AppSetting.c(false);
  }
  
  public static boolean useQIPCStart(String paramString)
  {
    String[] arrayOfString = TOOL_PROCS;
    int j = arrayOfString.length;
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (paramString.endsWith(arrayOfString[i]))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = paramString.endsWith(":smartdevice");
    }
    return bool2;
  }
  
  public void addOtherTypeActivity(Activity paramActivity)
  {
    this.otherTypeActivitys.add(new WeakReference(paramActivity));
    ActivityLifeCycleInfoRecordHelper.a(paramActivity);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    if (sProcessId == 7) {
      sToolShowTime = SystemClock.uptimeMillis();
    }
    attachThreadContext();
    setupAppSettings();
    QLog.setAppContext(this);
    initQLog();
    initQRoute();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QLog.getLogPath());
    localStringBuilder.append("QLogConfig_B");
    if (!new File(localStringBuilder.toString()).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(QLog.getLogPath());
      localStringBuilder.append("QLogConfig_C");
      new File(localStringBuilder.toString()).exists();
    }
    QLog.setFullEncryptedLogMode(false);
    QLog.setDebugMode(false);
    int j = TOOL_PROCS.length;
    int i = 0;
    while (i < j)
    {
      if ((processName != null) && (processName.endsWith(TOOL_PROCS[i])))
      {
        MobileQQ.sIsToolProc = true;
        break;
      }
      i += 1;
    }
    LocaleManager.a(this);
    MultiLanguageEngine.a().a(paramContext);
    FontSettingManager.resetFontIfNeeded(this, false, true);
    SharedPreferencesProxyManager.getInstance().init(paramContext, new BaseApplicationImpl.7(this));
    if (SPStatInspector.a) {
      SharedPreferencesProxyManager.setLogCallback(SPStatInspector.a());
    }
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 2);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public AppRuntime createRuntime(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AppRuntime localAppRuntime = peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (localAppRuntime.getLongAccountUin() > 10000L)) {
        ((QQAppInterface)localAppRuntime).startInspect();
      }
    }
    return AppInterfaceFactory.a(this, paramString);
  }
  
  public void doSendBroadcast(Intent paramIntent)
  {
    try
    {
      super.sendBroadcast(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("mqq", 1, "", paramIntent);
    }
  }
  
  public Object getAppData(String paramString)
  {
    String str = null;
    if (paramString == null) {
      return null;
    }
    if ("channel_id".equals(paramString)) {
      str = AppSetting.c();
    }
    return str;
  }
  
  public int getAppId()
  {
    return AppSetting.a();
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a();
  }
  
  public String getBootBroadcastName(String paramString)
  {
    if (paramString.equals("com.tencent.mobileqq")) {
      return "com.tencent.mobileqq.broadcast.qq";
    }
    if (paramString.equals("com.tencent.mobileqq:video")) {
      return "com.tencent.av.ui.VChatActivity";
    }
    if (paramString.equals("com.tencent.mobileqq:nearby_video")) {
      return "com.tencent.mobileqq.nearbyvideochat.awake";
    }
    return "";
  }
  
  public String getChannelId()
  {
    return AppSetting.c();
  }
  
  @NonNull
  public MSFInterfaceAdapter getMSFInterfaceAdapter()
  {
    if (this.mMSFInterfaceAdapter == null) {
      try
      {
        if (this.mMSFInterfaceAdapter == null) {
          this.mMSFInterfaceAdapter = new MSFInterfaceAdapterImpl();
        }
      }
      finally {}
    }
    return this.mMSFInterfaceAdapter;
  }
  
  public Intent getPCActiveNoticeIntent()
  {
    if ((this.pcactiveUin != null) && (this.pcactiveContent != null) && (this.pcactiveLButton != null) && (this.pcactiveRButton != null))
    {
      this.pcActiveNoticeIntent = new Intent("mqq.intent.action.PCACTIVE_TIPS");
      this.pcActiveNoticeIntent.putExtra("Message", this.pcactiveContent);
      this.pcActiveNoticeIntent.putExtra("uin", this.pcactiveUin);
      this.pcActiveNoticeIntent.putExtra("lButton", this.pcactiveLButton);
      this.pcActiveNoticeIntent.putExtra("rButton", this.pcactiveRButton);
      this.pcActiveNoticeIntent.addFlags(268435456);
      return this.pcActiveNoticeIntent;
    }
    return null;
  }
  
  public String getPCActiveUin()
  {
    return this.pcactiveUin;
  }
  
  public AppRuntime getRuntime()
  {
    AppRuntimeFactory localAppRuntimeFactory = sAppRuntimeFactory;
    if (localAppRuntimeFactory != null) {
      return localAppRuntimeFactory.a(this);
    }
    return null;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    if ((this.mApplicationReal != null) && ((this.mApplicationReal instanceof QFixApplicationImpl))) {
      return ((QFixApplicationImpl)this.mApplicationReal).getSystemSharedPreferences(paramString, paramInt);
    }
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public int getThirdPushType()
  {
    return PushNoticeUtil.a();
  }
  
  public boolean isNeedMSF(String paramString)
  {
    return !paramString.endsWith("lola");
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    boolean bool = paramObject instanceof Activity;
    if (bool)
    {
      MultiLanguageEngine localMultiLanguageEngine = MultiLanguageEngine.a();
      Activity localActivity = (Activity)paramObject;
      localMultiLanguageEngine.a(localActivity);
      LocaleManager.b(localActivity);
    }
    if ((Build.VERSION.SDK_INT >= 24) && (bool)) {
      FontSettingManager.resetFontIfNeeded((Activity)paramObject, true, false);
    }
    if (sProcessId == 1) {
      SafeModeUtil.a(context, paramObject);
    }
    if (sDirector != null)
    {
      if ((this.startComponentInfo == null) && (paramObject != null)) {
        this.startComponentInfo = paramObject.toString();
      }
      return sDirector.a(paramObject, paramIntent);
    }
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    StartupDirector localStartupDirector = sDirector;
    if (localStartupDirector != null) {
      localStartupDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BaseApplicationImpl onConfigurationChanged called, localeInfo1:");
      if (paramConfiguration != null)
      {
        localStringBuilder.append("\n");
        localStringBuilder.append("newConfig#Locale:");
        localStringBuilder.append(paramConfiguration.locale.toString());
      }
      else
      {
        localStringBuilder.append("\n");
        localStringBuilder.append("newConfig is null");
      }
      if (sApplication != null)
      {
        localStringBuilder.append("\n");
        localStringBuilder.append("sApplication#Locale pre:");
        localStringBuilder.append(sApplication.getResources().getConfiguration().locale.toString());
      }
      if (sMobileQQ != null)
      {
        localStringBuilder.append("\n");
        localStringBuilder.append("sMobileQQ#Locale pre:");
        localStringBuilder.append(sMobileQQ.getResources().getConfiguration().locale.toString());
      }
      LocaleManager.a(localStringBuilder.toString());
    }
    super.onConfigurationChanged(paramConfiguration);
    LocaleManager.a(this, LocaleManager.a());
    FontSettingManager.initFontSetting(this, true, true);
    if (QLog.isColorLevel())
    {
      paramConfiguration = new StringBuilder();
      paramConfiguration.append("BaseApplicationImpl onConfigurationChanged called, localeInfo2:");
      if (sApplication != null)
      {
        paramConfiguration.append("\n");
        paramConfiguration.append("sApplication#Locale end:");
        paramConfiguration.append(sApplication.getResources().getConfiguration().locale.toString());
      }
      if (sMobileQQ != null)
      {
        paramConfiguration.append("\n");
        paramConfiguration.append("sMobileQQ#Locale end:");
        paramConfiguration.append(sMobileQQ.getResources().getConfiguration().locale.toString());
      }
      if (!TextUtils.isEmpty(paramConfiguration.toString())) {
        LocaleManager.a(paramConfiguration.toString());
      }
    }
  }
  
  @TargetApi(15)
  public void onCreate()
  {
    if (sApplication != null) {
      return;
    }
    sApplication = this;
    sMobileQQ = this;
    context = this;
    SoLoadCore.setIsCpu64Bit(false);
    if (sProcessId == 2)
    {
      StartupDirector.b = true;
      PerfTracer.traceStart("App_onCreate");
    }
    LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
    QShadow.getInstance().init(this);
    sDirector = StartupDirector.a();
    if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(sInjectResult))) {
      registerActivityLifecycleCallbacks(UEC.a());
    }
    if (StartupDirector.b) {
      PerfTracer.traceEnd("App_onCreate");
    }
    ThirdAppReportHelper.sThirdAppReporter = new ThirdAppReportImpl();
    mqq.app.ThirdPushSupportHelper.sThirdPushSupport = new ThirdPushSupportImpl();
    setupMultiLanguage();
    DCLBridge.a(this);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramBroadcastReceiver = super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramBroadcastReceiver;
    }
    catch (Exception paramBroadcastReceiver)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "", paramBroadcastReceiver);
      }
    }
    return null;
  }
  
  public void removeOtherTypeActivity(Activity paramActivity)
  {
    this.otherTypeActivitys.remove(new WeakReference(paramActivity));
    ActivityLifeCycleInfoRecordHelper.d(paramActivity);
  }
  
  public void reportPCActive(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(paramInt));
    localHashMap.put("param_uin", paramString);
    StatisticCollector.getInstance(getApplication()).collectPerformance(paramString, "PcActiveSucc", true, 0L, 0L, localHashMap, "", true);
    sUiHandler.postDelayed(new BaseApplicationImpl.6(this, paramInt, paramString), 10000L);
    ReportController.b(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      if ((str != null) && ((str.startsWith("com.tencent.process.")) || (str.equals("com.tencent.qq.syncQQMessage")))) {}
    }
    else
    {
      i = 0;
      break label65;
    }
    int i = 1;
    ThreadManager.getSubThreadHandler().post(new BaseApplicationImpl.8(this, paramIntent));
    label65:
    if (i == 0) {
      doSendBroadcast(paramIntent);
    }
  }
  
  public void setPCActiveNotice(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pcactiveUin = paramString1;
    this.pcactiveContent = paramString2;
    this.pcactiveLButton = paramString3;
    this.pcactiveRButton = paramString4;
  }
  
  protected void setupMultiLanguage()
  {
    MultiLanguageEngine.a().b(this);
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      JumpActivity.processIntent(paramIntent);
      try
      {
        IATHandler.a(this, paramIntent, new BaseApplicationImpl.4(this, paramIntent));
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("BaseApplicationImpl", 1, paramIntent, new Object[0]);
        return;
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      JumpActivity.processIntent(paramIntent);
      try
      {
        IATHandler.a(this, paramIntent, new BaseApplicationImpl.5(this, paramIntent, paramBundle));
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("BaseApplicationImpl", 1, paramIntent, new Object[0]);
        return;
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startBeacon() {}
  
  public ComponentName startService(Intent paramIntent)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 1);
    return super.startService(paramIntent);
  }
  
  public void superOnCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */