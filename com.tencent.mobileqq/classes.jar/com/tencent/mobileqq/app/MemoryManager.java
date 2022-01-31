package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.ClearMemoryConfig;
import com.tencent.common.cache.MemoryClearManagerNew;
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
import zlp;
import znh;
import zni;
import znj;

public class MemoryManager
{
  private static long jdField_a_of_type_Long;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
  private static List jdField_a_of_type_JavaUtilList;
  private static long jdField_b_of_type_Long;
  private static List jdField_b_of_type_JavaUtilList;
  private static List jdField_c_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  private MemoryManager.IReportListener jdField_a_of_type_ComTencentMobileqqAppMemoryManager$IReportListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
  private zni jdField_a_of_type_Zni;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  
  private MemoryManager()
  {
    if (0.1000000014901161D >= Math.random()) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "memory manager set need report = " + this.jdField_a_of_type_Boolean);
    }
    a(MemoryClearManagerNew.a());
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long > 0L) {
      return jdField_a_of_type_Long;
    }
    long l1 = DeviceInfoUtil.e();
    jdField_b_of_type_Long = l1;
    long l2 = DeviceInfoUtil.f();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.g();
    if (l3 <= 157286400L) {
      jdField_a_of_type_Long = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + jdField_a_of_type_Long / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return jdField_a_of_type_Long;
      if (l3 <= 262144000L) {
        jdField_a_of_type_Long = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        jdField_a_of_type_Long = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        jdField_a_of_type_Long = Math.min(134217728L, l4);
      } else {
        jdField_a_of_type_Long = Math.min(268435456L, l4);
      }
    }
  }
  
  public static long a(int paramInt)
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
  
  public static MemoryManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryManager = new MemoryManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
    }
    finally {}
  }
  
  private zni a()
  {
    if (this.jdField_a_of_type_Zni == null)
    {
      this.jdField_a_of_type_Zni = new zni();
      this.jdField_a_of_type_Zni.a();
    }
    return this.jdField_a_of_type_Zni;
  }
  
  public float a()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    return (float)l1 * 1.0F / (float)l2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
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
      localSharedPreferences.edit().putLong("sys_pss", a(Process.myPid()));
      localSharedPreferences.edit().putLong("sys_total", jdField_b_of_type_Long);
      localSharedPreferences.edit().putLong("heap_free", Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("heap_total", Runtime.getRuntime().totalMemory());
      localSharedPreferences.edit().putLong("heap_max", Runtime.getRuntime().maxMemory());
      localSharedPreferences.edit().putInt("leak_actvity_count", this.jdField_a_of_type_Int);
      localSharedPreferences.edit().putInt("leak_qqapp_count", this.jdField_b_of_type_Int);
      localSharedPreferences.edit().putInt("leak_other_count", this.jdField_c_of_type_Int);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (MemoryConfigs.a().c)
      {
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!MemoryConfigs.a().e) {
          break label326;
        }
      }
      label326:
      for (long l1 = l2;; l1 = 0L)
      {
        localEditor.putLong("en_sucide_ab", l1);
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
  
  public void a(long paramLong)
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
    long l6 = DeviceInfoUtil.f();
    long l7 = a(Process.myPid());
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
      if (MemoryConfigs.a().c)
      {
        paramLong = 1L;
        ((SharedPreferences.Editor)localObject).putLong("enable_sucide_heap_new", paramLong);
        localObject = localSharedPreferences.edit();
        if (!MemoryConfigs.a().e) {
          break label373;
        }
        paramLong = 1L;
        label342:
        ((SharedPreferences.Editor)localObject).putLong("en_sucide_ab", paramLong);
        localSharedPreferences.edit().commit();
      }
    }
    label373:
    do
    {
      return;
      paramLong = 0L;
      break;
      paramLong = 0L;
      break label342;
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
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
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
    } while ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) || (!MemoryConfigs.a().d));
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("guard_type", String.valueOf(paramLong));
    ((HashMap)localObject).put("heap_size", String.valueOf(l3));
    ((HashMap)localObject).put("heap_total", String.valueOf(l4));
    ((HashMap)localObject).put("heap_max", String.valueOf(l5));
    ((HashMap)localObject).put("heap_level", String.valueOf(f));
    ((HashMap)localObject).put("sys_total", String.valueOf(l6));
    ((HashMap)localObject).put("sys_pss", String.valueOf(l7));
    if (MemoryConfigs.a().c)
    {
      i = 1;
      ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(i));
      if (!MemoryConfigs.a().e) {
        break label970;
      }
    }
    label970:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject).put("en_sucide_ab", String.valueOf(i));
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
      localSharedPreferences.edit().putLong("HeapLevelReportLastTime", System.currentTimeMillis()).commit();
      return;
      i = 0;
      break;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      zni localzni = a();
      localzni.jdField_a_of_type_Long += paramLong2;
      localzni.jdField_b_of_type_Long += paramLong1;
      localzni.jdField_a_of_type_Int += 1;
      localzni.c();
      return;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.l)) {}
    while (!MemoryConfigs.a().jdField_a_of_type_Boolean) {
      return;
    }
    paramQQAppInterface.a(new znh(paramQQAppInterface, paramContext, 2));
  }
  
  public void a(MemoryManager.IReportListener paramIReportListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$IReportListener = paramIReportListener;
  }
  
  public void a(Object paramObject)
  {
    if ((BaseApplicationImpl.sProcessId != 1) || (paramObject == null)) {
      return;
    }
    if ((paramObject instanceof QQAppInterface))
    {
      this.jdField_b_of_type_Int += 1;
      return;
    }
    if ((paramObject instanceof Activity))
    {
      this.jdField_a_of_type_Int += 1;
      return;
    }
    this.jdField_c_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$IReportListener != null) && ("BG_GUARD".equals(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$IReportListener.a();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "Report memory do not need report");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "Report memory with action = " + paramString);
    }
    b(paramString);
    c();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void b()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      if (localSharedPreferences.contains("leak_actvity_count"))
      {
        HashMap localHashMap = new HashMap(10);
        localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        localHashMap.put("leak_actvity_count", String.valueOf(localSharedPreferences.getInt("leak_actvity_count", -1)));
        localHashMap.put("leak_qqapp_count", String.valueOf(localSharedPreferences.getInt("leak_qqapp_count", -1)));
        localHashMap.put("leak_other_count", String.valueOf(localSharedPreferences.getInt("leak_other_count", -1)));
        localHashMap.put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        localHashMap.put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        localHashMap.put("heap_free", String.valueOf(localSharedPreferences.getLong("heap_free", -1L)));
        localHashMap.put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        localHashMap.put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        localHashMap.put("oom_scid_count", String.valueOf(localSharedPreferences.getLong("oom_scid_count", -1L)));
        localHashMap.put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        localHashMap.put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "oomInfo", true, 0L, 0L, localHashMap, null);
        localSharedPreferences.edit().putLong("oom_scid_count", 0L);
        localSharedPreferences.edit().remove("leak_actvity_count").commit();
      }
      MemoryClearManagerNew.a().d();
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      zni localzni = a();
      localzni.jdField_c_of_type_Long += paramLong2;
      localzni.d += paramLong1;
      localzni.jdField_b_of_type_Int += 1;
      localzni.c();
      return;
    }
  }
  
  protected void b(String paramString)
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    znj localznj1;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD") == null)
    {
      localznj1 = new znj();
      localznj1.a("LITE_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("LITE_GUARD", localznj1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD") == null)
    {
      localznj1 = new znj();
      localznj1.a("BG_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("BG_GUARD", localznj1);
    }
    if ("LITE_GUARD".equals(paramString))
    {
      localznj1 = (znj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD");
      if (localznj1 != null) {
        break label173;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
    }
    label173:
    long l3;
    label212:
    Object localObject2;
    label519:
    znj localznj2;
    HashMap localHashMap;
    for (;;)
    {
      return;
      if (!"BG_GUARD".equals(paramString)) {
        break label1437;
      }
      localznj1 = (znj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD");
      break;
      l3 = DeviceInfoUtil.f();
      long l4 = a(Process.myPid());
      l1 = 0L;
      try
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        long l2 = l1;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          l2 = l1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            localObject3 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            if ((!((String)localObject3).startsWith("com.tencent.mobileqq")) || (((String)localObject3).equals("com.tencent.mobileqq"))) {
              break label1434;
            }
            l1 = a(((ActivityManager.RunningAppProcessInfo)localObject2).pid) + l1;
            break label1443;
          }
        }
        if ((l3 >= 0L) && (l4 >= 0L) && (l2 >= 0L))
        {
          localznj1.jdField_a_of_type_Long += l3;
          localznj1.jdField_b_of_type_Long += l2;
          localznj1.jdField_c_of_type_Long += l4;
          localznj1.jdField_a_of_type_Int += 1;
          localObject1 = BaseApplicationImpl.sImageCache;
          localznj1.d += ((MQLruCache)localObject1).maxSize();
          localznj1.e += ((MQLruCache)localObject1).size();
          localznj1.jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
          i = localznj1.jdField_b_of_type_Int;
          localznj1.jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i);
          l3 = System.currentTimeMillis();
          localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0);
          l2 = ((SharedPreferences)localObject2).getLong("StateMemoryLastTime", 0L);
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = System.currentTimeMillis();
            ((SharedPreferences)localObject2).edit().putLong("StateMemoryLastTime", l1).commit();
          }
          if (Math.abs(l3 - l1) <= 86400000L) {
            break label1241;
          }
          localObject3 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1218;
            }
            localObject1 = (Map.Entry)((Iterator)localObject3).next();
            localznj2 = (znj)((Map.Entry)localObject1).getValue();
            i = localznj2.jdField_a_of_type_Int;
            if (i > 0) {
              break;
            }
            localznj2.a();
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
        }
        localznj1.a();
        localznj1.b();
        return;
        localHashMap = new HashMap();
        localObject1 = (String)((Map.Entry)localObject1).getKey();
        if (("BG_GUARD".equals(localObject1)) || ("LITE_GUARD".equals(localObject1))) {
          break label671;
        }
        throw new IllegalStateException("mode illegal");
      }
      catch (Exception paramString) {}
    }
    QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
    return;
    label671:
    localHashMap.put("startMode", localObject1);
    long l1 = DeviceInfoUtil.e() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysTotalMemory illegal");
    }
    localHashMap.put("sysTotalMemory", String.valueOf(l1));
    l1 = DeviceInfoUtil.g() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysClassMemory illegal");
    }
    localHashMap.put("sysClassMemory", String.valueOf(l1));
    l1 = localznj2.jdField_a_of_type_Long / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("sysAvailableMemory illegal");
    }
    localHashMap.put("sysAvailableMemory", String.valueOf(l1));
    l1 = localznj2.jdField_b_of_type_Long / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("qqOtherUsedMemory illegal");
    }
    localHashMap.put("qqOtherUsedMemory", String.valueOf(l1));
    l1 = localznj2.jdField_c_of_type_Long / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("qqUsedMemory illegal");
    }
    localHashMap.put("qqUsedMemory", String.valueOf(l1));
    l1 = localznj2.d / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheMax illegal");
    }
    localHashMap.put("imageCacheMax", String.valueOf(l1));
    l1 = localznj2.e / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheUsed illegal");
    }
    localHashMap.put("imageCacheUsed", String.valueOf(l1));
    l1 = localznj2.jdField_c_of_type_Int / i;
    if (l1 < 0L) {
      throw new IllegalStateException("imageHitCount illegal");
    }
    localHashMap.put("imageHitCount", String.valueOf(l1));
    if (localznj2.jdField_c_of_type_Int + localznj2.jdField_b_of_type_Int != 0)
    {
      i = localznj2.jdField_c_of_type_Int * 100 / (localznj2.jdField_c_of_type_Int + localznj2.jdField_b_of_type_Int);
      label1047:
      l1 = i;
      if (l1 < 0L) {
        throw new IllegalStateException("imageHitRate illegal");
      }
      localHashMap.put("imageHitRate", String.valueOf(l1));
      localHashMap.put("guardConfigId", zlp.a().a());
      localHashMap.put("memoryConfigId", MemoryConfigs.a().jdField_a_of_type_JavaLangString);
      localHashMap.put("osVersion", Build.VERSION.RELEASE);
      localHashMap.put("resolution", DeviceInfoUtil.m());
      if (!MemoryConfigs.a().jdField_a_of_type_ComTencentCommonCacheClearMemoryConfig.jdField_a_of_type_Boolean) {
        break label1451;
      }
      localObject1 = "1";
      label1151:
      localHashMap.put("clearMemFlag", localObject1);
      if (!MemoryConfigs.a().c) {
        break label1459;
      }
    }
    label1434:
    label1437:
    label1443:
    label1451:
    label1459:
    for (int i = 1;; i = 0)
    {
      localHashMap.put("enable_heap_sucide", String.valueOf(i));
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actMemory", true, 0L, 0L, localHashMap, null);
      localznj2.a();
      localznj2.b();
      break label519;
      label1218:
      ((SharedPreferences)localObject2).edit().putLong("StateMemoryLastTime", l3).commit();
      label1241:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportMemoryInfo, start mode =").append(paramString).append("sysTotalMemory=").append(DeviceInfoUtil.e()).append(",statCount=").append(localznj1.jdField_a_of_type_Int).append(",sysClassMemory=").append(DeviceInfoUtil.g()).append(",sysAvailableMemory=").append(localznj1.jdField_a_of_type_Long).append(",qqOtherUsedMemory=").append(localznj1.jdField_b_of_type_Long).append(",qqUsedMemory=").append(localznj1.jdField_c_of_type_Long).append(",imageCacheMax=").append(localznj1.d).append(",imageCacheUsed=").append(localznj1.e).append(",imageHitCount=").append(localznj1.jdField_c_of_type_Int).append(",imageHitTotal=").append(localznj1.jdField_c_of_type_Int + localznj1.jdField_b_of_type_Int).append("\n");
        QLog.d("Q.Memory.MemoryManager", 2, ((StringBuilder)localObject1).toString());
      }
      localznj1.b();
      return;
      break label1443;
      localznj1 = null;
      break;
      break label212;
      i = 0;
      break label1047;
      localObject1 = "0";
      break label1151;
    }
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localzni = a();
      l1 = System.currentTimeMillis();
      long l2 = localzni.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localzni.jdField_a_of_type_Int;
          j = localzni.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.e() / 1024L));
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
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.e() / 1024L) + ", lowWarningMemory=" + localzni.jdField_b_of_type_Long + ", lowRemainMemory=" + localzni.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localzni.d + ", clearRemainMemory=" + localzni.jdField_c_of_type_Long + ",clearCount=" + j);
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
          localzni.b();
          localzni.e = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localzni.b();
          localzni.e = l1;
        }
        localzni.c();
        return;
        str = String.valueOf(localzni.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localzni.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localzni.d / (j * 1024));
      }
      l2 = localzni.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */