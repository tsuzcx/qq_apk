import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.statistics.StatisticCollector.1;
import com.tencent.mobileqq.statistics.StatisticCollector.3;
import com.tencent.mobileqq.statistics.StatisticCollector.4;
import com.tencent.mobileqq.statistics.StatisticCollector.5;
import com.tencent.mobileqq.statistics.StatisticCollector.6;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bdmc
{
  static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static volatile bdmc jdField_a_of_type_Bdmc;
  public static bdmk a;
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static volatile long b;
  private static String jdField_b_of_type_JavaLangString;
  public static volatile boolean b;
  private static String c;
  public static boolean c;
  private static volatile boolean jdField_d_of_type_Boolean;
  private static volatile boolean e;
  private static boolean f;
  bdmg jdField_a_of_type_Bdmg = new bdmg();
  String jdField_a_of_type_JavaLangString = "999";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("DPC info:\n");
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private LinkedList<bdmf> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Stack<String> jdField_a_of_type_JavaUtilStack = new Stack();
  boolean jdField_a_of_type_Boolean = false;
  private bdmi[] jdField_a_of_type_ArrayOfBdmi = { new bdmi("com.tencent.mtt", "qqBrowser"), new bdmi("com.tencent.android.qqdownloader", "qqMarket"), new bdmi("com.tencent.qqgame", "qqGame"), new bdmi("com.tencent.qqmusic", "qqMusic"), new bdmi("com.tencent.news", "qqNews"), new bdmi("com.qq.reader", "qqReader"), new bdmi("com.tencent.qqlive", "qqVideo"), new bdmi("com.tencent.wblog", "qqMicroblog"), new bdmi("com.tencent.qqphonebook", "qqPhonebook") };
  private int jdField_b_of_type_Int;
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder = new StringBuilder("Thread info:\n");
  private String jdField_d_of_type_JavaLangString;
  
  protected bdmc(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private bdmc(Context paramContext, long paramLong)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    UserAction.setUserID("10000");
    UserAction.initUserAction(jdField_a_of_type_AndroidContentContext, false, paramLong);
    UserAction.setChannelID(AppSetting.c());
    e(paramContext);
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.getInt("version_patchlib_load", 0);
  }
  
  public static bdmc a(Context paramContext)
  {
    return a(paramContext, 3000L);
  }
  
  public static bdmc a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_Bdmc == null) {}
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Bdmc == null)
        {
          if (aodp.a()) {
            jdField_a_of_type_Bdmc = new bdmc(BaseApplicationImpl.getApplication(), paramLong);
          }
        }
        else if (jdField_a_of_type_Bdmc == null) {}
      }
      finally {}
      try
      {
        if ((aodp.a()) && ((jdField_a_of_type_Bdmc instanceof bdmh))) {
          jdField_a_of_type_Bdmc = new bdmc(BaseApplicationImpl.getApplication(), paramLong);
        }
        return jdField_a_of_type_Bdmc;
      }
      finally {}
      jdField_a_of_type_Bdmc = new bdmh(BaseApplicationImpl.getApplication());
    }
  }
  
  private static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", bhlo.d());
    localHashMap.put("param_manu", bhlo.k());
    localHashMap.put("param_OS", bhlo.e());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_IMEI", bhlo.a());
    localHashMap.put("param_IMSI", bhlo.b());
    localHashMap.put("param_NetworkType", "" + bhnv.b(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_ProductVersion", "" + AppSetting.a());
    localHashMap.put("param_CPU", bhlo.g());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(bhlo.e() / 1024L) + "kB");
    long[] arrayOfLong = bhlo.a();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = bhlo.b();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + bhlo.c());
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("version_patchlib_load", paramInt);
    if (paramInt > 0) {
      QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + paramInt);
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    QLog.d("StatisticCollector", 1, "stopServiceOnCrash");
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      QLog.d("StatisticCollector", 1, "stopServiceOnCrash,context == null");
    }
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject == null) || (((List)localObject).size() <= 0))
      {
        QLog.d("StatisticCollector", 1, "stopServiceOnCrash,list == null");
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
        if (paramString.equals(localRunningServiceInfo.process))
        {
          Intent localIntent = new Intent();
          localIntent.setComponent(localRunningServiceInfo.service);
          QLog.d("StatisticCollector", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
          paramContext.stopService(localIntent);
        }
      }
    }
  }
  
  public static void a(Context paramContext, StringBuilder paramStringBuilder)
  {
    Object localObject1 = bhvn.a("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)bhvn.a("android.app.LoadedApk", ((WeakReference)((Map)bhvn.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        localObject3 = (BroadcastReceiver)localObject3;
        paramStringBuilder.append(localObject3.getClass().getName() + ":" + localObject3);
        paramStringBuilder.append(" in ");
        paramStringBuilder.append(localObject2.getClass().getName() + ":" + localObject2);
      }
    }
  }
  
  public static void a(Map<String, String> paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  public static boolean a()
  {
    if ("8.4.5".startsWith("7.1.")) {}
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2;
    if (paramInt != 3)
    {
      bool2 = false;
      return bool2;
    }
    String[] arrayOfString2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SqlSampleCfg.name(), "250|5|5|1|50|5|5|25|25|25|5|10|10").split("\\|");
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2.length < 13) {
      arrayOfString1 = "250|5|5|1|50|5|5|25|25|25|5|10|10".split("\\|");
    }
    if (paramInt > arrayOfString1.length - 1) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(arrayOfString1[paramInt]).intValue();
        if (paramInt <= 0) {
          break label164;
        }
        if (jdField_a_of_type_JavaUtilRandom.nextInt(paramInt) == paramInt - 1)
        {
          bool1 = true;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StatisticCollector", 2, new Object[] { "getSqliteSwitchBySample value: ", Integer.valueOf(paramInt), " switch: ", Boolean.valueOf(bool1) });
          return bool1;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StatisticCollector", 2, "getSqliteSwitchBySample error", localException);
        }
        return false;
      }
      boolean bool1 = false;
      continue;
      label164:
      bool1 = false;
    }
  }
  
  private boolean a(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoUploadBDH".equals(paramString)) || ("actShortVideoDiscussgroupUploadBDH".equals(paramString)) || ("actShortVideoForwardBDH".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString)) || ("PicStatisticsManagerUploadPic".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((1 != BaseApplicationImpl.sProcessId) || (System.currentTimeMillis() - jdField_b_of_type_Long > 600000L)) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while ((!((SharedPreferences)localObject1).getBoolean("key_not_exit_enable", false)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    for (;;)
    {
      int i;
      int m;
      try
      {
        Object localObject2 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_type", null);
        localObject1 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_stack", null);
        if ((localObject2 == null) || (TextUtils.isEmpty(paramString1))) {
          break label314;
        }
        localObject2 = ((String)localObject2).split("\\|");
        k = localObject2.length;
        j = 0;
        i = 0;
        if (j >= k) {
          break label326;
        }
        Object localObject3 = localObject2[j];
        if (!paramString1.equals(localObject3)) {
          break label319;
        }
        QLog.e("StatisticCollector", 1, new Object[] { "crashType = ", paramString1, ",crash = ", localObject3 });
        i = 1;
      }
      catch (Throwable paramString1)
      {
        int k;
        int n;
        QLog.e("StatisticCollector", 1, "isNotExitSafeMode has some error", paramString1);
        return false;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString1 = ((String)localObject1).split("\\|");
        n = paramString1.length;
        k = 0;
        i = 0;
        m = i;
        if (k < n)
        {
          localObject1 = paramString1[k];
          if (paramString2.contains((CharSequence)localObject1))
          {
            QLog.e("StatisticCollector", 1, new Object[] { "crashStack = ", paramString2, ",crash = ", localObject1 });
            i = 1;
          }
          k += 1;
          continue;
        }
      }
      else
      {
        m = 0;
      }
      if ((m != 0) && (j != 0)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      label314:
      int j = 0;
      continue;
      label319:
      j += 1;
      continue;
      label326:
      j = i;
    }
  }
  
  private void c()
  {
    aaar.a().a();
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  @TargetApi(21)
  private static String d()
  {
    int i1 = 0;
    int m = 0;
    int i2 = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = i1;
    int k = i2;
    for (;;)
    {
      try
      {
        Object localObject1 = new File("/proc/self/fd");
        j = i1;
        int n = m;
        k = i2;
        if (((File)localObject1).exists())
        {
          j = i1;
          n = m;
          k = i2;
          if (((File)localObject1).isDirectory())
          {
            j = i1;
            k = i2;
            if (Build.VERSION.SDK_INT < 21) {
              break label345;
            }
            m = 1;
            j = i1;
            k = i2;
            File[] arrayOfFile = ((File)localObject1).listFiles();
            j = i1;
            k = i2;
            i2 = arrayOfFile.length;
            i1 = 0;
            n = i;
            if (i1 < i2)
            {
              localObject1 = arrayOfFile[i1];
              if (m != 0) {
                k = i;
              }
              try
              {
                localObject1 = Os.readlink(((File)localObject1).getPath());
                k = i;
                localStringBuilder.append((String)localObject1 + "\n");
                i += 1;
              }
              catch (Throwable localThrowable1)
              {
                j = i;
                k = i;
                QLog.e("StatisticCollector", 1, "readlink failed", localThrowable1);
              }
              k = i;
              localObject1 = ((File)localObject1).getCanonicalPath();
              continue;
            }
          }
        }
        localStringBuilder.append("Total FD Count = " + k);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2 = localThrowable2;
        try
        {
          QLog.e("StatisticCollector", 1, "get fd info failed !!!", localThrowable2);
          localStringBuilder.append("Total FD Count = " + j);
          return localStringBuilder.toString();
        }
        finally
        {
          for (;;)
          {
            k = j;
          }
        }
        localStringBuilder.append("Total FD Count = " + n);
        return localStringBuilder.toString();
      }
      finally {}
      return localStringBuilder.toString();
      i1 += 1;
      continue;
      label345:
      m = 0;
    }
  }
  
  private static boolean d()
  {
    if (Build.VERSION.SDK_INT == 27) {}
    for (int i = 1; (i != 0) && (Build.MODEL.contains("OPPO R11")); i = 0) {
      return true;
    }
    return false;
  }
  
  private void e(Context paramContext) {}
  
  public static void e(String paramString)
  {
    a(BaseApplication.getContext()).a(null, paramString, true, 0L, 0L, null, null);
  }
  
  void a()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.jdField_a_of_type_Bdmg.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("control_switch");
      this.jdField_a_of_type_Bdmg.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("control_level");
      this.jdField_a_of_type_Bdmg.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("control_window");
      this.jdField_a_of_type_Bdmg.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.jdField_a_of_type_JavaLangStringBuilder.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.jdField_a_of_type_Bdmg.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",level=").append(this.jdField_a_of_type_Bdmg.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",window=").append(this.jdField_a_of_type_Bdmg.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(",Freq=").append(this.jdField_a_of_type_Bdmg.c);
      this.jdField_a_of_type_JavaLangStringBuilder.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.jdField_a_of_type_Bdmg.a();
        QLog.d("StatisticCollector", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.push(paramContext);
      c("onCreate", paramContext);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      UserAction.setUserID(paramString);
      CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      long l1;
      int j;
      boolean bool3;
      boolean bool2;
      int i;
      long l2;
      try
      {
        SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("not_restart_control_file", 4);
        if ((localSharedPreferences == null) || (paramString1 == null) || (paramString2 == null)) {
          break;
        }
        l1 = localSharedPreferences.getLong("starttime", 0L);
        int k = localSharedPreferences.getInt("crashcount", 0);
        j = localSharedPreferences.getInt("key_not_restart_max_crash", 2147483647);
        bool3 = localSharedPreferences.getBoolean("key_not_restart_enable", false);
        String str1 = localSharedPreferences.getString("key_not_restart_crash_type", "notValid");
        String str2 = localSharedPreferences.getString("key_not_restart_crash_stack", "notValid");
        if (paramString1.isEmpty())
        {
          bool1 = false;
          if (paramString2.isEmpty())
          {
            bool2 = false;
            break label311;
            if (i == 0) {
              break;
            }
            l2 = System.currentTimeMillis();
            if ((l1 <= 0L) || (l2 <= l1) || (k < 0)) {
              break label331;
            }
            if (l2 - l1 <= 86400000L) {
              continue;
            }
            break label331;
            QLog.e("StatisticCollector", 1, "crashCount = " + i + ",allowAutoRestart = " + bool1);
            localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowAutoRestart", bool1).commit();
          }
        }
        else
        {
          bool1 = paramString1.equalsIgnoreCase(str1);
          continue;
        }
        bool2 = paramString2.contains(str2);
        break label311;
        i = 0;
        continue;
        i = k + 1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("StatisticCollector", 1, "updateNotRestartData error", paramString1);
        return;
      }
      boolean bool1 = true;
      continue;
      label311:
      if ((bool3) && (bool1) && (bool2))
      {
        i = 1;
        continue;
        label331:
        i = 1;
        l1 = l2;
        if (i > j) {
          bool1 = false;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString4, false, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!aodp.a()) {
      return;
    }
    adkq.a(paramString3, paramHashMap);
    if (paramString2 == null) {
      paramString2 = "10000";
    }
    for (;;)
    {
      paramString4 = paramString2;
      if (paramString2 != null)
      {
        paramString4 = paramString2;
        if (paramString2.length() < 1) {
          paramString4 = "10000";
        }
      }
      UserAction.setUserID(paramString4);
      if (paramHashMap == null)
      {
        paramString2 = new HashMap();
        if (paramString2 != null) {
          paramString2.put("param_ProductVersion", "" + AppSetting.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "event report: " + paramString3 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString2.containsKey("param_FailCode")) || ("".equals(paramString2.get("param_FailCode"))))) {
          paramString2.put("param_FailCode", String.valueOf(0));
        }
        paramHashMap = new RdmReq();
        paramHashMap.eventName = paramString3;
        paramHashMap.elapse = paramLong1;
        paramHashMap.size = paramLong2;
        paramHashMap.isSucceed = paramBoolean1;
        paramHashMap.isRealTime = paramBoolean2;
        paramHashMap.appKey = paramString1;
        paramHashMap.isImmediatelyUpload = paramBoolean3;
        if (a(paramString3))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        paramHashMap.params = paramString2;
        try
        {
          paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
          paramString1.setAppId(AppSetting.a());
          paramString1.setTimeout(30000L);
          ThreadManager.post(new StatisticCollector.6(this, paramString1), 5, null, true);
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
      }
      paramString2 = new HashSet();
      paramString2.addAll(paramHashMap.keySet());
      paramString4 = paramString2.iterator();
      for (;;)
      {
        paramString2 = paramHashMap;
        if (!paramString4.hasNext()) {
          break;
        }
        paramString2 = (String)paramString4.next();
        if ((String)paramHashMap.get(paramString2) == null) {
          paramHashMap.put(paramString2, "");
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    a("", paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    a("", paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2, false);
  }
  
  /* Error */
  public void a(StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 115	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 1005
    //   10: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 1010	android/os/Process:myPid	()I
    //   16: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 1012
    //   22: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload_1
    //   31: ldc_w 1014
    //   34: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1016
    //   40: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 5
    //   53: invokestatic 655	java/lang/System:currentTimeMillis	()J
    //   56: lstore_3
    //   57: aload 8
    //   59: astore 7
    //   61: aload 9
    //   63: astore 6
    //   65: new 725	java/io/File
    //   68: dup
    //   69: aload 11
    //   71: invokespecial 728	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 1020	java/io/File:list	()[Ljava/lang/String;
    //   77: astore 10
    //   79: aload 8
    //   81: astore 7
    //   83: aload 9
    //   85: astore 6
    //   87: new 126	java/util/HashMap
    //   90: dup
    //   91: invokespecial 910	java/util/HashMap:<init>	()V
    //   94: astore 8
    //   96: iconst_0
    //   97: istore_2
    //   98: aload 5
    //   100: astore 7
    //   102: aload 5
    //   104: astore 6
    //   106: iload_2
    //   107: aload 10
    //   109: arraylength
    //   110: if_icmpge +120 -> 230
    //   113: aload 5
    //   115: astore 7
    //   117: aload 5
    //   119: astore 6
    //   121: new 725	java/io/File
    //   124: dup
    //   125: new 115	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   132: aload 11
    //   134: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 1022
    //   140: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 10
    //   145: iload_2
    //   146: aaload
    //   147: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 1024
    //   153: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 728	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 9
    //   164: aload 5
    //   166: astore 7
    //   168: aload 5
    //   170: astore 6
    //   172: invokestatic 655	java/lang/System:currentTimeMillis	()J
    //   175: lload_3
    //   176: lsub
    //   177: ldc2_w 1025
    //   180: lcmp
    //   181: ifle +188 -> 369
    //   184: aload 5
    //   186: astore 7
    //   188: aload 5
    //   190: astore 6
    //   192: invokestatic 535	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +35 -> 230
    //   198: aload 5
    //   200: astore 7
    //   202: aload 5
    //   204: astore 6
    //   206: ldc_w 327
    //   209: iconst_2
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 1028
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 550	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: aload 5
    //   232: astore 7
    //   234: aload 5
    //   236: astore 6
    //   238: aload 8
    //   240: invokevirtual 1031	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   243: invokeinterface 456 1 0
    //   248: astore 8
    //   250: aload 5
    //   252: astore 7
    //   254: aload 5
    //   256: astore 6
    //   258: aload 8
    //   260: invokeinterface 369 1 0
    //   265: ifeq +274 -> 539
    //   268: aload 5
    //   270: astore 7
    //   272: aload 5
    //   274: astore 6
    //   276: aload 8
    //   278: invokeinterface 373 1 0
    //   283: checkcast 1033	java/util/Map$Entry
    //   286: astore 9
    //   288: aload 5
    //   290: astore 7
    //   292: aload 5
    //   294: astore 6
    //   296: aload_1
    //   297: aload 9
    //   299: invokeinterface 1036 1 0
    //   304: checkcast 282	java/lang/String
    //   307: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 1038
    //   313: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 9
    //   318: invokeinterface 1041 1 0
    //   323: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   326: ldc_w 1043
    //   329: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 1045
    //   335: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: goto -89 -> 250
    //   342: astore_1
    //   343: aload 7
    //   345: astore 6
    //   347: ldc_w 327
    //   350: iconst_2
    //   351: ldc_w 1047
    //   354: aload_1
    //   355: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: aload 7
    //   360: ifnull +8 -> 368
    //   363: aload 7
    //   365: invokevirtual 1052	java/io/BufferedReader:close	()V
    //   368: return
    //   369: aload 5
    //   371: astore 7
    //   373: aload 5
    //   375: astore 6
    //   377: aload 9
    //   379: invokevirtual 731	java/io/File:exists	()Z
    //   382: ifeq +364 -> 746
    //   385: aload 5
    //   387: astore 7
    //   389: aload 5
    //   391: astore 6
    //   393: new 1049	java/io/BufferedReader
    //   396: dup
    //   397: new 1054	java/io/FileReader
    //   400: dup
    //   401: aload 9
    //   403: invokespecial 1057	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   406: bipush 64
    //   408: invokespecial 1060	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   411: astore 5
    //   413: aload 5
    //   415: invokevirtual 1063	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   418: astore 6
    //   420: aload 6
    //   422: ifnull +327 -> 749
    //   425: aload 6
    //   427: ldc_w 1065
    //   430: invokevirtual 492	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   433: ifeq -20 -> 413
    //   436: aload 6
    //   438: ldc_w 469
    //   441: invokevirtual 520	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   444: iconst_1
    //   445: aaload
    //   446: invokevirtual 1068	java/lang/String:trim	()Ljava/lang/String;
    //   449: astore 6
    //   451: aload 8
    //   453: aload 6
    //   455: invokevirtual 919	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   458: ifeq +49 -> 507
    //   461: aload 8
    //   463: aload 6
    //   465: aload 8
    //   467: aload 6
    //   469: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: checkcast 522	java/lang/Integer
    //   475: invokevirtual 528	java/lang/Integer:intValue	()I
    //   478: iconst_1
    //   479: iadd
    //   480: invokestatic 540	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: invokevirtual 720	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: pop
    //   487: aload 5
    //   489: ifnull +47 -> 536
    //   492: aload 5
    //   494: invokevirtual 1052	java/io/BufferedReader:close	()V
    //   497: aconst_null
    //   498: astore 5
    //   500: iload_2
    //   501: iconst_1
    //   502: iadd
    //   503: istore_2
    //   504: goto -406 -> 98
    //   507: aload 8
    //   509: aload 6
    //   511: iconst_1
    //   512: invokestatic 540	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: invokevirtual 720	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: goto -32 -> 487
    //   522: astore 6
    //   524: ldc_w 327
    //   527: iconst_2
    //   528: ldc_w 1047
    //   531: aload 6
    //   533: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: goto -36 -> 500
    //   539: aload 5
    //   541: astore 7
    //   543: aload 5
    //   545: astore 6
    //   547: aload_1
    //   548: ldc_w 1070
    //   551: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 10
    //   556: arraylength
    //   557: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 5
    //   563: astore 7
    //   565: aload 5
    //   567: astore 6
    //   569: invokestatic 1075	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   572: ifeq +36 -> 608
    //   575: aload 5
    //   577: astore 7
    //   579: aload 5
    //   581: astore 6
    //   583: aload 10
    //   585: arraylength
    //   586: sipush 200
    //   589: if_icmple +19 -> 608
    //   592: aload 5
    //   594: astore 7
    //   596: aload 5
    //   598: astore 6
    //   600: aload_1
    //   601: invokestatic 1078	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   604: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 5
    //   610: astore 7
    //   612: aload 5
    //   614: astore 6
    //   616: invokestatic 535	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +52 -> 671
    //   622: aload 5
    //   624: astore 7
    //   626: aload 5
    //   628: astore 6
    //   630: ldc_w 327
    //   633: iconst_2
    //   634: iconst_4
    //   635: anewarray 4	java/lang/Object
    //   638: dup
    //   639: iconst_0
    //   640: ldc_w 1080
    //   643: aastore
    //   644: dup
    //   645: iconst_1
    //   646: invokestatic 655	java/lang/System:currentTimeMillis	()J
    //   649: lload_3
    //   650: lsub
    //   651: invokestatic 1085	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   654: aastore
    //   655: dup
    //   656: iconst_2
    //   657: ldc_w 1087
    //   660: aastore
    //   661: dup
    //   662: iconst_3
    //   663: aload_1
    //   664: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: aastore
    //   668: invokestatic 550	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   671: aload 5
    //   673: ifnull -305 -> 368
    //   676: aload 5
    //   678: invokevirtual 1052	java/io/BufferedReader:close	()V
    //   681: return
    //   682: astore_1
    //   683: ldc_w 327
    //   686: iconst_2
    //   687: ldc_w 1047
    //   690: aload_1
    //   691: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   694: return
    //   695: astore_1
    //   696: ldc_w 327
    //   699: iconst_2
    //   700: ldc_w 1047
    //   703: aload_1
    //   704: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   707: return
    //   708: astore_1
    //   709: aload 6
    //   711: ifnull +8 -> 719
    //   714: aload 6
    //   716: invokevirtual 1052	java/io/BufferedReader:close	()V
    //   719: aload_1
    //   720: athrow
    //   721: astore 5
    //   723: ldc_w 327
    //   726: iconst_2
    //   727: ldc_w 1047
    //   730: aload 5
    //   732: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   735: goto -16 -> 719
    //   738: astore_1
    //   739: aload 5
    //   741: astore 6
    //   743: goto -34 -> 709
    //   746: goto -246 -> 500
    //   749: aconst_null
    //   750: astore 6
    //   752: goto -301 -> 451
    //   755: astore_1
    //   756: aload 5
    //   758: astore 7
    //   760: goto -417 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	bdmc
    //   0	763	1	paramStringBuilder	StringBuilder
    //   97	407	2	i	int
    //   56	594	3	l	long
    //   51	626	5	localBufferedReader	java.io.BufferedReader
    //   721	36	5	localIOException1	java.io.IOException
    //   63	447	6	localObject1	Object
    //   522	10	6	localIOException2	java.io.IOException
    //   545	206	6	localObject2	Object
    //   59	700	7	localObject3	Object
    //   45	463	8	localObject4	Object
    //   48	354	9	localObject5	Object
    //   77	507	10	arrayOfString	String[]
    //   28	105	11	str	String
    // Exception table:
    //   from	to	target	type
    //   65	79	342	java/lang/Exception
    //   87	96	342	java/lang/Exception
    //   106	113	342	java/lang/Exception
    //   121	164	342	java/lang/Exception
    //   172	184	342	java/lang/Exception
    //   192	198	342	java/lang/Exception
    //   206	230	342	java/lang/Exception
    //   238	250	342	java/lang/Exception
    //   258	268	342	java/lang/Exception
    //   276	288	342	java/lang/Exception
    //   296	339	342	java/lang/Exception
    //   377	385	342	java/lang/Exception
    //   393	413	342	java/lang/Exception
    //   547	561	342	java/lang/Exception
    //   569	575	342	java/lang/Exception
    //   583	592	342	java/lang/Exception
    //   600	608	342	java/lang/Exception
    //   616	622	342	java/lang/Exception
    //   630	671	342	java/lang/Exception
    //   492	497	522	java/io/IOException
    //   676	681	682	java/io/IOException
    //   363	368	695	java/io/IOException
    //   65	79	708	finally
    //   87	96	708	finally
    //   106	113	708	finally
    //   121	164	708	finally
    //   172	184	708	finally
    //   192	198	708	finally
    //   206	230	708	finally
    //   238	250	708	finally
    //   258	268	708	finally
    //   276	288	708	finally
    //   296	339	708	finally
    //   347	358	708	finally
    //   377	385	708	finally
    //   393	413	708	finally
    //   547	561	708	finally
    //   569	575	708	finally
    //   583	592	708	finally
    //   600	608	708	finally
    //   616	622	708	finally
    //   630	671	708	finally
    //   714	719	721	java/io/IOException
    //   413	420	738	finally
    //   425	451	738	finally
    //   451	487	738	finally
    //   492	497	738	finally
    //   507	519	738	finally
    //   524	536	738	finally
    //   413	420	755	java/lang/Exception
    //   425	451	755	java/lang/Exception
    //   451	487	755	java/lang/Exception
    //   492	497	755	java/lang/Exception
    //   507	519	755	java/lang/Exception
    //   524	536	755	java/lang/Exception
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (f) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
    } while (l2 < l1);
    f = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    f = false;
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    a(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    String str = paramString4;
    if (paramString4 == null) {
      str = "0";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  void b()
  {
    if (!this.jdField_a_of_type_Bdmg.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().startComponentInfo;
      if ((this.jdField_a_of_type_Bdmg.jdField_a_of_type_Int == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("StatisticCollector", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",mCurUin=").append(this.jdField_a_of_type_JavaLangString).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Bdmg.jdField_b_of_type_Int * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Bdmg.c)
      {
        this.jdField_a_of_type_Boolean = true;
        if (d()) {
          ((SharedPreferences)localObject).edit().putBoolean("crashFrequentLast", true).commit();
        }
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData shouldStopMsf=").append(this.jdField_a_of_type_Boolean).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("shouldStopMsf", this.jdField_a_of_type_Boolean).commit();
      return;
      i += 1;
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null) {
      c("onResume", paramContext.toString());
    }
  }
  
  void b(String paramString)
  {
    boolean bool1 = true;
    if (!this.jdField_a_of_type_Bdmg.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.jdField_a_of_type_JavaLangString).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Bdmg.jdField_b_of_type_Int * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Bdmg.c) {
        bool1 = false;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool1).putInt("controlwindow", this.jdField_a_of_type_Bdmg.jdField_b_of_type_Int).commit();
      return;
      i += 1;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new bdmf(System.currentTimeMillis(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
      int i = this.jdField_b_of_type_Int;
      for (this.jdField_b_of_type_Int = (paramString1.jdField_a_of_type_Int + i); (this.jdField_b_of_type_Int > 15360L) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1); this.jdField_b_of_type_Int -= paramString1.jdField_a_of_type_Int) {
        paramString1 = (bdmf)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      }
    }
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    a(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), bcvz.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void c(Context paramContext)
  {
    if (paramContext != null) {
      c("onPause", paramContext.toString());
    }
  }
  
  public void c(String paramString)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaLangString = paramString;
    CrashReport.setLogAble(false, false);
    Object localObject = new CrashStrategyBean();
    ((CrashStrategyBean)localObject).setUploadSpotCrash(false);
    ((CrashStrategyBean)localObject).setMaxStackFrame(6);
    QLog.d("StatisticCollector", 1, "initCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
    if (BaseApplicationImpl.processName.endsWith(":qzone")) {
      ThreadManager.executeOnSubThread(new StatisticCollector.1(this));
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    }
    CrashReport.initCrashReport(jdField_a_of_type_AndroidContentContext, new bdmd(this), null, bool, (CrashStrategyBean)localObject, 30000L);
    try
    {
      localObject = jdField_a_of_type_AndroidContentContext.getDir("tombs", 0).getAbsolutePath();
      QLog.d("StatisticCollector", 1, "initNativeCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
      CrashReport.initNativeCrashReport(jdField_a_of_type_AndroidContentContext, (String)localObject, false, null, null, 0L);
      CrashReport.filterSysLog(true, true);
      QLog.d("StatisticCollector", 1, "CrashReport init finished.");
      ANRReport.stopANRMonitor();
      CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(jdField_a_of_type_AndroidContentContext)));
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(jdField_a_of_type_AndroidContentContext)));
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "PatchInstallStatus", String.valueOf(acyx.jdField_a_of_type_Int));
      if (!TextUtils.isEmpty(acyx.jdField_a_of_type_JavaLangString)) {
        CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "PatchNameInstalled", acyx.jdField_a_of_type_JavaLangString);
      }
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "Revision", AppSetting.g());
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "Version.buildNum", "8.4.5.4745");
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "AboutSubVersionLog", AppSetting.b());
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "appid", String.valueOf(AppSetting.a()));
      CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "topActivity", aodx.a());
      this.jdField_b_of_type_JavaLangStringBuilder.append("Current process id=").append(Process.myPid()).append(", Name=").append(BaseApplicationImpl.processName).append("\n");
      jdField_b_of_type_Long = System.currentTimeMillis();
      if (1 == BaseApplicationImpl.sProcessId)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.3(this, paramString), 3000L);
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.4(this), 180000L);
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.5(this), 600000L);
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e("StatisticCollector", 1, "initNativeCrashReport error", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.remove(paramContext);
      c("onDestroy", paramContext);
    }
  }
  
  public void d(String paramString)
  {
    Map localMap = a();
    if ((paramString == null) || (localMap == null)) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)localMap.get(str) == null) {
        localMap.put(str, "");
      }
    }
    UserAction.setUserID(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "report End_Info:" + localMap.toString());
    }
    paramString = new RdmReq();
    paramString.eventName = "End_Info";
    paramString.elapse = -1L;
    paramString.size = 0L;
    paramString.isSucceed = true;
    paramString.isRealTime = true;
    paramString.isMerge = false;
    paramString.params = localMap;
    try
    {
      paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString);
      paramString.setAppId(AppSetting.a());
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdmc
 * JD-Core Version:    0.7.0.1
 */