import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1;
import java.util.concurrent.ConcurrentHashMap;

public class beyk
{
  protected static beyk a;
  public static String a;
  protected volatile double a;
  public volatile int a;
  public volatile long a;
  private beyl a;
  protected ConcurrentHashMap<String, beym> a;
  protected boolean a;
  public volatile long b;
  public boolean b = true;
  public volatile long c;
  public volatile long d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "切换页面耗时";
  }
  
  protected beyk()
  {
    this.jdField_a_of_type_Boolean = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Beyl = new beyl(this, null);
    beyc.a().a(this.jdField_a_of_type_Beyl);
    a();
  }
  
  public static beyk a()
  {
    if (jdField_a_of_type_Beyk == null) {}
    try
    {
      if (jdField_a_of_type_Beyk == null) {
        jdField_a_of_type_Beyk = new beyk();
      }
      return jdField_a_of_type_Beyk;
    }
    finally {}
  }
  
  public long a()
  {
    int j = 0;
    long l1 = Runtime.getRuntime().maxMemory();
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    int i = j;
    if (l1 > 0L)
    {
      i = j;
      if (l2 > 0L) {
        i = (int)((float)l2 / (float)l1 * 100.0F);
      }
    }
    return i;
  }
  
  public beym a()
  {
    return a(jdField_a_of_type_JavaLangString);
  }
  
  protected beym a(beym parambeym)
  {
    long l2 = 0L;
    long l1;
    if (parambeym != null)
    {
      parambeym.jdField_c_of_type_Long = System.currentTimeMillis();
      parambeym.jdField_f_of_type_Long = SystemClock.currentThreadTimeMillis();
      l1 = parambeym.jdField_c_of_type_Long - parambeym.jdField_b_of_type_Long;
      if (l1 <= 0L) {
        break label73;
      }
    }
    for (;;)
    {
      parambeym.jdField_d_of_type_Long = l1;
      long l3 = parambeym.jdField_f_of_type_Long - parambeym.jdField_e_of_type_Long;
      l1 = l2;
      if (l3 > 0L) {
        l1 = l3;
      }
      parambeym.g = l1;
      return parambeym;
      label73:
      l1 = 0L;
    }
  }
  
  public beym a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      return null;
    }
    return (beym)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected beym a(String paramString, Thread paramThread)
  {
    beym localbeym = new beym();
    localbeym.jdField_a_of_type_JavaLangString = a(paramString, paramThread);
    if (paramThread != null)
    {
      localbeym.jdField_b_of_type_JavaLangString = paramThread.toString();
      localbeym.jdField_c_of_type_JavaLangString = paramThread.getName();
      localbeym.jdField_a_of_type_Long = paramThread.getId();
    }
    try
    {
      localbeym.jdField_a_of_type_ArrayOfJavaLangStackTraceElement = paramThread.getStackTrace();
      localbeym.jdField_b_of_type_Long = System.currentTimeMillis();
      localbeym.jdField_e_of_type_Long = SystemClock.currentThreadTimeMillis();
      return localbeym;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localbeym.jdField_a_of_type_ArrayOfJavaLangStackTraceElement = null;
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int > 0) {}
    for (String str = "CPU使用率: " + this.jdField_a_of_type_Int + "%";; str = "CPU使用率: -")
    {
      a();
      return str;
    }
  }
  
  protected String a(String paramString, Runnable paramRunnable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramRunnable == null) {
        return "null";
      }
      return paramRunnable.toString();
    }
    return paramString;
  }
  
  public void a()
  {
    bejn.a().post(new TaskMonitorManager.1(this));
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(String paramString, Runnable paramRunnable)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      paramRunnable = a(paramString, paramRunnable);
      if (betc.a()) {
        betc.a("TaskMonitorManager", "stopLooperMonitor, key is " + paramRunnable);
      }
    } while ((TextUtils.isEmpty(paramRunnable)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramRunnable)));
    paramRunnable = a((beym)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramRunnable));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramRunnable);
  }
  
  public void a(String paramString1, Thread paramThread, String paramString2, String paramString3, String paramString4)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      do
      {
        return;
        str = a(paramString1, paramThread);
      } while (TextUtils.isEmpty(str));
      if (betc.a()) {
        betc.a("TaskMonitorManager", "startLooperMonitor, key is " + paramString1);
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    beym localbeym1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      localbeym1 = (beym)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    }
    beym localbeym2 = localbeym1;
    if (localbeym1 == null) {
      localbeym2 = a(paramString1, paramThread);
    }
    localbeym2.jdField_b_of_type_Long = System.currentTimeMillis();
    localbeym2.jdField_e_of_type_Long = SystemClock.currentThreadTimeMillis();
    localbeym2.jdField_d_of_type_JavaLangString = paramString2;
    localbeym2.jdField_e_of_type_JavaLangString = paramString3;
    localbeym2.jdField_f_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localbeym2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    beym localbeym = a();
    String str;
    if (betc.a())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchPerfmPage, page url is ").append(paramString).append(", ");
      if (paramBoolean)
      {
        str = "show";
        betc.a("TaskMonitorManager", str);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label95;
      }
      str = "show";
    }
    for (;;)
    {
      if (localbeym != null)
      {
        if (paramBoolean)
        {
          a(jdField_a_of_type_JavaLangString, null);
          return;
          str = "hide";
          break;
          label95:
          str = "hide";
          continue;
        }
        a(jdField_a_of_type_JavaLangString, null, jdField_a_of_type_JavaLangString, paramString, str);
        return;
      }
    }
    a(jdField_a_of_type_JavaLangString, null, jdField_a_of_type_JavaLangString, paramString, str);
  }
  
  public String b()
  {
    long l1 = this.jdField_c_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    return "CPU已使用: " + (l1 - l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyk
 * JD-Core Version:    0.7.0.1
 */