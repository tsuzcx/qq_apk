package com.tencent.common.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Process;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.CacheInfo;
import com.tencent.commonsdk.cache.HashMapInfo;
import com.tencent.commonsdk.cache.IMemoryManager;
import com.tencent.commonsdk.cache.LruCacheInfo;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MemoryManager.IReportListener;
import com.tencent.mobileqq.app.memory.MemoryReporter.IMemoryListener;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.IAppStateChangeListener;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryClearManagerNew
  implements IMemoryManager, MemoryManager.IReportListener, MemoryReporter.IMemoryListener, IAppStateChangeListener
{
  private static MemoryClearManagerNew jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew;
  public static int l = 1;
  public static int m = 2;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Vector jdField_a_of_type_JavaUtilVector;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  List jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = -1L;
  List jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = -1L;
  List jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int e = 0;
  int f = 0;
  int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  private int n = -1;
  
  private MemoryClearManagerNew()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP", 0);
    if (localSharedPreferences.contains("lastShotTime")) {
      localSharedPreferences.edit().clear().commit();
    }
    localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
    long l1 = localSharedPreferences.getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l1) >= 43200000L)
    {
      if (0.001F >= Math.random()) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      localSharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", this.jdField_a_of_type_Boolean).apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryClearManagerNew", 2, "MemoryClearManagerNew init needReport= " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      return;
      this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("lastShotResult", false);
    }
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Long > 0L) {}
    for (long l1 = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;; l1 = -1L) {
      return (int)l1;
    }
  }
  
  public static MemoryClearManagerNew a()
  {
    if (jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew == null) {
        jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew = new MemoryClearManagerNew();
      }
      return jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew;
    }
    finally {}
  }
  
  private static String a(Exception paramException)
  {
    if (paramException == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramException = paramException.getStackTrace();
    int i2 = 0;
    int i1 = 1;
    for (;;)
    {
      String str;
      if (i1 < paramException.length)
      {
        str = paramException[i1].toString();
        if (localStringBuilder.length() != 0) {
          break label88;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i2 += 1;
        if (i2 < 16) {
          break;
        }
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("]");
        }
        return localStringBuilder.toString();
        label88:
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    String str;
    if (a().jdField_a_of_type_Boolean)
    {
      str = a(new IllegalStateException("reportMemoryMsg : " + paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("CommonMemoryCache", 2, "reportMemoryMsg|stack= " + str);
      }
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        break label198;
      }
    }
    label198:
    for (Object localObject = ((AppRuntime)localObject).getAccount();; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_stack", str);
      localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
      if (paramInt == m)
      {
        str = "sImageCacheKey";
        localHashMap.put("key", paramString);
        paramString = str;
      }
      for (;;)
      {
        if (paramString != null) {
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a((String)localObject, paramString, true, 0L, 0L, localHashMap, "", true);
        }
        return;
        if (paramInt == l)
        {
          str = "DexPathListHook";
          localHashMap.put("name", paramString);
          paramString = str;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, CacheInfo paramCacheInfo, int paramInt1, int paramInt2)
  {
    if ((paramCacheInfo == null) || (paramJSONObject == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", paramInt1);
        localJSONObject.put("action", paramInt2);
        localJSONObject.put("capacity", paramCacheInfo.capacity);
        localJSONObject.put("size", paramCacheInfo.size);
        localJSONObject.put("getCount", paramCacheInfo.getCount);
        localJSONObject.put("putCount", paramCacheInfo.putCount);
        if (paramCacheInfo.putCount <= 0) {
          break label306;
        }
        localJSONObject.put("getRate", paramCacheInfo.getCount / paramCacheInfo.putCount);
        localJSONObject.put("removeCount", paramCacheInfo.removeCount);
        localJSONObject.put("hitCount", paramCacheInfo.hitCount);
        localJSONObject.put("missCount", paramCacheInfo.missCount);
        if ((paramCacheInfo.hitCount <= 0) && (paramCacheInfo.missCount <= 0)) {
          break label321;
        }
        localJSONObject.put("hitRate", paramCacheInfo.hitCount / (paramCacheInfo.hitCount + paramCacheInfo.missCount));
        localJSONObject.put("lifeTime", paramCacheInfo.lifeTime);
        localJSONObject.put("gapTime", paramCacheInfo.gapTime);
        localJSONObject.put("MemorySize", paramCacheInfo.mMemorySize);
        localJSONObject.put("ClearSize", paramCacheInfo.mClearSize);
        if (!(paramCacheInfo instanceof HashMapInfo)) {
          break label336;
        }
        localJSONObject.put("extra_traversalCount", ((HashMapInfo)paramCacheInfo).traversalCount);
        paramJSONObject.put(String.valueOf(paramCacheInfo.tagId), localJSONObject);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MemoryClearManagerNew", 2, paramJSONObject.toString());
      return;
      label306:
      localJSONObject.put("getRate", -1.0D);
      continue;
      label321:
      localJSONObject.put("hitRate", -1.0D);
      continue;
      label336:
      if ((paramCacheInfo instanceof LruCacheInfo)) {
        localJSONObject.put("extra_evictionCount", ((LruCacheInfo)paramCacheInfo).evictionCount);
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long) >= paramInt;
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_Long	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifle +23 -> 31
    //   11: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   14: aload_0
    //   15: getfield 56	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_Long	J
    //   18: lsub
    //   19: ldc2_w 209
    //   22: ldiv
    //   23: lstore_2
    //   24: lload_2
    //   25: l2i
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: ldc2_w 65
    //   34: lstore_2
    //   35: goto -11 -> 24
    //   38: astore 4
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 4
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	MemoryClearManagerNew
    //   26	4	1	i1	int
    //   23	12	2	l1	long
    //   38	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	38	finally
  }
  
  private void b(int paramInt)
  {
    label278:
    label281:
    label284:
    label287:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        long l1 = 0L;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 == null) {
            break label281;
          }
          localObject2 = (QQHashMap)((WeakReference)localObject2).get();
          if (localObject2 == null) {
            break label281;
          }
          localObject2 = ((QQHashMap)localObject2).getReportCacheInfo();
          a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
          l1 = ((CacheInfo)localObject2).mMemorySize + l1;
          break label281;
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 == null) {
            break label278;
          }
          localObject2 = (QQConcurrentHashMap)((WeakReference)localObject2).get();
          if (localObject2 == null) {
            break label278;
          }
          localObject2 = ((QQConcurrentHashMap)localObject2).getReportCacheInfo();
          a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
          l1 = ((CacheInfo)localObject2).mMemorySize + l1;
          break label284;
        }
        localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 != null)
          {
            localObject2 = (QQLruCache)((WeakReference)localObject2).get();
            if (localObject2 != null)
            {
              localObject2 = ((QQLruCache)localObject2).getCacheInfos();
              a(localJSONObject, (CacheInfo)localObject2, 2, paramInt);
              l1 = ((CacheInfo)localObject2).mMemorySize + l1;
              break label287;
            }
          }
        }
        else
        {
          InitMagnifierSDK.a(localJSONObject, l1);
          return;
        }
      }
      finally {}
      break label287;
      break label284;
      continue;
    }
  }
  
  private static int c()
  {
    int i1;
    int i2;
    Object localObject;
    if (BaseApplicationImpl.sImageHashMap != null)
    {
      Iterator localIterator = BaseApplicationImpl.sImageHashMap.values().iterator();
      i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label89;
      }
      localObject = localIterator.next();
      if ((localObject instanceof Bitmap)) {
        i1 += Utils.getBitmapSize((Bitmap)localObject);
      }
    }
    for (;;)
    {
      break;
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          i1 += Utils.getBitmapSize((Bitmap)localObject);
          continue;
          i2 = 0;
          label89:
          return i2 / 1024;
        }
      }
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
        break label81;
      }
      StringBuilder localStringBuilder = new StringBuilder(50);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
    }
    String str = localObject.toString();
    return str;
    label81:
    return "-1";
  }
  
  public void a()
  {
    a(2);
    DexPathListHook.a(BaseApplicationImpl.class.getClassLoader());
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "reportMemoryInfo|action= " + paramInt);
    }
    long l2 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
    if (paramInt == 1) {}
    for (String str2 = "low_mem_report_rdm_time";; str2 = "bg_mem_report_rdm_time")
    {
      long l1 = localSharedPreferences.getLong(str2, 0L);
      HashMap localHashMap;
      String str1;
      label142:
      long l3;
      if (l1 > 0L) {
        if (Math.abs(l2 - l1) > 7200000L)
        {
          localHashMap = new HashMap();
          if (!MemoryConfigs.a().a.jdField_a_of_type_Boolean) {
            break label531;
          }
          str1 = "1";
          localHashMap.put("ClearEnable", str1);
          localHashMap.put("DpcConfigId", MemoryConfigs.a().a.jdField_a_of_type_JavaLangString);
          localHashMap.put("trimCount", String.valueOf(this.jdField_d_of_type_Int));
          localHashMap.put("topTrimCount", String.valueOf(this.e));
          localHashMap.put("secondTrimCount", String.valueOf(this.f));
          localHashMap.put("thirdTrimCount", String.valueOf(this.g));
          localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
          l1 = Runtime.getRuntime().maxMemory() / 1024L;
          l3 = Runtime.getRuntime().totalMemory() / 1024L;
          int i1 = (int)(1000L * l3 / l1);
          localHashMap.put("maxMemory", String.valueOf(l1));
          localHashMap.put("totalMemory", String.valueOf(l3));
          localHashMap.put("memoryPercent", String.valueOf(i1));
          localHashMap.put("freeMemory", String.valueOf(Runtime.getRuntime().freeMemory() / 1024L));
          localHashMap.put("clearTotalMem", String.valueOf(this.jdField_d_of_type_Long));
          str1 = null;
          if (paramInt != 2) {
            break label539;
          }
          str1 = "memory_info_on_bg_guard";
          localHashMap.put("memoryPss", String.valueOf(MemoryManager.a(Process.myPid()) / 1024L));
          label396:
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, str1, true, 0L, 0L, localHashMap, null);
          localSharedPreferences.edit().putLong(str2, l2).commit();
        }
      }
      for (;;)
      {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label638;
        }
        str1 = "cacheReportLastTime";
        if (paramInt == 1) {
          str1 = "lowReportLastTime";
        }
        l3 = localSharedPreferences.getLong(str1, 0L);
        l1 = 43200000L;
        if (paramInt == 1) {
          l1 = 14400000L;
        }
        if (l3 <= 0L) {
          break label640;
        }
        if (Math.abs(l2 - l3) <= l1) {
          break;
        }
        b(paramInt);
        localSharedPreferences.edit().putLong(str1, l2).commit();
        return;
        label531:
        str1 = "0";
        break label142;
        label539:
        if (paramInt != 1) {
          break label396;
        }
        str1 = "memory_info_on_low_report";
        localHashMap.put("everEnterStory", String.valueOf(this.h));
        localHashMap.put("everEnterAIOCapture", String.valueOf(this.i));
        localHashMap.put("enterStory", String.valueOf(this.j));
        localHashMap.put("enterAIOCapture", String.valueOf(this.k));
        break label396;
        localSharedPreferences.edit().putLong(str2, l2).apply();
      }
      label638:
      break;
      label640:
      localSharedPreferences.edit().putLong(str1, l2).commit();
      return;
    }
  }
  
  public void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    ClearMemoryConfig localClearMemoryConfig = MemoryConfigs.a().a;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onNeedTrimMemory|clear= " + localClearMemoryConfig.jdField_a_of_type_Boolean + "configId" + localClearMemoryConfig.jdField_a_of_type_JavaLangString);
    }
    int i1 = paramMemoryLevelInfo.jdField_b_of_type_Int;
    if (a(localClearMemoryConfig.jdField_b_of_type_Int * i1 * 1000)) {
      b(paramInt, paramMemoryLevelInfo);
    }
  }
  
  public void a(long paramLong)
  {
    a(1);
  }
  
  public void a(MemoryClearManagerNew.IClearMemoryListener paramIClearMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramIClearMemoryListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = (int)(Runtime.getRuntime().totalMemory() * 1000L / Runtime.getRuntime().maxMemory());
    long l1;
    HashMap localHashMap;
    String str1;
    if ((i1 > 600) && (i1 - this.n > 250) && (this.jdField_a_of_type_Boolean))
    {
      l1 = System.currentTimeMillis();
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
      long l2 = ((SharedPreferences)???).getLong("memory_increase_report_time", 0L);
      if (l2 <= 0L) {
        break label441;
      }
      if (Math.abs(l1 - l2) > 7200000L)
      {
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        if (localBaseActivity != null)
        {
          localHashMap = new HashMap();
          localHashMap.put("lastPer", String.valueOf(this.n));
          localHashMap.put("curPer", String.valueOf(i1));
          localHashMap.put("memInfo", a());
          localHashMap.put("totalMemory", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
          localHashMap.put("topActivity", localBaseActivity.getClass().getSimpleName());
          if (!paramBoolean) {
            break label418;
          }
          str1 = "1";
          localHashMap.put("isForeground", str1);
          localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
          if (!(localBaseActivity instanceof SplashActivity)) {
            break label426;
          }
          int i2 = SplashActivity.jdField_a_of_type_Int;
          int i3 = ((SplashActivity)localBaseActivity).a();
          localHashMap.put("splashActInfo", "cur=" + i2 + "tab=" + i3);
          label312:
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "MemoryIncreaseInfo", true, 0L, 0L, localHashMap, "", true);
          ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() >= 16)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.poll();
          break label478;
          str1 = str1 + i1;
          this.jdField_a_of_type_JavaUtilLinkedList.offer(str1);
          return;
          label418:
          str1 = "0";
          break;
          label426:
          localHashMap.put("splashActInfo", "-1");
          break label312;
          label441:
          ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
          continue;
          str1 = "0";
        }
      }
      label478:
      if (paramBoolean) {
        String str2 = "1";
      }
    }
  }
  
  public void addConCurrentHashMap(QQConcurrentHashMap paramQQConcurrentHashMap)
  {
    if (paramQQConcurrentHashMap != null) {
      this.jdField_b_of_type_JavaUtilList.add(new WeakReference(paramQQConcurrentHashMap));
    }
  }
  
  public void addHashMap(QQHashMap paramQQHashMap)
  {
    if (paramQQHashMap != null) {
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramQQHashMap));
    }
  }
  
  public void addLruCache(LruCache paramLruCache)
  {
    if (paramLruCache != null) {
      this.jdField_d_of_type_JavaUtilList.add(new WeakReference(paramLruCache));
    }
  }
  
  public void addQQLruCache(QQLruCache paramQQLruCache)
  {
    if (paramQQLruCache != null) {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(paramQQLruCache));
    }
  }
  
  public void b()
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom", 0);
      if (localSharedPreferences.contains("trim_count")) {
        localSharedPreferences.edit().clear().commit();
      }
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom_" + BaseApplicationImpl.sProcessId, 0);
      localSharedPreferences.edit().putInt("trim_count", this.jdField_d_of_type_Int);
      localSharedPreferences.edit().putInt("trim_count_top", this.e);
      localSharedPreferences.edit().putInt("trim_count_second", this.f);
      localSharedPreferences.edit().putInt("trim_count_third", this.g);
      localSharedPreferences.edit().putInt("trim_interval", a());
      localSharedPreferences.edit().putInt("detection_interval", b());
      localSharedPreferences.edit().putInt("img_size", BaseApplicationImpl.sImageCache.size() / 1024);
      localSharedPreferences.edit().putInt("img_init_maxsize", BaseApplicationImpl.sImageCacheSize / 1024);
      localSharedPreferences.edit().putInt("img_cur_maxsize", BaseApplicationImpl.sImageCache.maxSize() / 1024);
      localSharedPreferences.edit().putInt("img_hashmap_size", c());
      localSharedPreferences.edit().putInt("clear_type", this.jdField_c_of_type_Int);
      localSharedPreferences.edit().putLong("clear_size", this.jdField_c_of_type_Long);
      localSharedPreferences.edit().putLong("clear_total_size", this.jdField_d_of_type_Long);
      localSharedPreferences.edit().putInt("dect_total_memory", this.jdField_a_of_type_Int);
      localSharedPreferences.edit().putInt("trim_total_memory", this.jdField_b_of_type_Int);
      localSharedPreferences.edit().putString("total_memory_info", a());
      localSharedPreferences.edit().putLong("total_size", Runtime.getRuntime().totalMemory() / 1024L);
      localSharedPreferences.edit().putLong("free_size", Runtime.getRuntime().freeMemory() / 1024L);
      localSharedPreferences.edit().putLong("heap_size", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
      localSharedPreferences.edit().putString("clear_config_id", MemoryConfigs.a().a.jdField_a_of_type_JavaLangString);
      localSharedPreferences.edit().putBoolean("clear_config_enable", MemoryConfigs.a().a.jdField_a_of_type_Boolean);
      localSharedPreferences.edit().commit();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public void b(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 190
    //   10: iconst_2
    //   11: ldc_w 737
    //   14: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   20: lstore 22
    //   22: iload_1
    //   23: iconst_1
    //   24: if_icmpeq +8 -> 32
    //   27: iload_1
    //   28: iconst_2
    //   29: if_icmpne +1692 -> 1721
    //   32: aload_0
    //   33: getfield 203	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   36: astore 26
    //   38: aload 26
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 203	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   45: invokevirtual 738	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   48: astore 27
    //   50: iconst_0
    //   51: istore 5
    //   53: aload 27
    //   55: invokeinterface 405 1 0
    //   60: ifeq +26 -> 86
    //   63: iload 5
    //   65: aload 27
    //   67: invokeinterface 409 1 0
    //   72: checkcast 740	com/tencent/common/cache/MemoryClearManagerNew$IClearMemoryListener
    //   75: invokeinterface 741 1 0
    //   80: iadd
    //   81: istore 5
    //   83: goto -30 -> 53
    //   86: aload 26
    //   88: monitorexit
    //   89: iload 5
    //   91: i2l
    //   92: lstore 16
    //   94: iload 5
    //   96: i2l
    //   97: lstore 14
    //   99: lconst_0
    //   100: lload 14
    //   102: ladd
    //   103: lstore 14
    //   105: lconst_0
    //   106: lload 16
    //   108: ladd
    //   109: lstore 16
    //   111: iload 5
    //   113: istore 7
    //   115: getstatic 692	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   118: invokevirtual 695	android/support/v4/util/MQLruCache:size	()I
    //   121: istore 5
    //   123: iload 5
    //   125: i2f
    //   126: fstore_3
    //   127: aload_2
    //   128: getfield 744	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:jdField_b_of_type_Float	F
    //   131: fstore 4
    //   133: fload_3
    //   134: fload 4
    //   136: fmul
    //   137: f2i
    //   138: istore 6
    //   140: iload 5
    //   142: i2l
    //   143: lstore 18
    //   145: getstatic 692	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   148: iload 6
    //   150: invokevirtual 747	android/support/v4/util/MQLruCache:trimToSize	(I)V
    //   153: aload_2
    //   154: getfield 749	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:a	F
    //   157: fconst_0
    //   158: fcmpl
    //   159: ifle +46 -> 205
    //   162: aload_2
    //   163: getfield 749	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:a	F
    //   166: fconst_1
    //   167: fcmpg
    //   168: ifge +37 -> 205
    //   171: invokestatic 751	com/tencent/mobileqq/app/MemoryManager:a	()J
    //   174: lconst_1
    //   175: lmul
    //   176: ldc2_w 752
    //   179: ldiv
    //   180: lstore 20
    //   182: getstatic 692	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   185: invokevirtual 705	android/support/v4/util/MQLruCache:maxSize	()I
    //   188: i2l
    //   189: lload 20
    //   191: lcmp
    //   192: iflt +13 -> 205
    //   195: getstatic 692	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   198: aload_2
    //   199: getfield 749	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:a	F
    //   202: invokevirtual 757	android/support/v4/util/MQLruCache:resetMaxSize	(F)V
    //   205: iconst_0
    //   206: iload 5
    //   208: iload 6
    //   210: isub
    //   211: iadd
    //   212: istore 13
    //   214: iload 13
    //   216: i2l
    //   217: lstore 20
    //   219: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +30 -> 252
    //   225: ldc 190
    //   227: iconst_2
    //   228: new 128	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 759
    //   238: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: iload 5
    //   243: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: iconst_0
    //   253: istore 8
    //   255: iconst_0
    //   256: istore 5
    //   258: getstatic 439	com/tencent/common/app/BaseApplicationImpl:sImageHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   261: ifnull +1472 -> 1733
    //   264: getstatic 439	com/tencent/common/app/BaseApplicationImpl:sImageHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   267: invokevirtual 445	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   270: invokeinterface 448 1 0
    //   275: astore 26
    //   277: aload 26
    //   279: invokeinterface 405 1 0
    //   284: ifeq +97 -> 381
    //   287: aload 26
    //   289: invokeinterface 409 1 0
    //   294: astore 27
    //   296: aload 27
    //   298: instanceof 450
    //   301: ifeq +44 -> 345
    //   304: aload 27
    //   306: checkcast 450	android/graphics/Bitmap
    //   309: invokestatic 456	com/tencent/image/Utils:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   312: istore 6
    //   314: iload 6
    //   316: iload 5
    //   318: iadd
    //   319: istore 5
    //   321: goto -44 -> 277
    //   324: astore_2
    //   325: aload 26
    //   327: monitorexit
    //   328: aload_2
    //   329: athrow
    //   330: astore_2
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_2
    //   334: athrow
    //   335: astore 26
    //   337: aload 26
    //   339: invokevirtual 762	java/lang/Exception:printStackTrace	()V
    //   342: goto -137 -> 205
    //   345: aload 27
    //   347: instanceof 458
    //   350: ifeq +1368 -> 1718
    //   353: aload 27
    //   355: checkcast 458	android/graphics/drawable/BitmapDrawable
    //   358: invokevirtual 462	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   361: astore 27
    //   363: aload 27
    //   365: ifnull +1353 -> 1718
    //   368: aload 27
    //   370: invokestatic 456	com/tencent/image/Utils:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   373: iload 5
    //   375: iadd
    //   376: istore 5
    //   378: goto -57 -> 321
    //   381: getstatic 439	com/tencent/common/app/BaseApplicationImpl:sImageHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   384: invokevirtual 764	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   387: iload 5
    //   389: istore 8
    //   391: goto +1342 -> 1733
    //   394: aload_0
    //   395: getfield 52	com/tencent/common/cache/MemoryClearManagerNew:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   398: invokeinterface 400 1 0
    //   403: astore 26
    //   405: aload 26
    //   407: invokeinterface 405 1 0
    //   412: ifeq +1365 -> 1777
    //   415: aload 26
    //   417: invokeinterface 409 1 0
    //   422: checkcast 411	java/lang/ref/WeakReference
    //   425: astore 27
    //   427: aload 27
    //   429: ifnull +1345 -> 1774
    //   432: aload 27
    //   434: invokevirtual 414	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   437: checkcast 427	com/tencent/commonsdk/cache/QQLruCache
    //   440: astore 28
    //   442: aload 28
    //   444: ifnull +54 -> 498
    //   447: aload 28
    //   449: invokevirtual 430	com/tencent/commonsdk/cache/QQLruCache:getCacheInfos	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   452: getfield 362	com/tencent/commonsdk/cache/CacheInfo:mMemorySize	I
    //   455: i2l
    //   456: lstore 18
    //   458: aload 28
    //   460: aload 28
    //   462: invokevirtual 765	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   465: i2f
    //   466: aload_2
    //   467: getfield 744	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:jdField_b_of_type_Float	F
    //   470: fmul
    //   471: f2i
    //   472: invokevirtual 768	com/tencent/commonsdk/cache/QQLruCache:clearOnLowMemory	(I)V
    //   475: aload 28
    //   477: invokevirtual 430	com/tencent/commonsdk/cache/QQLruCache:getCacheInfos	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   480: getfield 367	com/tencent/commonsdk/cache/CacheInfo:mClearSize	I
    //   483: iload 5
    //   485: iadd
    //   486: istore 5
    //   488: lload 14
    //   490: lload 18
    //   492: ladd
    //   493: lstore 14
    //   495: goto +1276 -> 1771
    //   498: aload_0
    //   499: getfield 52	com/tencent/common/cache/MemoryClearManagerNew:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   502: aload 27
    //   504: invokeinterface 771 2 0
    //   509: pop
    //   510: goto +1264 -> 1774
    //   513: aload_0
    //   514: getfield 54	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   517: astore 26
    //   519: aload 26
    //   521: invokeinterface 772 1 0
    //   526: istore 6
    //   528: aload 26
    //   530: invokeinterface 400 1 0
    //   535: astore 27
    //   537: aload 27
    //   539: invokeinterface 405 1 0
    //   544: ifeq +78 -> 622
    //   547: aload 27
    //   549: invokeinterface 409 1 0
    //   554: checkcast 411	java/lang/ref/WeakReference
    //   557: astore 28
    //   559: aload 28
    //   561: ifnull +1247 -> 1808
    //   564: aload 28
    //   566: invokevirtual 414	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   569: checkcast 774	android/support/v4/util/LruCache
    //   572: astore 29
    //   574: aload 29
    //   576: ifnull +33 -> 609
    //   579: aload 29
    //   581: aload 29
    //   583: invokevirtual 775	android/support/v4/util/LruCache:size	()I
    //   586: i2f
    //   587: aload_2
    //   588: getfield 744	com/tencent/common/cache/ClearMemoryConfig$MemoryLevelInfo:jdField_b_of_type_Float	F
    //   591: fmul
    //   592: f2i
    //   593: invokevirtual 776	android/support/v4/util/LruCache:trimToSize	(I)V
    //   596: aload 29
    //   598: invokevirtual 779	android/support/v4/util/LruCache:getClearMemory	()I
    //   601: iload 5
    //   603: iadd
    //   604: istore 5
    //   606: goto +1199 -> 1805
    //   609: aload 26
    //   611: aload 28
    //   613: invokeinterface 771 2 0
    //   618: pop
    //   619: goto +1189 -> 1808
    //   622: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +1186 -> 1811
    //   628: ldc 190
    //   630: iconst_2
    //   631: new 128	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   638: ldc_w 781
    //   641: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: iload 6
    //   646: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   649: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: goto +1156 -> 1811
    //   658: iconst_0
    //   659: istore 5
    //   661: iload_1
    //   662: iconst_1
    //   663: if_icmpne +1037 -> 1700
    //   666: aload_0
    //   667: getfield 50	com/tencent/common/cache/MemoryClearManagerNew:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   670: invokeinterface 400 1 0
    //   675: astore_2
    //   676: aload_2
    //   677: invokeinterface 405 1 0
    //   682: ifeq +1150 -> 1832
    //   685: aload_2
    //   686: invokeinterface 409 1 0
    //   691: checkcast 411	java/lang/ref/WeakReference
    //   694: astore 26
    //   696: aload 26
    //   698: ifnull +1131 -> 1829
    //   701: aload 26
    //   703: invokevirtual 414	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   706: checkcast 424	com/tencent/commonsdk/cache/QQConcurrentHashMap
    //   709: astore 27
    //   711: aload 27
    //   713: ifnull +45 -> 758
    //   716: aload 27
    //   718: invokevirtual 425	com/tencent/commonsdk/cache/QQConcurrentHashMap:getReportCacheInfo	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   721: getfield 362	com/tencent/commonsdk/cache/CacheInfo:mMemorySize	I
    //   724: i2l
    //   725: lstore 18
    //   727: aload 27
    //   729: invokevirtual 784	com/tencent/commonsdk/cache/QQConcurrentHashMap:onClearOnLowMemory	()V
    //   732: aload 27
    //   734: invokevirtual 425	com/tencent/commonsdk/cache/QQConcurrentHashMap:getReportCacheInfo	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   737: checkcast 369	com/tencent/commonsdk/cache/HashMapInfo
    //   740: getfield 785	com/tencent/commonsdk/cache/HashMapInfo:mClearSize	I
    //   743: iload 5
    //   745: iadd
    //   746: istore 5
    //   748: lload 14
    //   750: lload 18
    //   752: ladd
    //   753: lstore 14
    //   755: goto +1071 -> 1826
    //   758: aload_0
    //   759: getfield 50	com/tencent/common/cache/MemoryClearManagerNew:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   762: aload 26
    //   764: invokeinterface 771 2 0
    //   769: pop
    //   770: goto +1059 -> 1829
    //   773: iconst_0
    //   774: istore 5
    //   776: iload_1
    //   777: iconst_1
    //   778: if_icmpne +908 -> 1686
    //   781: aload_0
    //   782: getfield 48	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   785: invokeinterface 400 1 0
    //   790: astore_2
    //   791: aload_2
    //   792: invokeinterface 405 1 0
    //   797: ifeq +1056 -> 1853
    //   800: aload_2
    //   801: invokeinterface 409 1 0
    //   806: checkcast 411	java/lang/ref/WeakReference
    //   809: astore 26
    //   811: aload 26
    //   813: ifnull +1037 -> 1850
    //   816: aload 26
    //   818: invokevirtual 414	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   821: checkcast 416	com/tencent/commonsdk/cache/QQHashMap
    //   824: astore 27
    //   826: aload 27
    //   828: ifnull +42 -> 870
    //   831: aload 27
    //   833: invokevirtual 420	com/tencent/commonsdk/cache/QQHashMap:getReportCacheInfo	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   836: getfield 362	com/tencent/commonsdk/cache/CacheInfo:mMemorySize	I
    //   839: i2l
    //   840: lstore 18
    //   842: aload 27
    //   844: invokevirtual 786	com/tencent/commonsdk/cache/QQHashMap:onClearOnLowMemory	()V
    //   847: aload 27
    //   849: invokevirtual 420	com/tencent/commonsdk/cache/QQHashMap:getReportCacheInfo	()Lcom/tencent/commonsdk/cache/CacheInfo;
    //   852: getfield 367	com/tencent/commonsdk/cache/CacheInfo:mClearSize	I
    //   855: iload 5
    //   857: iadd
    //   858: istore 5
    //   860: lload 14
    //   862: lload 18
    //   864: ladd
    //   865: lstore 14
    //   867: goto +980 -> 1847
    //   870: aload_0
    //   871: getfield 48	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   874: aload 26
    //   876: invokeinterface 771 2 0
    //   881: pop
    //   882: goto +968 -> 1850
    //   885: invokestatic 792	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   888: invokevirtual 796	com/tencent/theme/SkinEngine:releasePreloadDrawableCache	()[Ljava/lang/Object;
    //   891: astore_2
    //   892: lload 20
    //   894: lstore 16
    //   896: aload_2
    //   897: arraylength
    //   898: iconst_2
    //   899: if_icmplt +1000 -> 1899
    //   902: aload_2
    //   903: iconst_0
    //   904: aaload
    //   905: instanceof 798
    //   908: ifeq +14 -> 922
    //   911: aload_2
    //   912: iconst_0
    //   913: aaload
    //   914: invokevirtual 799	java/lang/Object:toString	()Ljava/lang/String;
    //   917: invokestatic 803	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   920: istore 6
    //   922: lload 20
    //   924: lstore 16
    //   926: iload 6
    //   928: istore 5
    //   930: aload_2
    //   931: iconst_1
    //   932: aaload
    //   933: instanceof 805
    //   936: ifeq +963 -> 1899
    //   939: aload_2
    //   940: iconst_1
    //   941: aaload
    //   942: invokevirtual 799	java/lang/Object:toString	()Ljava/lang/String;
    //   945: invokestatic 809	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   948: lstore 16
    //   950: iload 6
    //   952: istore 5
    //   954: goto +945 -> 1899
    //   957: iload_1
    //   958: iconst_1
    //   959: if_icmpne +12 -> 971
    //   962: ldc 95
    //   964: invokevirtual 479	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   967: invokestatic 484	com/tencent/common/cache/DexPathListHook:a	(Ljava/lang/ClassLoader;)I
    //   970: pop
    //   971: aload_0
    //   972: lload 16
    //   974: ldc2_w 527
    //   977: ldiv
    //   978: putfield 68	com/tencent/common/cache/MemoryClearManagerNew:jdField_c_of_type_Long	J
    //   981: lload 18
    //   983: ldc2_w 527
    //   986: ldiv
    //   987: lstore 18
    //   989: aload_0
    //   990: aload_0
    //   991: getfield 70	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Long	J
    //   994: lload 16
    //   996: ladd
    //   997: putfield 70	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Long	J
    //   1000: aload_0
    //   1001: aload_0
    //   1002: getfield 72	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Int	I
    //   1005: iconst_1
    //   1006: iadd
    //   1007: putfield 72	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Int	I
    //   1010: aload_0
    //   1011: iload_1
    //   1012: putfield 64	com/tencent/common/cache/MemoryClearManagerNew:jdField_c_of_type_Int	I
    //   1015: iload_1
    //   1016: iconst_1
    //   1017: if_icmpne +616 -> 1633
    //   1020: aload_0
    //   1021: aload_0
    //   1022: getfield 74	com/tencent/common/cache/MemoryClearManagerNew:e	I
    //   1025: iconst_1
    //   1026: iadd
    //   1027: putfield 74	com/tencent/common/cache/MemoryClearManagerNew:e	I
    //   1030: aload_0
    //   1031: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   1034: putfield 60	com/tencent/common/cache/MemoryClearManagerNew:jdField_b_of_type_Long	J
    //   1037: aload_0
    //   1038: invokestatic 523	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1041: invokevirtual 531	java/lang/Runtime:totalMemory	()J
    //   1044: l2i
    //   1045: sipush 1024
    //   1048: idiv
    //   1049: putfield 62	com/tencent/common/cache/MemoryClearManagerNew:jdField_b_of_type_Int	I
    //   1052: aload_0
    //   1053: getfield 170	com/tencent/common/cache/MemoryClearManagerNew:jdField_a_of_type_Boolean	Z
    //   1056: ifeq +308 -> 1364
    //   1059: new 266	java/util/HashMap
    //   1062: dup
    //   1063: bipush 21
    //   1065: invokespecial 810	java/util/HashMap:<init>	(I)V
    //   1068: astore_2
    //   1069: aload_2
    //   1070: ldc_w 536
    //   1073: lload 18
    //   1075: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1078: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1081: pop
    //   1082: aload_2
    //   1083: ldc_w 544
    //   1086: aload_0
    //   1087: getfield 70	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Long	J
    //   1090: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1093: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1096: pop
    //   1097: aload_2
    //   1098: ldc_w 512
    //   1101: aload_0
    //   1102: getfield 72	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Int	I
    //   1105: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1108: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1111: pop
    //   1112: aload_2
    //   1113: ldc_w 812
    //   1116: iload_1
    //   1117: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1120: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: pop
    //   1124: aload_2
    //   1125: ldc_w 814
    //   1128: lload 16
    //   1130: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1133: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1136: pop
    //   1137: aload_2
    //   1138: ldc_w 816
    //   1141: iload 7
    //   1143: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1146: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1149: pop
    //   1150: aload_2
    //   1151: ldc_w 818
    //   1154: iload 13
    //   1156: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1159: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1162: pop
    //   1163: aload_2
    //   1164: ldc_w 820
    //   1167: iload 8
    //   1169: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1172: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: pop
    //   1176: aload_2
    //   1177: ldc_w 822
    //   1180: iload 9
    //   1182: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1185: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1188: pop
    //   1189: aload_2
    //   1190: ldc_w 824
    //   1193: iload 10
    //   1195: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1198: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1201: pop
    //   1202: aload_2
    //   1203: ldc_w 826
    //   1206: iload 11
    //   1208: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1211: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1214: pop
    //   1215: aload_2
    //   1216: ldc_w 828
    //   1219: iload 12
    //   1221: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1224: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1227: pop
    //   1228: aload_2
    //   1229: ldc_w 830
    //   1232: iload 5
    //   1234: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1237: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1240: pop
    //   1241: aload_2
    //   1242: ldc_w 832
    //   1245: lload 14
    //   1247: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1250: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1253: pop
    //   1254: invokestatic 523	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1257: invokevirtual 526	java/lang/Runtime:maxMemory	()J
    //   1260: ldc2_w 527
    //   1263: ldiv
    //   1264: lstore 20
    //   1266: invokestatic 523	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1269: invokevirtual 531	java/lang/Runtime:totalMemory	()J
    //   1272: invokestatic 523	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1275: invokevirtual 542	java/lang/Runtime:freeMemory	()J
    //   1278: lsub
    //   1279: ldc2_w 527
    //   1282: ldiv
    //   1283: lstore 24
    //   1285: aload_2
    //   1286: ldc_w 834
    //   1289: lload 20
    //   1291: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1294: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1297: pop
    //   1298: aload_2
    //   1299: ldc_w 836
    //   1302: invokestatic 523	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1305: invokevirtual 531	java/lang/Runtime:totalMemory	()J
    //   1308: ldc2_w 527
    //   1311: ldiv
    //   1312: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1315: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1318: pop
    //   1319: aload_2
    //   1320: ldc_w 838
    //   1323: lload 24
    //   1325: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1328: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1331: pop
    //   1332: aload_2
    //   1333: ldc_w 274
    //   1336: getstatic 138	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1339: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1342: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: pop
    //   1346: invokestatic 99	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1349: invokestatic 289	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1352: aconst_null
    //   1353: ldc_w 840
    //   1356: iconst_1
    //   1357: lconst_0
    //   1358: lconst_0
    //   1359: aload_2
    //   1360: aconst_null
    //   1361: invokevirtual 561	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1364: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   1367: lstore 20
    //   1369: new 128	java/lang/StringBuilder
    //   1372: dup
    //   1373: sipush 1024
    //   1376: invokespecial 466	java/lang/StringBuilder:<init>	(I)V
    //   1379: astore_2
    //   1380: aload_2
    //   1381: ldc_w 842
    //   1384: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: lload 18
    //   1389: invokevirtual 845	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1392: ldc_w 847
    //   1395: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload_0
    //   1399: getfield 70	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Long	J
    //   1402: invokevirtual 845	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1405: ldc_w 849
    //   1408: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: aload_0
    //   1412: getfield 72	com/tencent/common/cache/MemoryClearManagerNew:jdField_d_of_type_Int	I
    //   1415: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1418: ldc_w 851
    //   1421: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: aload_0
    //   1425: getfield 74	com/tencent/common/cache/MemoryClearManagerNew:e	I
    //   1428: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1431: ldc_w 853
    //   1434: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload_0
    //   1438: getfield 76	com/tencent/common/cache/MemoryClearManagerNew:f	I
    //   1441: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1444: ldc_w 855
    //   1447: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload_0
    //   1451: getfield 78	com/tencent/common/cache/MemoryClearManagerNew:g	I
    //   1454: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1457: ldc_w 857
    //   1460: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: iload_1
    //   1464: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1467: ldc_w 859
    //   1470: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: lload 16
    //   1475: invokevirtual 845	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1478: ldc_w 861
    //   1481: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: iload 7
    //   1486: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: ldc_w 863
    //   1492: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: iload 13
    //   1497: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: ldc_w 865
    //   1503: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: iload 8
    //   1508: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1511: ldc_w 867
    //   1514: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: iload 9
    //   1519: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1522: ldc_w 869
    //   1525: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: iload 10
    //   1530: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: ldc_w 871
    //   1536: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: iload 11
    //   1541: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1544: ldc_w 873
    //   1547: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: iload 12
    //   1552: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1555: ldc_w 875
    //   1558: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: iload 5
    //   1563: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1566: ldc_w 877
    //   1569: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: lload 14
    //   1574: invokevirtual 845	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1577: ldc_w 879
    //   1580: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: lload 20
    //   1585: lload 22
    //   1587: lsub
    //   1588: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1591: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: pop
    //   1595: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1598: ifeq +32 -> 1630
    //   1601: ldc 190
    //   1603: iconst_2
    //   1604: new 128	java/lang/StringBuilder
    //   1607: dup
    //   1608: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1611: ldc_w 881
    //   1614: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: aload_2
    //   1618: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1621: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1630: aload_0
    //   1631: monitorexit
    //   1632: return
    //   1633: iload_1
    //   1634: iconst_2
    //   1635: if_icmpne +16 -> 1651
    //   1638: aload_0
    //   1639: aload_0
    //   1640: getfield 76	com/tencent/common/cache/MemoryClearManagerNew:f	I
    //   1643: iconst_1
    //   1644: iadd
    //   1645: putfield 76	com/tencent/common/cache/MemoryClearManagerNew:f	I
    //   1648: goto -618 -> 1030
    //   1651: iload_1
    //   1652: iconst_3
    //   1653: if_icmpne -623 -> 1030
    //   1656: aload_0
    //   1657: aload_0
    //   1658: getfield 78	com/tencent/common/cache/MemoryClearManagerNew:g	I
    //   1661: iconst_1
    //   1662: iadd
    //   1663: putfield 78	com/tencent/common/cache/MemoryClearManagerNew:g	I
    //   1666: goto -636 -> 1030
    //   1669: lconst_0
    //   1670: lstore 20
    //   1672: iconst_0
    //   1673: istore 5
    //   1675: lload 14
    //   1677: lstore 16
    //   1679: lload 20
    //   1681: lstore 14
    //   1683: goto -726 -> 957
    //   1686: iconst_0
    //   1687: istore 12
    //   1689: lload 14
    //   1691: lstore 18
    //   1693: lload 16
    //   1695: lstore 14
    //   1697: goto +180 -> 1877
    //   1700: iconst_0
    //   1701: istore 11
    //   1703: goto -930 -> 773
    //   1706: iconst_0
    //   1707: istore 10
    //   1709: goto -1051 -> 658
    //   1712: iconst_0
    //   1713: istore 9
    //   1715: goto +74 -> 1789
    //   1718: goto -1397 -> 321
    //   1721: iconst_0
    //   1722: istore 7
    //   1724: lconst_0
    //   1725: lstore 14
    //   1727: lconst_0
    //   1728: lstore 16
    //   1730: goto -1615 -> 115
    //   1733: lload 16
    //   1735: lload 20
    //   1737: ladd
    //   1738: iload 8
    //   1740: i2l
    //   1741: ladd
    //   1742: lstore 16
    //   1744: lload 18
    //   1746: lload 14
    //   1748: ladd
    //   1749: iload 8
    //   1751: i2l
    //   1752: ladd
    //   1753: lstore 14
    //   1755: iconst_0
    //   1756: istore 5
    //   1758: iload_1
    //   1759: iconst_1
    //   1760: if_icmpeq -1366 -> 394
    //   1763: iload_1
    //   1764: iconst_2
    //   1765: if_icmpne -53 -> 1712
    //   1768: goto -1374 -> 394
    //   1771: goto -1366 -> 405
    //   1774: goto -3 -> 1771
    //   1777: lload 16
    //   1779: iload 5
    //   1781: i2l
    //   1782: ladd
    //   1783: lstore 16
    //   1785: iload 5
    //   1787: istore 9
    //   1789: iconst_0
    //   1790: istore 5
    //   1792: iload_1
    //   1793: iconst_1
    //   1794: if_icmpeq -1281 -> 513
    //   1797: iload_1
    //   1798: iconst_2
    //   1799: if_icmpne -93 -> 1706
    //   1802: goto -1289 -> 513
    //   1805: goto -1268 -> 537
    //   1808: goto -3 -> 1805
    //   1811: lload 16
    //   1813: iload 5
    //   1815: i2l
    //   1816: ladd
    //   1817: lstore 16
    //   1819: iload 5
    //   1821: istore 10
    //   1823: goto -1165 -> 658
    //   1826: goto -1150 -> 676
    //   1829: goto -3 -> 1826
    //   1832: lload 16
    //   1834: iload 5
    //   1836: i2l
    //   1837: ladd
    //   1838: lstore 16
    //   1840: iload 5
    //   1842: istore 11
    //   1844: goto -1071 -> 773
    //   1847: goto -1056 -> 791
    //   1850: goto -3 -> 1847
    //   1853: iload 5
    //   1855: i2l
    //   1856: lstore 18
    //   1858: lload 18
    //   1860: lload 16
    //   1862: ladd
    //   1863: lstore 16
    //   1865: iload 5
    //   1867: istore 12
    //   1869: lload 14
    //   1871: lstore 18
    //   1873: lload 16
    //   1875: lstore 14
    //   1877: iconst_0
    //   1878: istore 5
    //   1880: iconst_0
    //   1881: istore 6
    //   1883: lconst_0
    //   1884: lstore 20
    //   1886: iload_1
    //   1887: iconst_1
    //   1888: if_icmpeq -1003 -> 885
    //   1891: iload_1
    //   1892: iconst_2
    //   1893: if_icmpne -224 -> 1669
    //   1896: goto -1011 -> 885
    //   1899: lload 16
    //   1901: lstore 20
    //   1903: lload 14
    //   1905: lload 16
    //   1907: ladd
    //   1908: lstore 16
    //   1910: lload 20
    //   1912: lstore 14
    //   1914: goto -957 -> 957
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1917	0	this	MemoryClearManagerNew
    //   0	1917	1	paramInt	int
    //   0	1917	2	paramMemoryLevelInfo	ClearMemoryConfig.MemoryLevelInfo
    //   126	8	3	f1	float
    //   131	4	4	f2	float
    //   51	1828	5	i1	int
    //   138	1744	6	i2	int
    //   113	1610	7	i3	int
    //   253	1497	8	i4	int
    //   1180	608	9	i5	int
    //   1193	629	10	i6	int
    //   1206	637	11	i7	int
    //   1219	649	12	i8	int
    //   212	1284	13	i9	int
    //   97	1816	14	l1	long
    //   92	1817	16	l2	long
    //   143	1729	18	l3	long
    //   180	1731	20	l4	long
    //   20	1566	22	l5	long
    //   1283	41	24	l6	long
    //   335	3	26	localException	Exception
    //   403	472	26	localObject2	Object
    //   48	800	27	localObject3	Object
    //   440	172	28	localObject4	Object
    //   572	25	29	localLruCache	LruCache
    // Exception table:
    //   from	to	target	type
    //   41	50	324	finally
    //   53	83	324	finally
    //   86	89	324	finally
    //   325	328	324	finally
    //   2	17	330	finally
    //   17	22	330	finally
    //   32	41	330	finally
    //   115	123	330	finally
    //   127	133	330	finally
    //   145	205	330	finally
    //   219	252	330	finally
    //   258	277	330	finally
    //   277	314	330	finally
    //   328	330	330	finally
    //   337	342	330	finally
    //   345	363	330	finally
    //   368	378	330	finally
    //   381	387	330	finally
    //   394	405	330	finally
    //   405	427	330	finally
    //   432	442	330	finally
    //   447	488	330	finally
    //   498	510	330	finally
    //   513	537	330	finally
    //   537	559	330	finally
    //   564	574	330	finally
    //   579	606	330	finally
    //   609	619	330	finally
    //   622	655	330	finally
    //   666	676	330	finally
    //   676	696	330	finally
    //   701	711	330	finally
    //   716	748	330	finally
    //   758	770	330	finally
    //   781	791	330	finally
    //   791	811	330	finally
    //   816	826	330	finally
    //   831	860	330	finally
    //   870	882	330	finally
    //   885	892	330	finally
    //   896	902	330	finally
    //   902	922	330	finally
    //   930	950	330	finally
    //   962	971	330	finally
    //   971	1015	330	finally
    //   1020	1030	330	finally
    //   1030	1364	330	finally
    //   1364	1630	330	finally
    //   1638	1648	330	finally
    //   1656	1666	330	finally
    //   145	205	335	java/lang/Exception
  }
  
  public void b(MemoryClearManagerNew.IClearMemoryListener paramIClearMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramIClearMemoryListener);
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)Runtime.getRuntime().totalMemory() / 1024);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom_" + BaseApplicationImpl.sProcessId, 0);
    HashMap localHashMap;
    if (localSharedPreferences.contains("trim_count"))
    {
      localHashMap = new HashMap(23);
      localHashMap.put("trim_count", String.valueOf(localSharedPreferences.getInt("trim_count", -1)));
      localHashMap.put("trim_count_top", String.valueOf(localSharedPreferences.getInt("trim_count_top", -1)));
      localHashMap.put("trim_count_second", String.valueOf(localSharedPreferences.getInt("trim_count_second", -1)));
      localHashMap.put("trim_count_third", String.valueOf(localSharedPreferences.getInt("trim_count_third", -1)));
      localHashMap.put("trim_interval", String.valueOf(localSharedPreferences.getInt("trim_interval", -1)));
      localHashMap.put("detection_interval", String.valueOf(localSharedPreferences.getInt("detection_interval", -1)));
      localHashMap.put("img_size", String.valueOf(localSharedPreferences.getInt("img_size", -1)));
      localHashMap.put("img_init_maxsize", String.valueOf(localSharedPreferences.getInt("img_init_maxsize", -1)));
      localHashMap.put("img_cur_maxsize", String.valueOf(localSharedPreferences.getInt("img_cur_maxsize", -1)));
      localHashMap.put("img_hashmap_size", String.valueOf(localSharedPreferences.getInt("img_hashmap_size", -1)));
      localHashMap.put("clear_type", String.valueOf(localSharedPreferences.getInt("clear_type", -1)));
      localHashMap.put("clear_size", String.valueOf(localSharedPreferences.getLong("clear_size", -1L)));
      localHashMap.put("clear_total_size", String.valueOf(localSharedPreferences.getLong("clear_total_size", -1L)));
      localHashMap.put("dect_total_memory", String.valueOf(localSharedPreferences.getInt("dect_total_memory", -1)));
      localHashMap.put("trim_total_memory", String.valueOf(localSharedPreferences.getInt("trim_total_memory", -1)));
      localHashMap.put("total_memory_info", localSharedPreferences.getString("total_memory_info", "-1"));
      localHashMap.put("max_heap", String.valueOf(Runtime.getRuntime().maxMemory()));
      localHashMap.put("total_size", String.valueOf(localSharedPreferences.getLong("total_size", -1L)));
      localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
      localHashMap.put("free_size", String.valueOf(localSharedPreferences.getLong("free_size", -1L)));
      localHashMap.put("clear_config_id", localSharedPreferences.getString("clear_config_id", "0"));
      if (!localSharedPreferences.getBoolean("clear_config_enable", false)) {
        break label576;
      }
    }
    label576:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("clear_config_enable", str);
      localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "memory_oom_Info", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().remove("trim_count").commit();
      return;
    }
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onRunningBackground");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.cache.MemoryClearManagerNew
 * JD-Core Version:    0.7.0.1
 */