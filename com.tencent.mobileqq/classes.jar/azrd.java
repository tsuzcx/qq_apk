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

public class azrd
  implements Handler.Callback, Foreground.AppLifeCycleCallback
{
  private static azrd jdField_a_of_type_Azrd;
  private int jdField_a_of_type_Int = 0;
  private alwl jdField_a_of_type_Alwl = new alwl();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("scene_tracker" + BaseApplicationImpl.sProcessId, 0);
  public Handler a;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(azre.class, 5);
  private LinkedHashMap<String, azre> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(4);
  private LinkedList<azre> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private azrd()
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
  
  public static azrd a()
  {
    if (jdField_a_of_type_Azrd == null) {}
    try
    {
      if (jdField_a_of_type_Azrd == null) {
        jdField_a_of_type_Azrd = new azrd();
      }
      return jdField_a_of_type_Azrd;
    }
    finally {}
  }
  
  private void a(azre paramazre)
  {
    if ((paramazre.jdField_a_of_type_Int > 0) && (Math.random() < 0.1500000059604645D)) {
      if (paramazre.jdField_c_of_type_JavaLangString == null)
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
          localHashMap.put("stage", paramazre.jdField_a_of_type_JavaLangString);
          localHashMap.put("nestStage", paramazre.jdField_c_of_type_JavaLangString);
          localHashMap.put("fromStage", paramazre.jdField_b_of_type_JavaLangString);
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          localHashMap.put("startPss", String.valueOf(paramazre.g / 1024L));
          localHashMap.put("startHeap", String.valueOf(paramazre.jdField_a_of_type_Long / 1024L));
          localHashMap.put("startCache", String.valueOf(paramazre.jdField_c_of_type_Long / 1024L));
          localHashMap.put("startNativePss", String.valueOf(paramazre.h / 1024L));
          if (paramazre.jdField_a_of_type_Int > 0)
          {
            localHashMap.put("avgPss", String.valueOf(paramazre.k / paramazre.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgHeap", String.valueOf(paramazre.m / paramazre.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgNativePss", String.valueOf(paramazre.l / paramazre.jdField_a_of_type_Int / 1024L));
          }
          localHashMap.put("maxPss", String.valueOf(paramazre.n / 1024L));
          localHashMap.put("maxNativePss", String.valueOf(paramazre.o / 1024L));
          localHashMap.put("maxHeap", String.valueOf(paramazre.p / 1024L));
          localHashMap.put("endPss", String.valueOf(paramazre.i / 1024L));
          localHashMap.put("endNativePss", String.valueOf(paramazre.j / 1024L));
          localHashMap.put("endHeap", String.valueOf(paramazre.d / 1024L));
          localHashMap.put("endCache", String.valueOf(paramazre.f / 1024L));
          if (paramazre.jdField_a_of_type_Boolean)
          {
            ??? = "0";
            localHashMap.put("firstTrack", ???);
            localHashMap.put("processId", String.valueOf(BaseApplicationImpl.sProcessId));
            azri.a(BaseApplicationImpl.getContext()).a("", "actSceneMem", true, 0L, 0L, localHashMap, "");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SceneTracker", 2, new Object[] { paramazre.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramazre.jdField_a_of_type_Long), "->", Long.valueOf(paramazre.d), "; free:", Long.valueOf(paramazre.jdField_b_of_type_Long), "->", Long.valueOf(paramazre.e) });
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramazre)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramazre);
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
  
  private boolean a(alwl paramalwl, long paramLong1, long paramLong2, azre paramazre)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        azre localazre = (azre)localIterator.next();
        if (localazre != paramazre)
        {
          localazre.m += paramLong1;
          localazre.l = paramalwl.jdField_b_of_type_Long;
          localazre.k += paramalwl.jdField_a_of_type_Long;
          localazre.n = Math.max(paramalwl.jdField_a_of_type_Long, localazre.n);
          localazre.jdField_a_of_type_Int += 1;
          localazre.o = Math.max(paramalwl.jdField_b_of_type_Long, localazre.o);
          localazre.p = Math.max(paramLong1, localazre.p);
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
              azre localazre = (azre)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
              long l1;
              if (localazre.d == 0L)
              {
                l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                if (localazre.e == 0L)
                {
                  l2 = Runtime.getRuntime().freeMemory();
                  localStringBuilder.append(localazre.jdField_a_of_type_JavaLangString).append("(From ").append(localazre.jdField_b_of_type_JavaLangString).append(")").append(":Alloc ").append(localazre.jdField_a_of_type_Long).append("->").append(l1).append(";Free ").append(localazre.jdField_b_of_type_Long).append("->").append(l2).append("|");
                  i -= 1;
                }
              }
              else
              {
                l1 = localazre.d;
                continue;
              }
              long l2 = localazre.e;
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
    azre localazre2 = (azre)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(azre.class);
    localazre2.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      localazre2.jdField_a_of_type_Boolean = bool;
      if (localazre2.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0)
        {
          azre localazre1 = null;
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
          while (localIterator.hasNext()) {
            localazre1 = (azre)localIterator.next();
          }
          localazre2.jdField_b_of_type_JavaLangString = localazre1.jdField_a_of_type_JavaLangString;
          if (localazre1.jdField_c_of_type_JavaLangString == null) {
            localazre1.jdField_c_of_type_JavaLangString = localazre2.jdField_a_of_type_JavaLangString;
          }
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localazre2);
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 8)
        {
          paramString = (azre)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
          if ((!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsValue(paramString)) && (!paramString.jdField_b_of_type_Boolean)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
          }
        }
        this.jdField_a_of_type_JavaUtilLinkedList.add(localazre2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        if (this.jdField_a_of_type_Int == 1)
        {
          localazre2.jdField_a_of_type_Long = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
          localazre2.jdField_b_of_type_Long = Runtime.getRuntime().freeMemory();
          return;
        }
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      paramString.obj = localazre2;
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
        paramString = (azre)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
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
    MemoryManager.a(Process.myPid(), this.jdField_a_of_type_Alwl);
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = (azre)paramMessage.obj;
      paramMessage.jdField_a_of_type_Long = l2;
      paramMessage.jdField_b_of_type_Long = l3;
      paramMessage.h = this.jdField_a_of_type_Alwl.jdField_b_of_type_Long;
      if (BaseApplicationImpl.sImageCache != null)
      {
        l1 = BaseApplicationImpl.sImageCache.size();
        paramMessage.jdField_c_of_type_Long = l1;
        paramMessage.g = this.jdField_a_of_type_Alwl.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_Alwl, l2, l3, paramMessage)) {
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
        paramMessage = (azre)paramMessage.obj;
        paramMessage.d = l2;
        paramMessage.e = l3;
        paramMessage.j = this.jdField_a_of_type_Alwl.jdField_b_of_type_Long;
        if (BaseApplicationImpl.sImageCache != null) {
          l1 = BaseApplicationImpl.sImageCache.size();
        }
        paramMessage.f = l1;
        paramMessage.i = this.jdField_a_of_type_Alwl.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_Alwl, l2, l3, null)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
        a(paramMessage);
      }
      else if (a(this.jdField_a_of_type_Alwl, l2, l3, null))
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
 * Qualified Name:     azrd
 * JD-Core Version:    0.7.0.1
 */