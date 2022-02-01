import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class blyp
{
  private static blyp jdField_a_of_type_Blyp;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<blyq> jdField_a_of_type_JavaUtilList;
  
  public static blyp a()
  {
    if (jdField_a_of_type_Blyp == null) {}
    try
    {
      if (jdField_a_of_type_Blyp == null) {
        jdField_a_of_type_Blyp = new blyp();
      }
      return jdField_a_of_type_Blyp;
    }
    finally {}
  }
  
  public static void a()
  {
    blyp localblyp = a();
    if (localblyp != null) {
      localblyp.e();
    }
  }
  
  private void a(blyq paramblyq)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + paramblyq);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramblyq);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    blyp localblyp = a();
    if (localblyp != null) {
      localblyp.a(new blyq(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    blyp localblyp = a();
    if (localblyp != null) {
      localblyp.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    blyp localblyp = a();
    if (localblyp != null) {
      localblyp.i();
    }
  }
  
  private void i()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
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
          ??? = StatisticCollector.getInstance(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            blyq localblyq = (blyq)localIterator.next();
            ((StatisticCollector)???).collectPerformance(localblyq.a(), localblyq.b(), localblyq.a(), localblyq.a(), localblyq.b(), localblyq.a(), null);
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
      jdField_a_of_type_Blyp = null;
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
 * Qualified Name:     blyp
 * JD-Core Version:    0.7.0.1
 */