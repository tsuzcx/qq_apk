import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class bdlr
{
  public static bdlr a;
  private String a;
  public Map<String, Boolean> a;
  public Map<String, Boolean> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Bdlr = new bdlr("qzone");
  }
  
  public bdlr(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = ("StatisticHitRateCollector_" + paramString);
  }
  
  public static bdlr a()
  {
    return jdField_a_of_type_Bdlr;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public void a(String paramString)
  {
    a(paramString, "actQZLoadHitRateRed");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localBoolean = (Boolean)this.b.get(paramString2);
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString2, Boolean.valueOf(true));
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hitEnd sucess action = " + paramString2 + " , hit = true, uin = " + paramString1);
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, null, null);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString2);
        this.b.remove(paramString2);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "preloadMark preloadAction = " + paramString + " , flag = " + paramBoolean);
    }
    if (paramBoolean) {
      b(a(), paramString);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(false));
    this.b.put(paramString, Boolean.valueOf(true));
  }
  
  public void b(String paramString)
  {
    a(paramString, "actQZLoadHitRateLeba");
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        localBoolean = (Boolean)this.b.get(paramString2);
        if ((localBoolean != null) && (localBoolean.booleanValue()))
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString2, Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hitEnd action = " + paramString2 + " , hit = false, uin = " + paramString1);
          }
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, false, 0L, 0L, null, null);
          this.jdField_a_of_type_JavaUtilMap.remove(paramString2);
          this.b.remove(paramString2);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, "actQZLoadHitRateProfile");
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = new ArrayList(this.b.keySet()).iterator();
    while (localIterator.hasNext()) {
      b(paramString, (String)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlr
 * JD-Core Version:    0.7.0.1
 */