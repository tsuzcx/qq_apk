import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bipb
{
  private static bipb jdField_a_of_type_Bipb;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<bipc> jdField_a_of_type_JavaUtilList;
  
  public static bipb a()
  {
    if (jdField_a_of_type_Bipb == null) {}
    try
    {
      if (jdField_a_of_type_Bipb == null) {
        jdField_a_of_type_Bipb = new bipb();
      }
      return jdField_a_of_type_Bipb;
    }
    finally {}
  }
  
  public static void a()
  {
    bipb localbipb = a();
    if (localbipb != null) {
      localbipb.e();
    }
  }
  
  private void a(bipc parambipc)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + parambipc);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(parambipc);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    bipb localbipb = a();
    if (localbipb != null) {
      localbipb.a(new bipc(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    bipb localbipb = a();
    if (localbipb != null) {
      localbipb.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    bipb localbipb = a();
    if (localbipb != null) {
      localbipb.i();
    }
  }
  
  private void i()
  {
    if (!bdee.d(BaseApplication.getContext())) {
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
          ??? = azmz.a(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            bipc localbipc = (bipc)localIterator.next();
            ((azmz)???).a(localbipc.a(), localbipc.b(), localbipc.a(), localbipc.a(), localbipc.b(), localbipc.a(), null);
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
      jdField_a_of_type_Bipb = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bipb
 * JD-Core Version:    0.7.0.1
 */