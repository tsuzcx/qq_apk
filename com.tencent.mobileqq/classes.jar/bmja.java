import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bmja
{
  private static bmja jdField_a_of_type_Bmja;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<bmjb> jdField_a_of_type_JavaUtilList;
  
  public static bmja a()
  {
    if (jdField_a_of_type_Bmja == null) {}
    try
    {
      if (jdField_a_of_type_Bmja == null) {
        jdField_a_of_type_Bmja = new bmja();
      }
      return jdField_a_of_type_Bmja;
    }
    finally {}
  }
  
  public static void a()
  {
    bmja localbmja = a();
    if (localbmja != null) {
      localbmja.e();
    }
  }
  
  private void a(bmjb parambmjb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + parambmjb);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(parambmjb);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    bmja localbmja = a();
    if (localbmja != null) {
      localbmja.a(new bmjb(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    bmja localbmja = a();
    if (localbmja != null) {
      localbmja.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    bmja localbmja = a();
    if (localbmja != null) {
      localbmja.i();
    }
  }
  
  private void i()
  {
    if (!bhnv.d(BaseApplication.getContext())) {
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
          ??? = bdmc.a(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            bmjb localbmjb = (bmjb)localIterator.next();
            ((bdmc)???).a(localbmjb.a(), localbmjb.b(), localbmjb.a(), localbmjb.a(), localbmjb.b(), localbmjb.a(), null);
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
      jdField_a_of_type_Bmja = null;
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
 * Qualified Name:     bmja
 * JD-Core Version:    0.7.0.1
 */