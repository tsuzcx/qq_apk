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
import com.tencent.mobileqq.app.ThreadManager;
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

public class axrg
  implements Handler.Callback, Foreground.AppLifeCycleCallback
{
  private static axrg jdField_a_of_type_Axrg;
  private int jdField_a_of_type_Int = 0;
  private akaj jdField_a_of_type_Akaj = new akaj();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("scene_tracker" + BaseApplicationImpl.sProcessId, 0);
  public Handler a;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(axrh.class, 5);
  private LinkedHashMap<String, axrh> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(4);
  private LinkedList<axrh> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private axrg()
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
  
  public static axrg a()
  {
    if (jdField_a_of_type_Axrg == null) {}
    try
    {
      if (jdField_a_of_type_Axrg == null) {
        jdField_a_of_type_Axrg = new axrg();
      }
      return jdField_a_of_type_Axrg;
    }
    finally {}
  }
  
  private void a(axrh paramaxrh)
  {
    if ((paramaxrh.jdField_a_of_type_Int > 0) && (Math.random() < 0.1500000059604645D)) {
      if (paramaxrh.jdField_c_of_type_JavaLangString == null)
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
          localHashMap.put("stage", paramaxrh.jdField_a_of_type_JavaLangString);
          localHashMap.put("nestStage", paramaxrh.jdField_c_of_type_JavaLangString);
          localHashMap.put("fromStage", paramaxrh.jdField_b_of_type_JavaLangString);
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          localHashMap.put("startPss", String.valueOf(paramaxrh.g / 1024L));
          localHashMap.put("startHeap", String.valueOf(paramaxrh.jdField_a_of_type_Long / 1024L));
          localHashMap.put("startCache", String.valueOf(paramaxrh.jdField_c_of_type_Long / 1024L));
          localHashMap.put("startNativePss", String.valueOf(paramaxrh.h / 1024L));
          if (paramaxrh.jdField_a_of_type_Int > 0)
          {
            localHashMap.put("avgPss", String.valueOf(paramaxrh.k / paramaxrh.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgHeap", String.valueOf(paramaxrh.m / paramaxrh.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgNativePss", String.valueOf(paramaxrh.l / paramaxrh.jdField_a_of_type_Int / 1024L));
          }
          localHashMap.put("maxPss", String.valueOf(paramaxrh.n / 1024L));
          localHashMap.put("maxNativePss", String.valueOf(paramaxrh.o / 1024L));
          localHashMap.put("maxHeap", String.valueOf(paramaxrh.p / 1024L));
          localHashMap.put("endPss", String.valueOf(paramaxrh.i / 1024L));
          localHashMap.put("endNativePss", String.valueOf(paramaxrh.j / 1024L));
          localHashMap.put("endHeap", String.valueOf(paramaxrh.d / 1024L));
          localHashMap.put("endCache", String.valueOf(paramaxrh.f / 1024L));
          if (paramaxrh.jdField_a_of_type_Boolean)
          {
            ??? = "0";
            localHashMap.put("firstTrack", ???);
            localHashMap.put("processId", String.valueOf(BaseApplicationImpl.sProcessId));
            axrl.a(BaseApplicationImpl.getContext()).a("", "actSceneMem", true, 0L, 0L, localHashMap, "");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SceneTracker", 2, new Object[] { paramaxrh.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramaxrh.jdField_a_of_type_Long), "->", Long.valueOf(paramaxrh.d), "; free:", Long.valueOf(paramaxrh.jdField_b_of_type_Long), "->", Long.valueOf(paramaxrh.e) });
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramaxrh)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramaxrh);
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
  
  private boolean a(akaj paramakaj, long paramLong1, long paramLong2, axrh paramaxrh)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        axrh localaxrh = (axrh)localIterator.next();
        if (localaxrh != paramaxrh)
        {
          localaxrh.m += paramLong1;
          localaxrh.l = paramakaj.jdField_b_of_type_Long;
          localaxrh.k += paramakaj.jdField_a_of_type_Long;
          localaxrh.n = Math.max(paramakaj.jdField_a_of_type_Long, localaxrh.n);
          localaxrh.jdField_a_of_type_Int += 1;
          localaxrh.o = Math.max(paramakaj.jdField_b_of_type_Long, localaxrh.o);
          localaxrh.p = Math.max(paramLong1, localaxrh.p);
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
              axrh localaxrh = (axrh)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
              long l1;
              if (localaxrh.d == 0L)
              {
                l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                if (localaxrh.e == 0L)
                {
                  l2 = Runtime.getRuntime().freeMemory();
                  localStringBuilder.append(localaxrh.jdField_a_of_type_JavaLangString).append("(From ").append(localaxrh.jdField_b_of_type_JavaLangString).append(")").append(":Alloc ").append(localaxrh.jdField_a_of_type_Long).append("->").append(l1).append(";Free ").append(localaxrh.jdField_b_of_type_Long).append("->").append(l2).append("|");
                  i -= 1;
                }
              }
              else
              {
                l1 = localaxrh.d;
                continue;
              }
              long l2 = localaxrh.e;
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
    axrh localaxrh2 = (axrh)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(axrh.class);
    localaxrh2.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrh2.jdField_a_of_type_Boolean = bool;
      if (localaxrh2.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0)
        {
          axrh localaxrh1 = null;
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
          while (localIterator.hasNext()) {
            localaxrh1 = (axrh)localIterator.next();
          }
          localaxrh2.jdField_b_of_type_JavaLangString = localaxrh1.jdField_a_of_type_JavaLangString;
          if (localaxrh1.jdField_c_of_type_JavaLangString == null) {
            localaxrh1.jdField_c_of_type_JavaLangString = localaxrh2.jdField_a_of_type_JavaLangString;
          }
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localaxrh2);
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 8)
        {
          paramString = (axrh)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
          if ((!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsValue(paramString)) && (!paramString.jdField_b_of_type_Boolean)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
          }
        }
        this.jdField_a_of_type_JavaUtilLinkedList.add(localaxrh2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        if (this.jdField_a_of_type_Int == 1)
        {
          localaxrh2.jdField_a_of_type_Long = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
          localaxrh2.jdField_b_of_type_Long = Runtime.getRuntime().freeMemory();
          return;
        }
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      paramString.obj = localaxrh2;
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
        paramString = (axrh)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
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
    MemoryManager.a(Process.myPid(), this.jdField_a_of_type_Akaj);
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = (axrh)paramMessage.obj;
      paramMessage.jdField_a_of_type_Long = l2;
      paramMessage.jdField_b_of_type_Long = l3;
      paramMessage.h = this.jdField_a_of_type_Akaj.jdField_b_of_type_Long;
      if (BaseApplicationImpl.sImageCache != null)
      {
        l1 = BaseApplicationImpl.sImageCache.size();
        paramMessage.jdField_c_of_type_Long = l1;
        paramMessage.g = this.jdField_a_of_type_Akaj.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_Akaj, l2, l3, paramMessage)) {
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
        paramMessage = (axrh)paramMessage.obj;
        paramMessage.d = l2;
        paramMessage.e = l3;
        paramMessage.j = this.jdField_a_of_type_Akaj.jdField_b_of_type_Long;
        if (BaseApplicationImpl.sImageCache != null) {
          l1 = BaseApplicationImpl.sImageCache.size();
        }
        paramMessage.f = l1;
        paramMessage.i = this.jdField_a_of_type_Akaj.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_Akaj, l2, l3, null)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
        a(paramMessage);
      }
      else if (a(this.jdField_a_of_type_Akaj, l2, l3, null))
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
 * Qualified Name:     axrg
 * JD-Core Version:    0.7.0.1
 */