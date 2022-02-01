import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MemoryManager.DebugMemoryInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.Foreground.AppLifeCycleCallback;

public class bdlm
  implements Handler.Callback, Foreground.AppLifeCycleCallback
{
  private static bdlm jdField_a_of_type_Bdlm;
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("scene_tracker" + BaseApplicationImpl.sProcessId, 0);
  public Handler a;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(bdln.class, 5);
  private MemoryManager.DebugMemoryInfo jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
  private LinkedHashMap<String, bdln> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(4);
  private LinkedList<bdln> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private bdlm()
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_rand_time", 0L);
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("rand_rs", false))
      {
        this.jdField_a_of_type_Int = i;
        this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nest_count", 0);
        this.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nnest_count", 0);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        Foreground.registerLifeCycleCallback(this);
        if (Foreground.sCountResume <= 0) {
          break label308;
        }
      }
    }
    label303:
    label308:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      i = 1;
      break;
      if (Math.random() < 0.0005000000237487257D)
      {
        bool1 = true;
        label238:
        if (!bool1) {
          break label303;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("rpt_nest_count", 0).putInt("rpt_nnest_count", 0).apply();
        break;
        bool1 = false;
        break label238;
        i = 1;
      }
    }
  }
  
  public static bdlm a()
  {
    if (jdField_a_of_type_Bdlm == null) {}
    try
    {
      if (jdField_a_of_type_Bdlm == null) {
        jdField_a_of_type_Bdlm = new bdlm();
      }
      return jdField_a_of_type_Bdlm;
    }
    finally {}
  }
  
  private void a(bdln parambdln)
  {
    if ((parambdln.jdField_a_of_type_Int > 0) && (Math.random() < 0.1500000059604645D)) {
      if (parambdln.jdField_c_of_type_JavaLangString == null)
      {
        if (this.c >= 20) {
          break label704;
        }
        this.c += 1;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nnest_count", this.c);
      }
    }
    label704:
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i != 0)
        {
          HashMap localHashMap = new HashMap(30);
          localHashMap.put("stage", parambdln.jdField_a_of_type_JavaLangString);
          localHashMap.put("nestStage", parambdln.jdField_c_of_type_JavaLangString);
          localHashMap.put("fromStage", parambdln.jdField_b_of_type_JavaLangString);
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          localHashMap.put("startPss", String.valueOf(parambdln.g / 1024L));
          localHashMap.put("startHeap", String.valueOf(parambdln.jdField_a_of_type_Long / 1024L));
          localHashMap.put("startCache", String.valueOf(parambdln.jdField_c_of_type_Long / 1024L));
          localHashMap.put("startNativePss", String.valueOf(parambdln.h / 1024L));
          if (parambdln.jdField_a_of_type_Int > 0)
          {
            localHashMap.put("avgPss", String.valueOf(parambdln.k / parambdln.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgHeap", String.valueOf(parambdln.m / parambdln.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgNativePss", String.valueOf(parambdln.l / parambdln.jdField_a_of_type_Int / 1024L));
          }
          localHashMap.put("maxPss", String.valueOf(parambdln.n / 1024L));
          localHashMap.put("maxNativePss", String.valueOf(parambdln.o / 1024L));
          localHashMap.put("maxHeap", String.valueOf(parambdln.p / 1024L));
          localHashMap.put("endPss", String.valueOf(parambdln.i / 1024L));
          localHashMap.put("endNativePss", String.valueOf(parambdln.j / 1024L));
          localHashMap.put("endHeap", String.valueOf(parambdln.d / 1024L));
          localHashMap.put("endCache", String.valueOf(parambdln.f / 1024L));
          if (parambdln.jdField_a_of_type_Boolean)
          {
            ??? = "0";
            localHashMap.put("firstTrack", ???);
            localHashMap.put("processId", String.valueOf(BaseApplicationImpl.sProcessId));
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "actSceneMem", true, 0L, 0L, localHashMap, "");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SceneTracker", 2, new Object[] { parambdln.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(parambdln.jdField_a_of_type_Long), "->", Long.valueOf(parambdln.d), "; free:", Long.valueOf(parambdln.jdField_b_of_type_Long), "->", Long.valueOf(parambdln.e) });
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(parambdln)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(parambdln);
          }
          return;
          if (this.b < 20)
          {
            this.b += 1;
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nest_count", this.b);
            i = 1;
            continue;
            ??? = "1";
          }
        }
      }
    }
  }
  
  private boolean a(MemoryManager.DebugMemoryInfo paramDebugMemoryInfo, long paramLong1, long paramLong2, bdln parambdln)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        bdln localbdln = (bdln)localIterator.next();
        if (localbdln != parambdln)
        {
          localbdln.m += paramLong1;
          localbdln.l = paramDebugMemoryInfo.nativePss;
          localbdln.k += paramDebugMemoryInfo.pss;
          localbdln.n = Math.max(paramDebugMemoryInfo.pss, localbdln.n);
          localbdln.jdField_a_of_type_Int += 1;
          localbdln.o = Math.max(paramDebugMemoryInfo.nativePss, localbdln.o);
          localbdln.p = Math.max(paramLong1, localbdln.p);
        }
      }
    }
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0) && (this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String a()
  {
    ??? = null;
    try
    {
      localStringBuilder = new StringBuilder();
      try
      {
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
          {
            int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
            if (i >= 0)
            {
              bdln localbdln = (bdln)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
              long l1;
              if (localbdln.d == 0L)
              {
                l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                if (localbdln.e == 0L)
                {
                  l2 = Runtime.getRuntime().freeMemory();
                  localStringBuilder.append(localbdln.jdField_a_of_type_JavaLangString).append("(From ").append(localbdln.jdField_b_of_type_JavaLangString).append(")").append(":Alloc ").append(localbdln.jdField_a_of_type_Long).append("->").append(l1).append(";Free ").append(localbdln.jdField_b_of_type_Long).append("->").append(l2).append("|");
                  i -= 1;
                }
              }
              else
              {
                l1 = localbdln.d;
                continue;
              }
              long l2 = localbdln.e;
            }
            else
            {
              if (localStringBuilder != null) {
                break;
              }
              return "Exception";
            }
          }
        }
      }
      catch (Exception localException3) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        Exception localException2 = localException3;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    bdln localbdln2 = (bdln)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(bdln.class);
    localbdln2.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      localbdln2.jdField_a_of_type_Boolean = bool;
      if (localbdln2.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      bdln localbdln1;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() <= 0) {
          break label172;
        }
        localbdln1 = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
        while (localIterator.hasNext()) {
          localbdln1 = (bdln)localIterator.next();
        }
        if (localbdln1 == null) {
          return;
        }
      }
      localbdln2.jdField_b_of_type_JavaLangString = localbdln1.jdField_a_of_type_JavaLangString;
      if (localbdln1.jdField_c_of_type_JavaLangString == null) {
        localbdln1.jdField_c_of_type_JavaLangString = localbdln2.jdField_a_of_type_JavaLangString;
      }
      label172:
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localbdln2);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 8)
      {
        paramString = (bdln)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        if ((!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsValue(paramString)) && (!paramString.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(localbdln2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_a_of_type_Int == 1)
      {
        localbdln2.jdField_a_of_type_Long = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        localbdln2.jdField_b_of_type_Long = Runtime.getRuntime().freeMemory();
        return;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      paramString.obj = localbdln2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 1000L);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(paramString);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        paramString = (bdln)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
        if (paramString == null) {
          return;
        }
      }
      paramString.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Int == 1)
      {
        paramString.d = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        paramString.e = Runtime.getRuntime().freeMemory();
        if (QLog.isColorLevel()) {
          QLog.d("SceneTracker", 2, new Object[] { paramString.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramString.jdField_a_of_type_Long), "->", Long.valueOf(paramString.d), "; free:", Long.valueOf(paramString.jdField_b_of_type_Long), "->", Long.valueOf(paramString.e) });
        }
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
          {
            if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramString))
            {
              this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
              return;
            }
          }
          paramString.jdField_b_of_type_Boolean = false;
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ??? = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)???).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)???, 2000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1 = 0L;
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l3 = Runtime.getRuntime().freeMemory();
    MemoryManager.getMemoryInfo(Process.myPid(), this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo);
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = (bdln)paramMessage.obj;
      paramMessage.jdField_a_of_type_Long = l2;
      paramMessage.jdField_b_of_type_Long = l3;
      paramMessage.h = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo.nativePss;
      if (BaseApplicationImpl.sImageCache != null)
      {
        l1 = BaseApplicationImpl.sImageCache.size();
        paramMessage.jdField_c_of_type_Long = l1;
        paramMessage.g = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo.pss;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo, l2, l3, paramMessage)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
      }
    }
    for (;;)
    {
      return false;
      l1 = 0L;
      break;
      if (paramMessage.what == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        paramMessage = (bdln)paramMessage.obj;
        paramMessage.d = l2;
        paramMessage.e = l3;
        paramMessage.j = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo.nativePss;
        if (BaseApplicationImpl.sImageCache != null) {
          l1 = BaseApplicationImpl.sImageCache.size();
        }
        paramMessage.f = l1;
        paramMessage.i = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo.pss;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo, l2, l3, null)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
        a(paramMessage);
      }
      else if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$DebugMemoryInfo, l2, l3, null))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity)
  {
    a(paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    b(paramActivity.getClass().getSimpleName());
  }
  
  public void onRunningBackground()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onRunningForeground()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlm
 * JD-Core Version:    0.7.0.1
 */