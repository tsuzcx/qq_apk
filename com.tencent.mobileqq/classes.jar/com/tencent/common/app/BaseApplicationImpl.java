package com.tencent.common.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.format.Time;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PerfTracer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import pes;
import pet;

public class BaseApplicationImpl
  extends MobileQQ
{
  public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  public static boolean IS_SUPPORT_THEME = false;
  public static final int PROCESS_LOLA = 6;
  public static final int PROCESS_MSF = 4;
  public static final int PROCESS_NEARBY = 5;
  public static final int PROCESS_OTHER = -1;
  public static final int PROCESS_PEAK = 9;
  public static final int PROCESS_QQ = 1;
  public static final int PROCESS_TOOL = 7;
  public static final int PROCESS_VIDEO = 10;
  @Deprecated
  public static final int PROCESS_WEB = 3;
  public static final int PROCESS_ZONE = 2;
  public static final int PROCESS_ZONE_LIVE = 8;
  private static final String TAG = "BaseApplicationImpl";
  public static final String[] TOOL_PROCS = { ":tool", ":peak", ":qzone" };
  public static boolean appMainActivityHasLanuch = false;
  public static long appStartTime = 0L;
  public static final String bootBroadcastName = "com.tencent.mobileqq.broadcast.qq";
  public static boolean isCurrentVersionFirstLaunch;
  public static boolean isFirstLaunchNew;
  public static boolean isFirstLogin;
  public static BaseApplicationImpl sApplication;
  public static StartupDirector sDirector;
  public static String sFoo2Version;
  public static String sFooVersion;
  public static MQLruCache sImageCache;
  public static int sImageCacheSize;
  public static ConcurrentHashMap sImageHashMap;
  public static String sImmersiveUtilsEscapedMsg;
  public static boolean sIsBgStartup;
  public static long sLaunchTime;
  public static int sProcessId;
  public static String sPublicFragmentEscapedMsg;
  public static String sQQAppInterfaceEscapedMsg = "";
  public static long sShowTime;
  public static String sSplashActivityEscapedMsg = "";
  public static long sToolShowTime;
  public static MqqHandler sUiHandler;
  private Intent pcActiveNoticeIntent;
  private String pcactiveContent;
  private String pcactiveLButton;
  private String pcactiveRButton;
  private String pcactiveUin;
  
  static
  {
    sImmersiveUtilsEscapedMsg = "";
    sPublicFragmentEscapedMsg = "";
    sFooVersion = "";
    sFoo2Version = "";
    IS_SUPPORT_THEME = true;
    sProcessId = -1;
  }
  
  public BaseApplicationImpl()
  {
    buildNum = "3560";
    channelId = "2017";
    reportVersionName = "7.6.3.3560";
    APP_ID = AppSetting.a;
  }
  
  public static BaseApplicationImpl getApplication()
  {
    return sApplication;
  }
  
  public static String getLocalVerify(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    int i;
    if (paramBoolean)
    {
      i = localTime.minute - 1;
      localStringBuilder.append(i);
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      i = localTime.minute;
      break;
    }
  }
  
  public static boolean useQIPCStart(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = TOOL_PROCS;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.endsWith(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!bool1) {
          bool2 = paramString.endsWith(":smartdevice");
        }
        return bool2;
      }
      i += 1;
    }
  }
  
  public void addOtherTypeActivity(Activity paramActivity)
  {
    this.otherTypeActivitys.add(new WeakReference(paramActivity));
    StatisticCollector.a(this).a(paramActivity);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    paramContext = getProcessName();
    long l;
    label39:
    int j;
    int i;
    if ("com.tencent.mobileqq".equals(paramContext))
    {
      sProcessId = 1;
      com.tencent.qphone.base.util.BaseApplication.processName = paramContext;
      if (sProcessId != 1) {
        break label262;
      }
      l = 3000L;
      QLog.init("com.tencent.mobileqq", paramContext, "V 7.6.3.3560", l);
      j = TOOL_PROCS.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((processName != null) && (processName.endsWith(TOOL_PROCS[i]))) {
          MobileQQ.sIsToolProc = true;
        }
      }
      else
      {
        FontSettingManager.a(this, false, true);
        return;
        if (paramContext.endsWith("MSF"))
        {
          sProcessId = 4;
          break;
        }
        if (paramContext.endsWith("qzone"))
        {
          sProcessId = 2;
          break;
        }
        if (paramContext.endsWith("web"))
        {
          sProcessId = 3;
          break;
        }
        if (paramContext.endsWith("nearby"))
        {
          sProcessId = 5;
          break;
        }
        if (paramContext.endsWith("lola"))
        {
          sProcessId = 6;
          break;
        }
        if (paramContext.endsWith("tool"))
        {
          sProcessId = 7;
          sToolShowTime = SystemClock.uptimeMillis();
          break;
        }
        if (paramContext.endsWith("qzonelive"))
        {
          sProcessId = 8;
          break;
        }
        if (paramContext.endsWith("peak"))
        {
          sProcessId = 9;
          break;
        }
        if (paramContext.endsWith("video"))
        {
          sProcessId = 10;
          break;
        }
        sProcessId = -1;
        break;
        label262:
        l = 0L;
        break label39;
      }
      i += 1;
    }
  }
  
  public AppRuntime createRuntime(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AppRuntime localAppRuntime = peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (localAppRuntime.getLongAccountUin() > 10000L)) {
        ((QQAppInterface)localAppRuntime).A();
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
    if (paramString == null) {}
    while (!"channel_id".equals(paramString)) {
      return null;
    }
    return "2017";
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a;
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
    return waitAppRuntime(null);
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
  
  public boolean isNeedMSF(String paramString)
  {
    return (!paramString.endsWith("lola")) && (!paramString.endsWith("TMAssistantDownloadSDKService"));
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    if ((Build.VERSION.SDK_INT >= 24) && ((paramObject instanceof Activity))) {
      FontSettingManager.a((Activity)paramObject, true, false);
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
    if (sDirector != null) {
      sDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    FontSettingManager.b(this, true, true);
  }
  
  @TargetApi(15)
  public void onCreate()
  {
    if (sApplication != null) {}
    do
    {
      return;
      sApplication = this;
      sMobileQQ = this;
      context = this;
      SharedPreferencesProxyManager.getInstance().init(this);
      if (sProcessId == 2)
      {
        StartupDirector.b = true;
        PerfTracer.traceStart("App_onCreate");
      }
      sDirector = StartupDirector.a();
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(sInjectResult))) {
        registerActivityLifecycleCallbacks(new UEC());
      }
    } while (!StartupDirector.b);
    PerfTracer.traceEnd("App_onCreate");
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
    StatisticCollector.a(this).d(paramActivity);
  }
  
  public void reportPCActive(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(paramInt));
    localHashMap.put("param_uin", paramString);
    StatisticCollector.a(getApplication()).a(paramString, "PcActiveSucc", true, 0L, 0L, localHashMap, "", true);
    sUiHandler.postDelayed(new pes(this, paramInt, paramString), 10000L);
    ReportController.b(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    int j = 0;
    int i;
    if (paramIntent == null) {
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        doSendBroadcast(paramIntent);
      }
      return;
      String str = paramIntent.getAction();
      i = j;
      if (str != null) {
        if (!str.startsWith("com.tencent.process."))
        {
          i = j;
          if (!str.equals("com.tencent.qq.syncQQMessage")) {}
        }
        else
        {
          i = 1;
          ThreadManager.getSubThreadHandler().post(new pet(this, paramIntent));
        }
      }
    }
  }
  
  public void setPCActiveNotice(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pcactiveUin = paramString1;
    this.pcactiveContent = paramString2;
    this.pcactiveLButton = paramString3;
    this.pcactiveRButton = paramString4;
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      JumpActivity.a(paramIntent);
      super.startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      JumpActivity.a(paramIntent);
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void superOnCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */