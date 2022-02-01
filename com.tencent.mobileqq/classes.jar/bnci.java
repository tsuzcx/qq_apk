import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.QzoneModuleReport.1;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bnci
{
  private static long jdField_a_of_type_Long;
  private static boolean jdField_a_of_type_Boolean;
  private static long b;
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramInt1 > 0) {
      localCalendar.set(1, paramInt1);
    }
    if (paramInt2 > 0) {
      localCalendar.set(2, paramInt2);
    }
    if (paramInt3 > 0) {
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static void a(bnbx parambnbx, String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_id", parambnbx.a);
    localHashMap.put("module_url", parambnbx.d);
    localHashMap.put("module_version", parambnbx.b);
    localHashMap.put("resolveClassState", paramString);
    localHashMap.put("param_FailCode", "v" + parambnbx.b + "_" + paramString);
    boolean bool = "1".equalsIgnoreCase(paramString);
    a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambnbx.a + "_resolveClassRes", bool, paramLong, 0L, localHashMap, "");
  }
  
  public static void a(bnbx parambnbx, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_id", parambnbx.a);
      localHashMap.put("module_url", parambnbx.d);
      localHashMap.put("module_version", String.valueOf(parambnbx.b));
      localHashMap.put("downloadState", str);
      localHashMap.put("param_FailCode", "v" + parambnbx.b + "_" + str);
      a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambnbx.a + "_downloadRes", paramBoolean, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneModuleReport", 1, "needn't report");
      }
      return;
    }
    ThreadManager.post(new QzoneModuleReport.1(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  private static boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      int i;
      long l2;
      int j;
      try
      {
        long l1 = System.currentTimeMillis();
        if (!a(l1))
        {
          i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneModuleReportSample", 100);
          l1 /= 86400000L;
          l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          if (l2 == 0L) {
            return bool1;
          }
          if (i == 0)
          {
            jdField_a_of_type_Boolean = false;
            b = a(0, 0, 0, 0, 0, 0);
            jdField_a_of_type_Long = a(0, 0, 0, 24, 0, 0);
          }
        }
        else
        {
          bool1 = jdField_a_of_type_Boolean;
          continue;
          jdField_a_of_type_Boolean = bool1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QzoneModuleReport", 4, "----QzoneModule-sample number： " + j);
          continue;
        }
        j = (int)(l1 % i);
      }
      finally {}
      bool1 = bool2;
      if (j == l2 % i) {
        bool1 = true;
      }
    }
  }
  
  private static boolean a(long paramLong)
  {
    return (b != 0L) && (jdField_a_of_type_Long != 0L) && (paramLong >= b) && (paramLong < jdField_a_of_type_Long);
  }
  
  public static void b(bnbx parambnbx, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_id", parambnbx.a);
      localHashMap.put("module_url", parambnbx.d);
      localHashMap.put("module_version", String.valueOf(parambnbx.b));
      localHashMap.put("loadState", str);
      localHashMap.put("param_FailCode", "v" + parambnbx.b + "_" + str);
      a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambnbx.a + "_loadRes", paramBoolean, paramLong, 0L, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnci
 * JD-Core Version:    0.7.0.1
 */