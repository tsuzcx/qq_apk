package com.tencent.common.app;

import abeo;
import abep;
import abeq;
import abet;
import abev;
import abew;
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
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import anll;
import anpe;
import aoif;
import aqlj;
import aqrq;
import auxf;
import awhg;
import bcow;
import bcst;
import bcta;
import bctj;
import bkgr;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
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
  public static boolean IS_SUPPORT_THEME = false;
  public static final int PROCESS_AV_GAME = 12;
  public static final int PROCESS_LOLA = 6;
  public static final int PROCESS_MINI = 11;
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
  private static volatile abep sAppRuntimeFactory;
  public static BaseApplicationImpl sApplication;
  public static bcow sDirector;
  public static String sFoo2Version;
  public static String sFooVersion;
  private static boolean sHasStoragePermission;
  public static MQLruCache<String, Object> sImageCache;
  public static int sImageCacheSize;
  public static ConcurrentHashMap<String, Bitmap> sImageHashMap;
  public static String sImmersiveUtilsEscapedMsg;
  public static boolean sIsBgStartup;
  public static long sLaunchTime;
  public static String sNativeMonitorEscapedMsg;
  public static int sProcessId;
  public static String sPublicFragmentEscapedMsg;
  public static String sQQAppInterfaceEscapedMsg = "";
  public static long sShowTime;
  public static String sSplashActivityEscapedMsg = "";
  public static long sToolShowTime;
  public static MqqHandler sUiHandler;
  private MSFInterfaceAdapter mMSFInterfaceAdapter;
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
    sAppRuntimeFactory = new abeq();
    sProcessId = -1;
  }
  
  public BaseApplicationImpl()
  {
    buildNum = "4680";
    reportVersionName = "8.4.1.4680";
  }
  
  private void attachThreadContext()
  {
    com.tencent.mobileqq.app.ThreadSetting.isPublicVersion = true;
    com.tencent.mobileqq.app.ThreadSetting.isGrayVersion = false;
    com.tencent.mobileqq.app.ThreadSetting.revision = "2703aac4";
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
  
  public static String getLogExternalPath(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!isHasStoragePermission(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label46;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
        {
          sHasStoragePermission = true;
          bool1 = sHasStoragePermission;
        }
      }
    }
    return bool1;
    label46:
    sHasStoragePermission = true;
    return sHasStoragePermission;
  }
  
  public static void setAppRuntimeFactory(abep paramabep)
  {
    sAppRuntimeFactory = paramabep;
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
    bctj.a(this).a(paramActivity);
  }
  
  public void attachBaseContext(Context paramContext)
  {
    l = 3000L;
    super.attachBaseContext(paramContext);
    str1 = getQQProcessName();
    if ("com.tencent.mobileqq".equals(str1))
    {
      sProcessId = 1;
      com.tencent.qphone.base.util.BaseApplication.processName = str1;
      attachThreadContext();
    }
    for (;;)
    {
      try
      {
        if (sProcessId != 1) {
          continue;
        }
        localaqrq = aqlj.a(this);
        localFile = new File(getLogExternalPath(context) + "/tencent/msflogs/" + getPackageName().replace(".", "/") + "/" + "QLogConfig_C");
        Log.d("init_log", "base=" + localaqrq.toString() + " logConfigPath=" + localFile.getAbsolutePath());
        if ((localaqrq.a()) || (localFile.exists())) {
          continue;
        }
        localFile.createNewFile();
        QLog.init("com.tencent.mobileqq", str1, AppSetting.a, 3000L);
      }
      catch (Throwable localThrowable)
      {
        aqrq localaqrq;
        File localFile;
        int j;
        int i;
        String str2 = AppSetting.a;
        if (sProcessId != 1) {
          continue;
        }
        QLog.init("com.tencent.mobileqq", str1, str2, l);
        continue;
        QLog.init("com.tencent.mobileqq", str1, AppSetting.a, 0L);
        continue;
        l = 0L;
        continue;
        i += 1;
        continue;
      }
      j = TOOL_PROCS.length;
      i = 0;
      if (i < j)
      {
        if ((processName == null) || (!processName.endsWith(TOOL_PROCS[i]))) {
          continue;
        }
        MobileQQ.sIsToolProc = true;
      }
      anpe.a(this);
      aoif.a().a(paramContext);
      anll.a(this, false, true);
      return;
      if (str1.endsWith("MSF"))
      {
        sProcessId = 4;
        break;
      }
      if (str1.endsWith("qzone"))
      {
        sProcessId = 2;
        break;
      }
      if (str1.endsWith("web"))
      {
        sProcessId = 3;
        break;
      }
      if (str1.endsWith("nearby"))
      {
        sProcessId = 5;
        break;
      }
      if (str1.endsWith("lola"))
      {
        sProcessId = 6;
        break;
      }
      if (str1.endsWith("tool"))
      {
        sProcessId = 7;
        sToolShowTime = SystemClock.uptimeMillis();
        break;
      }
      if (str1.endsWith("qzonelive"))
      {
        sProcessId = 8;
        break;
      }
      if (str1.endsWith("peak"))
      {
        sProcessId = 9;
        break;
      }
      if (str1.endsWith("video"))
      {
        sProcessId = 10;
        break;
      }
      if (str1.endsWith("miniapp"))
      {
        sProcessId = 11;
        break;
      }
      if (str1.endsWith("avgame"))
      {
        sProcessId = 12;
        break;
      }
      sProcessId = -1;
      break;
      if ((localaqrq.a()) && (localFile.exists())) {
        localFile.delete();
      }
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
        ((QQAppInterface)localAppRuntime).C();
      }
    }
    return abeo.a(this, paramString);
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
    return AppSetting.c();
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
    if (this.mMSFInterfaceAdapter == null) {}
    try
    {
      if (this.mMSFInterfaceAdapter == null) {
        this.mMSFInterfaceAdapter = new abet();
      }
      return this.mMSFInterfaceAdapter;
    }
    finally {}
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
  
  @NonNull
  public List<TunnelInfo> getRegisterBeaconTunnel()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TunnelInfo("00000ARN3S3S9UE8"));
    localArrayList.add(new TunnelInfo("00000GODBG3702Y1"));
    localArrayList.add(new TunnelInfo("00000U7O8S3BLETM"));
    localArrayList.add(new TunnelInfo("000004B5DU3Q3LD1"));
    localArrayList.add(new TunnelInfo("00000TEDPU36RWUZ"));
    localArrayList.add(new TunnelInfo("00000VCDPV3YVLO1"));
    return localArrayList;
  }
  
  public AppRuntime getRuntime()
  {
    abep localabep = sAppRuntimeFactory;
    if (localabep != null) {
      return localabep.a(this);
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
  
  public boolean isNeedMSF(String paramString)
  {
    return (!paramString.endsWith("lola")) && (!paramString.endsWith("TMAssistantDownloadSDKService"));
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    if ((paramObject instanceof Activity))
    {
      aoif.a().a((Activity)paramObject);
      anpe.b((Activity)paramObject);
    }
    if ((Build.VERSION.SDK_INT >= 24) && ((paramObject instanceof Activity))) {
      anll.a((Activity)paramObject, true, false);
    }
    if (sProcessId == 1) {
      abev.a(context, paramObject);
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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BaseApplicationImpl onConfigurationChanged called, localeInfo1:");
      if (paramConfiguration == null) {
        break label275;
      }
      localStringBuilder.append("\n").append("newConfig#Locale:").append(paramConfiguration.locale.toString());
    }
    for (;;)
    {
      if (sApplication != null)
      {
        localStringBuilder.append("\n").append("sApplication#Locale pre:");
        localStringBuilder.append(sApplication.getResources().getConfiguration().locale.toString());
      }
      if (sMobileQQ != null)
      {
        localStringBuilder.append("\n").append("sMobileQQ#Locale pre:");
        localStringBuilder.append(sMobileQQ.getResources().getConfiguration().locale.toString());
      }
      anpe.a(localStringBuilder.toString());
      super.onConfigurationChanged(paramConfiguration);
      anpe.a(this, anpe.a());
      anll.b(this, true, true);
      if (QLog.isColorLevel())
      {
        paramConfiguration = new StringBuilder();
        paramConfiguration.append("BaseApplicationImpl onConfigurationChanged called, localeInfo2:");
        if (sApplication != null)
        {
          paramConfiguration.append("\n").append("sApplication#Locale end:");
          paramConfiguration.append(sApplication.getResources().getConfiguration().locale.toString());
        }
        if (sMobileQQ != null)
        {
          paramConfiguration.append("\n").append("sMobileQQ#Locale end:");
          paramConfiguration.append(sMobileQQ.getResources().getConfiguration().locale.toString());
        }
        if (!TextUtils.isEmpty(paramConfiguration.toString())) {
          anpe.a(paramConfiguration.toString());
        }
      }
      return;
      label275:
      localStringBuilder.append("\n").append("newConfig is null");
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
    SharedPreferencesProxyManager.getInstance().init(this);
    if (bcta.a) {
      SharedPreferencesProxyManager.setLogCallback(bcta.a());
    }
    if (sProcessId == 2)
    {
      bcow.b = true;
      PerfTracer.traceStart("App_onCreate");
    }
    sDirector = bcow.a();
    if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(sInjectResult))) {
      registerActivityLifecycleCallbacks(UEC.a());
    }
    if (bcow.b) {
      PerfTracer.traceEnd("App_onCreate");
    }
    ThirdAppReportHelper.sThirdAppReporter = new abew();
    bkgr localbkgr = new bkgr();
    NotificationReportUtil.setReport(localbkgr);
    awhg.a(localbkgr);
    setupMultiLanguage();
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
    bctj.a(this).d(paramActivity);
  }
  
  public void reportPCActive(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(paramInt));
    localHashMap.put("param_uin", paramString);
    bctj.a(getApplication()).a(paramString, "PcActiveSucc", true, 0L, 0L, localHashMap, "", true);
    sUiHandler.postDelayed(new BaseApplicationImpl.3(this, paramInt, paramString), 10000L);
    bcst.b(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
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
          ThreadManager.getSubThreadHandler().post(new BaseApplicationImpl.4(this, paramIntent));
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
  
  protected void setupMultiLanguage()
  {
    aoif.a().b(this);
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      JumpActivity.g(paramIntent);
      try
      {
        auxf.a(this, paramIntent, new BaseApplicationImpl.1(this, paramIntent));
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
      JumpActivity.g(paramIntent);
      try
      {
        auxf.a(this, paramIntent, new BaseApplicationImpl.2(this, paramIntent, paramBundle));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */