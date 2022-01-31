import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bgoc
{
  private static bgoc jdField_a_of_type_Bgoc;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<bgod> jdField_a_of_type_JavaUtilList;
  
  public static bgoc a()
  {
    if (jdField_a_of_type_Bgoc == null) {}
    try
    {
      if (jdField_a_of_type_Bgoc == null) {
        jdField_a_of_type_Bgoc = new bgoc();
      }
      return jdField_a_of_type_Bgoc;
    }
    finally {}
  }
  
  public static void a()
  {
    bgoc localbgoc = a();
    if (localbgoc != null) {
      localbgoc.e();
    }
  }
  
  private void a(bgod parambgod)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + parambgod);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(parambgod);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    bgoc localbgoc = a();
    if (localbgoc != null) {
      localbgoc.a(new bgod(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    bgoc localbgoc = a();
    if (localbgoc != null) {
      localbgoc.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    bgoc localbgoc = a();
    if (localbgoc != null) {
      localbgoc.i();
    }
  }
  
  private void i()
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
    }
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        List localList = this.jdField_a_of_type_JavaUtilList;
        this.jdField_a_of_type_JavaUtilList = null;
        if ((localList != null) && (localList.size() != 0))
        {
          ??? = axrn.a(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            bgod localbgod = (bgod)localIterator.next();
            ((axrn)???).a(localbgod.a(), localbgod.b(), localbgod.a(), localbgod.a(), localbgod.b(), localbgod.a(), null);
          }
        }
      }
    }
    localObject1.clear();
  }
  
  protected void c() {}
  
  protected void d()
  {
    f();
    try
    {
      jdField_a_of_type_Bgoc = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new QlinkReliableReport.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  public void f()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoc
 * JD-Core Version:    0.7.0.1
 */