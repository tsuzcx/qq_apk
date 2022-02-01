package com.tencent.mobileqq.app;

import aaux;
import aavb;
import acyc;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import anvu;
import aoam;
import bdlm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class MemoryManager
{
  private static final byte ACTION_MEMORY_ALERT_CHECK = 1;
  private static final byte ACTION_MEMORY_ALERT_CLEAR = 2;
  public static final String ACTION_QQPROCESS_EXIT = "com.tencent.process.exit";
  private static final String HEAP_LEVEL_LAST_REPORT_TIME = "HeapLevelReportLastTime";
  private static final String KEY_ENABLE_SUCIDE_AB_TEST = "en_sucide_ab";
  private static final String KEY_GUARD_TYPE = "guard_type";
  private static final String KEY_HEAP_SIZE = "heap_size";
  private static final String KEY_LEAK_ACTIVITY_COUNT = "leak_actvity_count";
  private static final String KEY_LEAK_BEFORE_OOM_SUCIDE_COUNT = "oom_scid_count";
  private static final String KEY_LEAK_ENABLE_SUCIDE_HEAP = "enable_sucide_heap_new";
  private static final String KEY_LEAK_ENABLE_SUCIDE_HEAP_OLD = "enable_sucide_heap";
  private static final String KEY_LEAK_HEAP_FREE = "heap_free";
  private static final String KEY_LEAK_HEAP_LEVAL = "heap_level";
  private static final String KEY_LEAK_HEAP_MAX = "heap_max";
  private static final String KEY_LEAK_HEAP_TOTAL = "heap_total";
  private static final String KEY_LEAK_OTHER_COUNT = "leak_other_count";
  private static final String KEY_LEAK_QQAPP_COUNT = "leak_qqapp_count";
  private static final String KEY_LEAK_SYS_PSS = "sys_pss";
  private static final String KEY_LEAK_SYS_TOTAL = "sys_total";
  private static final String KEY_MEM_USAGE = "key_mem_usg";
  private static final String KEY_ORG_HEAP_MAX = "heap_org_max";
  private static final String KEY_TOP_ACTIVITY = "key_top_act";
  private static final long ONE_M_SIZE = 1048576L;
  private static final String PREF_HEAP_LEVEL = "pref_heap_level";
  private static final String PREF_OOM = "pref_oom";
  private static final String REPORT_HEAP_LEVLE = "HeapLevel";
  public static final String SETTING_MEMORY_ALERT_AUTO_CLEAR = "MemoryAlertAutoClear";
  public static final String SP_MEMORY_NAME = "MemoryManagerMemoryStat";
  public static final String START_MODE_BG_GUARD = "BG_GUARD";
  public static final String START_MODE_LITE_GUARD = "LITE_GUARD";
  public static final int STATE_BG_GUARD = 1;
  public static final int STATE_BG_UN_GUARD = 2;
  public static final int STATE_FORGROUND = 3;
  private static final String STATMEMORY_LAST_REPORT_TIME = "StateMemoryLastTime";
  public static final String TAG = "Q.Memory.MemoryManager";
  private static long availClassSize;
  private static List<String> killedSystemProcess;
  private static List<Pattern> reservedPatternSystemProcess;
  private static List<String> reservedSystemProcess;
  private static MemoryManager sManager;
  private static long sysTotalMemory;
  private MemoryManager.LowMemoryReport lmr;
  private int mActivityLeakCount;
  private MemoryManager.IReportListener mListener;
  private Object mLowMemRptLock = new Object();
  private boolean mNeedReport;
  private int mOtherLeakCount;
  private int mQQAppLeakCount;
  private ConcurrentHashMap<String, MemoryManager.StatMemory> statMemoryMap = new ConcurrentHashMap(0);
  
  private MemoryManager()
  {
    if (0.1000000014901161D >= Math.random()) {
      bool = true;
    }
    this.mNeedReport = bool;
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "memory manager set need report = " + this.mNeedReport);
    }
    registerListener(aavb.a());
  }
  
  public static long getAvailClassSize()
  {
    if (availClassSize > 0L) {
      return availClassSize;
    }
    long l1 = DeviceInfoUtil.getSystemTotalMemory();
    sysTotalMemory = l1;
    long l2 = DeviceInfoUtil.getSystemAvaialbeMemory();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.getMemoryClass();
    if (l3 <= 157286400L) {
      availClassSize = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + availClassSize / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return availClassSize;
      if (l3 <= 262144000L) {
        availClassSize = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        availClassSize = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        availClassSize = Math.min(134217728L, l4);
      } else {
        availClassSize = Math.min(268435456L, l4);
      }
    }
  }
  
  public static MemoryManager getInstance()
  {
    if (sManager == null) {}
    try
    {
      if (sManager == null) {
        sManager = new MemoryManager();
      }
      return sManager;
    }
    finally {}
  }
  
  private MemoryManager.LowMemoryReport getLowMemoryReport()
  {
    if (this.lmr == null)
    {
      this.lmr = new MemoryManager.LowMemoryReport();
      this.lmr.init();
    }
    return this.lmr;
  }
  
  public static long getMemory(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      return 62914560L;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  public static void getMemoryInfo(int paramInt, MemoryManager.DebugMemoryInfo paramDebugMemoryInfo)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        paramDebugMemoryInfo.pss = (arrayOfMemoryInfo[0].getTotalPss() * 1024L);
        paramDebugMemoryInfo.nativePss = (arrayOfMemoryInfo[0].nativePss * 1024L);
        paramDebugMemoryInfo.dalvikPss = (arrayOfMemoryInfo[0].dalvikPss * 1024L);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      paramDebugMemoryInfo.pss = 62914560L;
      paramDebugMemoryInfo.nativePss = 31457280L;
      paramDebugMemoryInfo.dalvikPss = 31457280L;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  private void reportMemoryInfo24Hour(long paramLong1, long paramLong2, SharedPreferences paramSharedPreferences)
  {
    if (Math.abs(paramLong1 - paramLong2) > 86400000L)
    {
      Iterator localIterator = this.statMemoryMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        MemoryManager.StatMemory localStatMemory = (MemoryManager.StatMemory)((Map.Entry)localObject).getValue();
        int i = localStatMemory.statCount;
        if (i <= 0)
        {
          localStatMemory.reset();
        }
        else
        {
          HashMap localHashMap = new HashMap();
          localObject = (String)((Map.Entry)localObject).getKey();
          if ((!"BG_GUARD".equals(localObject)) && (!"LITE_GUARD".equals(localObject))) {
            throw new IllegalStateException("mode illegal");
          }
          localHashMap.put("startMode", localObject);
          paramLong2 = DeviceInfoUtil.getSystemTotalMemory() / 1024L;
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysTotalMemory illegal");
          }
          localHashMap.put("sysTotalMemory", String.valueOf(paramLong2));
          paramLong2 = DeviceInfoUtil.getMemoryClass() / 1024L;
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysClassMemory illegal");
          }
          localHashMap.put("sysClassMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.sysAvailableMemory / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysAvailableMemory illegal");
          }
          localHashMap.put("sysAvailableMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.qqOtherUsedMemory / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("qqOtherUsedMemory illegal");
          }
          localHashMap.put("qqOtherUsedMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.qqUsedMemory / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("qqUsedMemory illegal");
          }
          localHashMap.put("qqUsedMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.dalvikPss / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("dalvikPss illegal " + paramLong2);
          }
          localHashMap.put("dalvikPss", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.dalvikHeapSize / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("dalvikHeap illegal " + paramLong2);
          }
          localHashMap.put("dalvikHeap", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.nativePss / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("nativePss illegal " + paramLong2);
          }
          localHashMap.put("nativePss", String.valueOf(paramLong2));
          localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          paramLong2 = localStatMemory.imageCacheMax / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageCacheMax illegal");
          }
          localHashMap.put("imageCacheMax", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.imageCacheUsed / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageCacheUsed illegal");
          }
          localHashMap.put("imageCacheUsed", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.imageHitCount / i;
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageHitCount illegal");
          }
          localHashMap.put("imageHitCount", String.valueOf(paramLong2));
          if (localStatMemory.imageHitCount + localStatMemory.imageMissCount != 0) {}
          for (i = localStatMemory.imageHitCount * 100 / (localStatMemory.imageHitCount + localStatMemory.imageMissCount);; i = 0)
          {
            paramLong2 = i;
            if (paramLong2 >= 0L) {
              break;
            }
            throw new IllegalStateException("imageHitRate illegal");
          }
          localHashMap.put("imageHitRate", String.valueOf(paramLong2));
          localHashMap.put("guardConfigId", anvu.a().a());
          localHashMap.put("memoryConfigId", MagnifierSDK.a().a().jdField_a_of_type_JavaLangString);
          localHashMap.put("osVersion", Build.VERSION.RELEASE);
          localHashMap.put("resolution", DeviceInfoUtil.getResolutionString());
          if (MagnifierSDK.a().a().jdField_a_of_type_Aaux.jdField_a_of_type_Boolean)
          {
            localObject = "1";
            label838:
            localHashMap.put("clearMemFlag", localObject);
            if (!MagnifierSDK.a().a().b) {
              break label918;
            }
          }
          label918:
          for (i = 1;; i = 0)
          {
            localHashMap.put("enable_heap_sucide", String.valueOf(i));
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actMemory", true, 0L, 0L, localHashMap, null);
            localStatMemory.reset();
            localStatMemory.save();
            break;
            localObject = "0";
            break label838;
          }
        }
      }
      paramSharedPreferences.edit().putLong("StateMemoryLastTime", paramLong1).commit();
    }
  }
  
  public final void checkReportOOMInfo()
  {
    SharedPreferences localSharedPreferences;
    HashMap localHashMap;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      if (localSharedPreferences.contains("leak_actvity_count"))
      {
        localHashMap = new HashMap(10);
        localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("hackResult", String.valueOf(HackVm.c));
        localHashMap.put("hackArtResult", String.valueOf(HackVm.d));
        localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        localHashMap.put("leak_actvity_count", String.valueOf(localSharedPreferences.getInt("leak_actvity_count", -1)));
        localHashMap.put("leak_qqapp_count", String.valueOf(localSharedPreferences.getInt("leak_qqapp_count", -1)));
        localHashMap.put("leak_other_count", String.valueOf(localSharedPreferences.getInt("leak_other_count", -1)));
        localHashMap.put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        localHashMap.put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        localHashMap.put("heap_free", String.valueOf(localSharedPreferences.getLong("heap_free", -1L)));
        localHashMap.put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        localHashMap.put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        localHashMap.put("heap_org_max", String.valueOf(localSharedPreferences.getLong("heap_org_max", -1L)));
        localHashMap.put("oom_scid_count", String.valueOf(localSharedPreferences.getLong("oom_scid_count", -1L)));
        localHashMap.put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        localHashMap.put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        localHashMap.put("key_top_act", localSharedPreferences.getString("key_top_act", ""));
        localHashMap.put("key_mem_usg", localSharedPreferences.getString("key_mem_usg", ""));
        str = System.getProperty("java.vm.version");
        if (TextUtils.isEmpty(str)) {
          break label514;
        }
      }
    }
    label514:
    for (String str = str.substring(0, 1);; str = "")
    {
      localHashMap.put("vmVersion", str);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "oomInfo", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().putLong("oom_scid_count", 0L);
      localSharedPreferences.edit().remove("leak_actvity_count").commit();
      aavb.a().c();
      return;
    }
  }
  
  public void clearTopAppMemory(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.isReleased)) {}
    while (!MagnifierSDK.a().a().jdField_a_of_type_Boolean) {
      return;
    }
    paramQQAppInterface.execute(new MemoryManager.AlertMemoryRunner(paramQQAppInterface, paramContext, 2));
  }
  
  public int getActivityLeakCount()
  {
    return this.mActivityLeakCount;
  }
  
  public float getHeapLevel()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    return (float)l1 * 1.0F / (float)l2;
  }
  
  public int getOtherLeakCount()
  {
    return this.mOtherLeakCount;
  }
  
  public int getQQAppLeakCount()
  {
    return this.mQQAppLeakCount;
  }
  
  public void onOOMCrash()
  {
    long l2 = 1L;
    if (BaseApplicationImpl.sProcessId == 1) {}
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      localSharedPreferences.edit().putLong("heap_size", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("sys_pss", getMemory(Process.myPid()));
      localSharedPreferences.edit().putLong("sys_total", sysTotalMemory);
      localSharedPreferences.edit().putLong("heap_free", Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("heap_total", Runtime.getRuntime().totalMemory());
      localSharedPreferences.edit().putLong("heap_max", Runtime.getRuntime().maxMemory());
      localSharedPreferences.edit().putLong("heap_org_max", HackVm.a);
      localSharedPreferences.edit().putInt("leak_actvity_count", this.mActivityLeakCount);
      localSharedPreferences.edit().putInt("leak_qqapp_count", this.mQQAppLeakCount);
      localSharedPreferences.edit().putInt("leak_other_count", this.mOtherLeakCount);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().b)
      {
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().d) {
          break label378;
        }
      }
      label378:
      for (long l1 = l2;; l1 = 0L)
      {
        localEditor.putLong("en_sucide_ab", l1);
        localSharedPreferences.edit().putString("key_top_act", aoam.a());
        localSharedPreferences.edit().putString("key_mem_usg", bdlm.a().a());
        localSharedPreferences.edit().commit();
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("Q.Memory.MemoryManager", 2, "onOOMCrash", localThrowable);
    }
  }
  
  public void registerListener(MemoryManager.IReportListener paramIReportListener)
  {
    this.mListener = paramIReportListener;
  }
  
  protected void reportClear(long paramLong1, long paramLong2)
  {
    synchronized (this.mLowMemRptLock)
    {
      MemoryManager.LowMemoryReport localLowMemoryReport = getLowMemoryReport();
      localLowMemoryReport.clearRemainMemory += paramLong2;
      localLowMemoryReport.clearWarningMemory += paramLong1;
      localLowMemoryReport.clearCount += 1;
      localLowMemoryReport.save();
      return;
    }
  }
  
  protected void reportLow(long paramLong1, long paramLong2)
  {
    synchronized (this.mLowMemRptLock)
    {
      MemoryManager.LowMemoryReport localLowMemoryReport = getLowMemoryReport();
      localLowMemoryReport.lowRemainMemory += paramLong2;
      localLowMemoryReport.lowWarningMemory += paramLong1;
      localLowMemoryReport.lowMemoryCount += 1;
      localLowMemoryReport.save();
      return;
    }
  }
  
  protected void reportLowMemory()
  {
    synchronized (this.mLowMemRptLock)
    {
      localLowMemoryReport = getLowMemoryReport();
      l1 = System.currentTimeMillis();
      long l2 = localLowMemoryReport.reportTime;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localLowMemoryReport.lowMemoryCount;
          j = localLowMemoryReport.clearCount;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.getSystemTotalMemory() / 1024L));
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowWarningMemory", str);
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowRemainMemory", str);
          localHashMap.put("lowMemoryCount", String.valueOf(i));
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearWarningMemory", str);
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearRemainMemory", str);
          localHashMap.put("clearCount", String.valueOf(j));
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.getSystemTotalMemory() / 1024L) + ", lowWarningMemory=" + localLowMemoryReport.lowWarningMemory + ", lowRemainMemory=" + localLowMemoryReport.lowRemainMemory + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localLowMemoryReport.clearWarningMemory + ", clearRemainMemory=" + localLowMemoryReport.clearRemainMemory + ",clearCount=" + j);
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
          localLowMemoryReport.reset();
          localLowMemoryReport.reportTime = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localLowMemoryReport.reset();
          localLowMemoryReport.reportTime = l1;
        }
        localLowMemoryReport.save();
        return;
        str = String.valueOf(localLowMemoryReport.lowWarningMemory / (i * 1024));
        continue;
        str = String.valueOf(localLowMemoryReport.lowRemainMemory / (i * 1024));
        continue;
        str = String.valueOf(localLowMemoryReport.clearWarningMemory / (j * 1024));
      }
      l2 = localLowMemoryReport.clearRemainMemory / (j * 1024);
      str = String.valueOf(l2);
    }
  }
  
  public void reportMemory(String paramString)
  {
    if ((this.mListener != null) && ("BG_GUARD".equals(paramString))) {
      this.mListener.onReportMemory();
    }
    if (!this.mNeedReport)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "Report memory do not need report");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "Report memory with action = " + paramString);
    }
    reportMemoryInfo(paramString);
    reportLowMemory();
  }
  
  protected void reportMemoryInfo(String paramString)
  {
    Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (this.statMemoryMap.get("LITE_GUARD") == null)
    {
      localStatMemory = new MemoryManager.StatMemory();
      localStatMemory.init("LITE_GUARD");
      this.statMemoryMap.put("LITE_GUARD", localStatMemory);
    }
    if (this.statMemoryMap.get("BG_GUARD") == null)
    {
      localStatMemory = new MemoryManager.StatMemory();
      localStatMemory.init("BG_GUARD");
      this.statMemoryMap.put("BG_GUARD", localStatMemory);
    }
    if ("LITE_GUARD".equals(paramString)) {}
    for (MemoryManager.StatMemory localStatMemory = (MemoryManager.StatMemory)this.statMemoryMap.get("LITE_GUARD"); localStatMemory == null; localStatMemory = (MemoryManager.StatMemory)this.statMemoryMap.get("BG_GUARD"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
      label137:
      return;
      if (!"BG_GUARD".equals(paramString)) {
        break label802;
      }
    }
    long l3 = DeviceInfoUtil.getSystemAvaialbeMemory();
    MemoryManager.DebugMemoryInfo localDebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
    getMemoryInfo(Process.myPid(), localDebugMemoryInfo);
    long l4 = localDebugMemoryInfo.pss;
    long l1 = 0L;
    label799:
    label802:
    label808:
    for (;;)
    {
      try
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        long l2 = l1;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          l2 = l1;
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            String str = localRunningAppProcessInfo.processName;
            if ((!str.startsWith("com.tencent.mobileqq")) || (str.equals("com.tencent.mobileqq"))) {
              break label799;
            }
            l1 = getMemory(localRunningAppProcessInfo.pid) + l1;
            break label808;
          }
        }
        if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {
          break label137;
        }
        localStatMemory.sysAvailableMemory += l3;
        localStatMemory.qqOtherUsedMemory += l2;
        localStatMemory.qqUsedMemory += l4;
        localStatMemory.dalvikPss += localDebugMemoryInfo.dalvikPss;
        localStatMemory.nativePss += localDebugMemoryInfo.nativePss;
        localStatMemory.dalvikHeapSize += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        localStatMemory.statCount += 1;
        localObject = BaseApplicationImpl.sImageCache;
        localStatMemory.imageCacheMax += ((MQLruCache)localObject).maxSize();
        localStatMemory.imageCacheUsed += ((MQLruCache)localObject).size();
        localStatMemory.imageHitCount += ((MQLruCache)localObject).hitCount();
        int i = localStatMemory.imageMissCount;
        localStatMemory.imageMissCount = (((MQLruCache)localObject).missCount() + i);
        l3 = System.currentTimeMillis();
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0);
        l2 = ((SharedPreferences)localObject).getLong("StateMemoryLastTime", 0L);
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = System.currentTimeMillis();
          ((SharedPreferences)localObject).edit().putLong("StateMemoryLastTime", l1).commit();
        }
        reportMemoryInfo24Hour(l3, l1, (SharedPreferences)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportMemoryInfo, start mode =").append(paramString).append("sysTotalMemory=").append(DeviceInfoUtil.getSystemTotalMemory()).append(",statCount=").append(localStatMemory.statCount).append(",sysClassMemory=").append(DeviceInfoUtil.getMemoryClass()).append(",sysAvailableMemory=").append(localStatMemory.sysAvailableMemory).append(",qqOtherUsedMemory=").append(localStatMemory.qqOtherUsedMemory).append(",qqUsedMemory=").append(localStatMemory.qqUsedMemory).append(",imageCacheMax=").append(localStatMemory.imageCacheMax).append(",imageCacheUsed=").append(localStatMemory.imageCacheUsed).append(",imageHitCount=").append(localStatMemory.imageHitCount).append(",imageHitTotal=").append(localStatMemory.imageHitCount + localStatMemory.imageMissCount).append("\n");
          QLog.d("Q.Memory.MemoryManager", 2, ((StringBuilder)localObject).toString());
        }
        localStatMemory.save();
        return;
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
        }
        localStatMemory.reset();
        localStatMemory.save();
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break label137;
      }
      QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
      return;
      break label808;
      localStatMemory = null;
      break;
    }
  }
  
  public void reportMemoryLevel(long paramLong)
  {
    long l1;
    if (paramLong == 2L)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      l1 = localSharedPreferences.getLong("oom_scid_count", 0L);
      localSharedPreferences.edit().putLong("oom_scid_count", l1 + 1L);
      localSharedPreferences.edit().commit();
    }
    long l3 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l4 = Runtime.getRuntime().totalMemory();
    long l5 = Runtime.getRuntime().maxMemory();
    float f = (float)l4 * 1.0F / (float)l5;
    long l6 = DeviceInfoUtil.getSystemAvaialbeMemory();
    long l7 = getMemory(Process.myPid());
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_heap_level", 0);
    if (localSharedPreferences.contains("enable_sucide_heap")) {
      localSharedPreferences.edit().remove("enable_sucide_heap");
    }
    if (paramLong == 2L)
    {
      localSharedPreferences.edit().putLong("guard_type", paramLong);
      localSharedPreferences.edit().putLong("heap_size", l3);
      localSharedPreferences.edit().putLong("heap_total", l4);
      localSharedPreferences.edit().putLong("heap_max", l5);
      localSharedPreferences.edit().putFloat("heap_level", f);
      localSharedPreferences.edit().putLong("sys_total", l6);
      localSharedPreferences.edit().putLong("sys_pss", l7);
      localObject = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().b)
      {
        paramLong = 1L;
        ((SharedPreferences.Editor)localObject).putLong("enable_sucide_heap_new", paramLong);
        localObject = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().d) {
          break label367;
        }
        paramLong = 1L;
        label337:
        ((SharedPreferences.Editor)localObject).putLong("en_sucide_ab", paramLong);
        localSharedPreferences.edit().commit();
      }
    }
    label367:
    do
    {
      return;
      paramLong = 0L;
      break;
      paramLong = 0L;
      break label337;
      if (localSharedPreferences.getFloat("heap_level", -1.0F) > 0.0F)
      {
        localObject = new HashMap(10);
        ((HashMap)localObject).put("guard_type", String.valueOf(localSharedPreferences.getLong("guard_type", -1L)));
        ((HashMap)localObject).put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        ((HashMap)localObject).put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        ((HashMap)localObject).put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        ((HashMap)localObject).put("heap_level", String.valueOf(localSharedPreferences.getFloat("heap_level", -1.0F)));
        ((HashMap)localObject).put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        ((HashMap)localObject).put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        ((HashMap)localObject).put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
        localSharedPreferences.edit().remove("heap_level").commit();
      }
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0);
      long l2 = localSharedPreferences.getLong("HeapLevelReportLastTime", 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = System.currentTimeMillis();
        localSharedPreferences.edit().putLong("HeapLevelReportLastTime", l1).commit();
      }
    } while ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) || (!MagnifierSDK.a().a().c));
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("guard_type", String.valueOf(paramLong));
    ((HashMap)localObject).put("heap_size", String.valueOf(l3));
    ((HashMap)localObject).put("heap_total", String.valueOf(l4));
    ((HashMap)localObject).put("heap_max", String.valueOf(l5));
    ((HashMap)localObject).put("heap_level", String.valueOf(f));
    ((HashMap)localObject).put("sys_total", String.valueOf(l6));
    ((HashMap)localObject).put("sys_pss", String.valueOf(l7));
    if (MagnifierSDK.a().a().b)
    {
      i = 1;
      ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(i));
      if (!MagnifierSDK.a().a().d) {
        break label938;
      }
    }
    label938:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject).put("en_sucide_ab", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
      localSharedPreferences.edit().putLong("HeapLevelReportLastTime", System.currentTimeMillis()).commit();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */