package com.tencent.mobileqq.app;

import alua;
import alwk;
import alwl;
import alwm;
import alwn;
import alwo;
import alzk;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import azrd;
import azri;
import bdgk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import zia;
import zie;

public class MemoryManager
{
  private static long jdField_a_of_type_Long;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static long jdField_b_of_type_Long;
  private static List<Pattern> jdField_b_of_type_JavaUtilList;
  private static List<String> jdField_c_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  private alwm jdField_a_of_type_Alwm;
  private alwn jdField_a_of_type_Alwn;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, alwo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
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
    a(zie.a());
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long > 0L) {
      return jdField_a_of_type_Long;
    }
    long l1 = bdgk.d();
    jdField_b_of_type_Long = l1;
    long l2 = bdgk.e();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = bdgk.f();
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
  
  private alwn a()
  {
    if (this.jdField_a_of_type_Alwn == null)
    {
      this.jdField_a_of_type_Alwn = new alwn();
      this.jdField_a_of_type_Alwn.a();
    }
    return this.jdField_a_of_type_Alwn;
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
  
  public static void a(int paramInt, alwl paramalwl)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        paramalwl.jdField_a_of_type_Long = (arrayOfMemoryInfo[0].getTotalPss() * 1024L);
        paramalwl.jdField_b_of_type_Long = (arrayOfMemoryInfo[0].nativePss * 1024L);
        paramalwl.jdField_c_of_type_Long = (arrayOfMemoryInfo[0].dalvikPss * 1024L);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      paramalwl.jdField_a_of_type_Long = 62914560L;
      paramalwl.jdField_b_of_type_Long = 31457280L;
      paramalwl.jdField_c_of_type_Long = 31457280L;
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
      localSharedPreferences.edit().putLong("heap_org_max", HackVm.jdField_a_of_type_Long);
      localSharedPreferences.edit().putInt("leak_actvity_count", this.jdField_a_of_type_Int);
      localSharedPreferences.edit().putInt("leak_qqapp_count", this.jdField_b_of_type_Int);
      localSharedPreferences.edit().putInt("leak_other_count", this.jdField_c_of_type_Int);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (alwk.a().c)
      {
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!alwk.a().e) {
          break label388;
        }
      }
      label388:
      for (long l1 = l2;; l1 = 0L)
      {
        localEditor.putLong("en_sucide_ab", l1);
        localSharedPreferences.edit().putString("key_top_act", alzk.a());
        localSharedPreferences.edit().putString("key_mem_usg", azrd.a().a());
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
    long l6 = bdgk.e();
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
      if (alwk.a().c)
      {
        paramLong = 1L;
        ((SharedPreferences.Editor)localObject).putLong("enable_sucide_heap_new", paramLong);
        localObject = localSharedPreferences.edit();
        if (!alwk.a().e) {
          break label375;
        }
        paramLong = 1L;
        label344:
        ((SharedPreferences.Editor)localObject).putLong("en_sucide_ab", paramLong);
        localSharedPreferences.edit().commit();
      }
    }
    label375:
    do
    {
      return;
      paramLong = 0L;
      break;
      paramLong = 0L;
      break label344;
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
        azri.a(BaseApplicationImpl.getApplication()).a(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
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
    } while ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) || (!alwk.a().d));
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("guard_type", String.valueOf(paramLong));
    ((HashMap)localObject).put("heap_size", String.valueOf(l3));
    ((HashMap)localObject).put("heap_total", String.valueOf(l4));
    ((HashMap)localObject).put("heap_max", String.valueOf(l5));
    ((HashMap)localObject).put("heap_level", String.valueOf(f));
    ((HashMap)localObject).put("sys_total", String.valueOf(l6));
    ((HashMap)localObject).put("sys_pss", String.valueOf(l7));
    if (alwk.a().c)
    {
      i = 1;
      ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(i));
      if (!alwk.a().e) {
        break label972;
      }
    }
    label972:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject).put("en_sucide_ab", String.valueOf(i));
      azri.a(BaseApplicationImpl.getApplication()).a(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
      localSharedPreferences.edit().putLong("HeapLevelReportLastTime", System.currentTimeMillis()).commit();
      return;
      i = 0;
      break;
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      alwn localalwn = a();
      localalwn.jdField_a_of_type_Long += paramLong2;
      localalwn.jdField_b_of_type_Long += paramLong1;
      localalwn.jdField_a_of_type_Int += 1;
      localalwn.c();
      return;
    }
  }
  
  public void a(alwm paramalwm)
  {
    this.jdField_a_of_type_Alwm = paramalwm;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.l)) {}
    while (!alwk.a().jdField_a_of_type_Boolean) {
      return;
    }
    paramQQAppInterface.a(new MemoryManager.AlertMemoryRunner(paramQQAppInterface, paramContext, 2));
  }
  
  public void a(Object paramObject)
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      if (paramObject != null) {}
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof QQAppInterface)) {
        this.jdField_b_of_type_Int += 1;
      }
      while (paramObject != null)
      {
        paramObject = paramObject.getClass().getSimpleName();
        HashMap localHashMap = new HashMap();
        localHashMap.put("model", Build.MODEL);
        localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L / 1024L));
        localHashMap.put("leakClz", paramObject);
        localHashMap.put("pid", String.valueOf(BaseApplicationImpl.sProcessId));
        azri.a(BaseApplicationImpl.getContext()).a("", "actLeakMem", true, 0L, 0L, localHashMap, "");
        return;
        if ((paramObject instanceof Activity)) {
          this.jdField_a_of_type_Int += 1;
        } else {
          this.jdField_c_of_type_Int += 1;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Alwm != null) && ("BG_GUARD".equals(paramString))) {
      this.jdField_a_of_type_Alwm.a();
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
        localHashMap.put("hackResult", String.valueOf(HackVm.jdField_c_of_type_Int));
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
          break label549;
        }
      }
    }
    label549:
    for (String str = str.substring(0, 1);; str = "")
    {
      localHashMap.put("vmVersion", str);
      azri.a(BaseApplicationImpl.getApplication()).a(null, "oomInfo", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().putLong("oom_scid_count", 0L);
      localSharedPreferences.edit().remove("leak_actvity_count").commit();
      zie.a().d();
      return;
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      alwn localalwn = a();
      localalwn.jdField_c_of_type_Long += paramLong2;
      localalwn.d += paramLong1;
      localalwn.jdField_b_of_type_Int += 1;
      localalwn.c();
      return;
    }
  }
  
  protected void b(String paramString)
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    alwo localalwo;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD") == null)
    {
      localalwo = new alwo();
      localalwo.a("LITE_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("LITE_GUARD", localalwo);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD") == null)
    {
      localalwo = new alwo();
      localalwo.a("BG_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("BG_GUARD", localalwo);
    }
    if ("LITE_GUARD".equals(paramString))
    {
      localalwo = (alwo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD");
      if (localalwo != null) {
        break label173;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
    }
    label173:
    long l3;
    Object localObject2;
    label228:
    Object localObject4;
    label591:
    HashMap localHashMap;
    for (;;)
    {
      return;
      if (!"BG_GUARD".equals(paramString)) {
        break label1711;
      }
      localalwo = (alwo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD");
      break;
      l3 = bdgk.e();
      localObject2 = new alwl();
      a(Process.myPid(), (alwl)localObject2);
      long l4 = ((alwl)localObject2).jdField_a_of_type_Long;
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
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            localObject4 = ((ActivityManager.RunningAppProcessInfo)localObject3).processName;
            if ((!((String)localObject4).startsWith("com.tencent.mobileqq")) || (((String)localObject4).equals("com.tencent.mobileqq"))) {
              break label1708;
            }
            l1 = a(((ActivityManager.RunningAppProcessInfo)localObject3).pid) + l1;
            break label1717;
          }
        }
        if ((l3 >= 0L) && (l4 >= 0L) && (l2 >= 0L))
        {
          localalwo.jdField_a_of_type_Long += l3;
          localalwo.jdField_b_of_type_Long += l2;
          localalwo.jdField_c_of_type_Long += l4;
          localalwo.g += ((alwl)localObject2).jdField_c_of_type_Long;
          localalwo.f += ((alwl)localObject2).jdField_b_of_type_Long;
          localalwo.h += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
          localalwo.jdField_a_of_type_Int += 1;
          localObject1 = BaseApplicationImpl.sImageCache;
          localalwo.d += ((MQLruCache)localObject1).maxSize();
          localalwo.e += ((MQLruCache)localObject1).size();
          localalwo.jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
          i = localalwo.jdField_b_of_type_Int;
          localalwo.jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i);
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
            break label1515;
          }
          localObject3 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1492;
            }
            localObject1 = (Map.Entry)((Iterator)localObject3).next();
            localObject4 = (alwo)((Map.Entry)localObject1).getValue();
            i = ((alwo)localObject4).jdField_a_of_type_Int;
            if (i > 0) {
              break;
            }
            ((alwo)localObject4).a();
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
        }
        localalwo.a();
        localalwo.b();
        return;
        localHashMap = new HashMap();
        localObject1 = (String)((Map.Entry)localObject1).getKey();
        if (("BG_GUARD".equals(localObject1)) || ("LITE_GUARD".equals(localObject1))) {
          break label743;
        }
        throw new IllegalStateException("mode illegal");
      }
      catch (Exception paramString) {}
    }
    QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
    return;
    label743:
    localHashMap.put("startMode", localObject1);
    long l1 = bdgk.d() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysTotalMemory illegal");
    }
    localHashMap.put("sysTotalMemory", String.valueOf(l1));
    l1 = bdgk.f() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysClassMemory illegal");
    }
    localHashMap.put("sysClassMemory", String.valueOf(l1));
    l1 = ((alwo)localObject4).jdField_a_of_type_Long / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("sysAvailableMemory illegal");
    }
    localHashMap.put("sysAvailableMemory", String.valueOf(l1));
    l1 = ((alwo)localObject4).jdField_b_of_type_Long / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("qqOtherUsedMemory illegal");
    }
    localHashMap.put("qqOtherUsedMemory", String.valueOf(l1));
    l1 = ((alwo)localObject4).jdField_c_of_type_Long / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("qqUsedMemory illegal");
    }
    localHashMap.put("qqUsedMemory", String.valueOf(l1));
    l1 = ((alwo)localObject4).g / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("dalvikPss illegal " + l1);
    }
    localHashMap.put("dalvikPss", String.valueOf(l1));
    l1 = ((alwo)localObject4).h / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("dalvikHeap illegal " + l1);
    }
    localHashMap.put("dalvikHeap", String.valueOf(l1));
    l1 = ((alwo)localObject4).f / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("nativePss illegal " + l1);
    }
    localHashMap.put("nativePss", String.valueOf(l1));
    localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
    l1 = ((alwo)localObject4).d / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheMax illegal");
    }
    localHashMap.put("imageCacheMax", String.valueOf(l1));
    l1 = ((alwo)localObject4).e / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheUsed illegal");
    }
    localHashMap.put("imageCacheUsed", String.valueOf(l1));
    l1 = ((alwo)localObject4).jdField_c_of_type_Int / i;
    if (l1 < 0L) {
      throw new IllegalStateException("imageHitCount illegal");
    }
    localHashMap.put("imageHitCount", String.valueOf(l1));
    if (((alwo)localObject4).jdField_c_of_type_Int + ((alwo)localObject4).jdField_b_of_type_Int != 0)
    {
      i = ((alwo)localObject4).jdField_c_of_type_Int * 100 / (((alwo)localObject4).jdField_c_of_type_Int + ((alwo)localObject4).jdField_b_of_type_Int);
      label1321:
      l1 = i;
      if (l1 < 0L) {
        throw new IllegalStateException("imageHitRate illegal");
      }
      localHashMap.put("imageHitRate", String.valueOf(l1));
      localHashMap.put("guardConfigId", alua.a().a());
      localHashMap.put("memoryConfigId", alwk.a().jdField_a_of_type_JavaLangString);
      localHashMap.put("osVersion", Build.VERSION.RELEASE);
      localHashMap.put("resolution", bdgk.l());
      if (!alwk.a().jdField_a_of_type_Zia.jdField_a_of_type_Boolean) {
        break label1725;
      }
      localObject1 = "1";
      label1425:
      localHashMap.put("clearMemFlag", localObject1);
      if (!alwk.a().c) {
        break label1733;
      }
    }
    label1708:
    label1711:
    label1717:
    label1725:
    label1733:
    for (int i = 1;; i = 0)
    {
      localHashMap.put("enable_heap_sucide", String.valueOf(i));
      azri.a(BaseApplicationImpl.getApplication()).a(null, "actMemory", true, 0L, 0L, localHashMap, null);
      ((alwo)localObject4).a();
      ((alwo)localObject4).b();
      break label591;
      label1492:
      ((SharedPreferences)localObject2).edit().putLong("StateMemoryLastTime", l3).commit();
      label1515:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportMemoryInfo, start mode =").append(paramString).append("sysTotalMemory=").append(bdgk.d()).append(",statCount=").append(localalwo.jdField_a_of_type_Int).append(",sysClassMemory=").append(bdgk.f()).append(",sysAvailableMemory=").append(localalwo.jdField_a_of_type_Long).append(",qqOtherUsedMemory=").append(localalwo.jdField_b_of_type_Long).append(",qqUsedMemory=").append(localalwo.jdField_c_of_type_Long).append(",imageCacheMax=").append(localalwo.d).append(",imageCacheUsed=").append(localalwo.e).append(",imageHitCount=").append(localalwo.jdField_c_of_type_Int).append(",imageHitTotal=").append(localalwo.jdField_c_of_type_Int + localalwo.jdField_b_of_type_Int).append("\n");
        QLog.d("Q.Memory.MemoryManager", 2, ((StringBuilder)localObject1).toString());
      }
      localalwo.b();
      return;
      break label1717;
      localalwo = null;
      break;
      break label228;
      i = 0;
      break label1321;
      localObject1 = "0";
      break label1425;
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
      localalwn = a();
      l1 = System.currentTimeMillis();
      long l2 = localalwn.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localalwn.jdField_a_of_type_Int;
          j = localalwn.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(bdgk.d() / 1024L));
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
          azri.a(BaseApplicationImpl.getApplication()).a(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(bdgk.d() / 1024L) + ", lowWarningMemory=" + localalwn.jdField_b_of_type_Long + ", lowRemainMemory=" + localalwn.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localalwn.d + ", clearRemainMemory=" + localalwn.jdField_c_of_type_Long + ",clearCount=" + j);
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
          localalwn.b();
          localalwn.e = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localalwn.b();
          localalwn.e = l1;
        }
        localalwn.c();
        return;
        str = String.valueOf(localalwn.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localalwn.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localalwn.d / (j * 1024));
      }
      l2 = localalwn.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */