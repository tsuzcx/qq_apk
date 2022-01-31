import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1;
import java.util.concurrent.ConcurrentHashMap;

public class bhbm
{
  protected static bhbm a;
  public static String a;
  protected volatile double a;
  public volatile int a;
  public volatile long a;
  private bhbn a;
  protected ConcurrentHashMap<String, bhbo> a;
  protected boolean a;
  public volatile long b;
  public boolean b = true;
  public volatile long c;
  public volatile long d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "切换页面耗时";
  }
  
  protected bhbm()
  {
    this.jdField_a_of_type_Boolean = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bhbn = new bhbn(this, null);
    bhbe.a().a(this.jdField_a_of_type_Bhbn);
    a();
  }
  
  public static bhbm a()
  {
    if (jdField_a_of_type_Bhbm == null) {}
    try
    {
      if (jdField_a_of_type_Bhbm == null) {
        jdField_a_of_type_Bhbm = new bhbm();
      }
      return jdField_a_of_type_Bhbm;
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
  
  public bhbo a()
  {
    return a(jdField_a_of_type_JavaLangString);
  }
  
  protected bhbo a(bhbo parambhbo)
  {
    long l2 = 0L;
    long l1;
    if (parambhbo != null)
    {
      parambhbo.jdField_c_of_type_Long = System.currentTimeMillis();
      parambhbo.jdField_f_of_type_Long = SystemClock.currentThreadTimeMillis();
      l1 = parambhbo.jdField_c_of_type_Long - parambhbo.jdField_b_of_type_Long;
      if (l1 <= 0L) {
        break label73;
      }
    }
    for (;;)
    {
      parambhbo.jdField_d_of_type_Long = l1;
      long l3 = parambhbo.jdField_f_of_type_Long - parambhbo.jdField_e_of_type_Long;
      l1 = l2;
      if (l3 > 0L) {
        l1 = l3;
      }
      parambhbo.g = l1;
      return parambhbo;
      label73:
      l1 = 0L;
    }
  }
  
  public bhbo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      return null;
    }
    return (bhbo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected bhbo a(String paramString, Thread paramThread)
  {
    bhbo localbhbo = new bhbo();
    localbhbo.jdField_a_of_type_JavaLangString = a(paramString, paramThread);
    if (paramThread != null)
    {
      localbhbo.jdField_b_of_type_JavaLangString = paramThread.toString();
      localbhbo.jdField_c_of_type_JavaLangString = paramThread.getName();
      localbhbo.jdField_a_of_type_Long = paramThread.getId();
    }
    try
    {
      localbhbo.jdField_a_of_type_ArrayOfJavaLangStackTraceElement = paramThread.getStackTrace();
      localbhbo.jdField_b_of_type_Long = System.currentTimeMillis();
      localbhbo.jdField_e_of_type_Long = SystemClock.currentThreadTimeMillis();
      return localbhbo;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localbhbo.jdField_a_of_type_ArrayOfJavaLangStackTraceElement = null;
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
    ThreadManager.a().post(new TaskMonitorManager.1(this));
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
      if (QMLog.isColorLevel()) {
        QMLog.d("TaskMonitorManager", "stopLooperMonitor, key is " + paramRunnable);
      }
    } while ((TextUtils.isEmpty(paramRunnable)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramRunnable)));
    paramRunnable = a((bhbo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramRunnable));
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
      if (QMLog.isColorLevel()) {
        QMLog.d("TaskMonitorManager", "startLooperMonitor, key is " + paramString1);
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    bhbo localbhbo1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      localbhbo1 = (bhbo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    }
    bhbo localbhbo2 = localbhbo1;
    if (localbhbo1 == null) {
      localbhbo2 = a(paramString1, paramThread);
    }
    localbhbo2.jdField_b_of_type_Long = System.currentTimeMillis();
    localbhbo2.jdField_e_of_type_Long = SystemClock.currentThreadTimeMillis();
    localbhbo2.jdField_d_of_type_JavaLangString = paramString2;
    localbhbo2.jdField_e_of_type_JavaLangString = paramString3;
    localbhbo2.jdField_f_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localbhbo2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    bhbo localbhbo = a();
    String str;
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchPerfmPage, page url is ").append(paramString).append(", ");
      if (paramBoolean)
      {
        str = "show";
        QMLog.d("TaskMonitorManager", str);
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
      if (localbhbo != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbm
 * JD-Core Version:    0.7.0.1
 */