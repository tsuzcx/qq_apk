import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1;
import java.util.concurrent.ConcurrentHashMap;

public class bdrx
{
  protected static bdrx a;
  public static String a;
  protected volatile double a;
  public volatile int a;
  public volatile long a;
  private bdry a;
  protected ConcurrentHashMap<String, bdrz> a;
  protected boolean a;
  public volatile long b;
  public boolean b = true;
  public volatile long c;
  public volatile long d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "切换页面耗时";
  }
  
  protected bdrx()
  {
    this.jdField_a_of_type_Boolean = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bdry = new bdry(this, null);
    bdrp.a().a(this.jdField_a_of_type_Bdry);
    a();
  }
  
  public static bdrx a()
  {
    if (jdField_a_of_type_Bdrx == null) {}
    try
    {
      if (jdField_a_of_type_Bdrx == null) {
        jdField_a_of_type_Bdrx = new bdrx();
      }
      return jdField_a_of_type_Bdrx;
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
  
  public bdrz a()
  {
    return a(jdField_a_of_type_JavaLangString);
  }
  
  public bdrz a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      return null;
    }
    return (bdrz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
  
  public void a()
  {
    bdew.a().post(new TaskMonitorManager.1(this));
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public String b()
  {
    long l1 = this.c;
    long l2 = this.jdField_a_of_type_Long;
    return "CPU已使用: " + (l1 - l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrx
 * JD-Core Version:    0.7.0.1
 */