import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.time.TimeMonitorData.1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bler
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bler(String paramString)
  {
    QLog.e("IliveTimeMonitorData", 1, "init TimeMonitor id：" + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
        QLog.e("IliveTimeMonitorData", 1, "mTimeTag is empty");
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.e("IliveTimeMonitorData", 1, str + "：" + (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("IliveTimeMonitorData", 1, "showDataToQLogcat msg = " + localThrowable.getMessage(), localThrowable);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString)
  {
    a(paramString, null);
  }
  
  public void a(String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    b();
    ThreadManagerV2.postImmediately(new TimeMonitorData.1(this, paramString, paramHashMap, paramLong), null, false);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, String.valueOf(l));
    a(paramString, l, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bler
 * JD-Core Version:    0.7.0.1
 */