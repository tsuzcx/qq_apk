import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class asog
{
  public static asod a;
  
  private static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (a != null)
    {
      asoi.a("MsgBackup_MsgBackupReporter", "mReportContainer = %s", new Object[] { a });
      localHashMap.put("bizType", String.valueOf(a.jdField_a_of_type_Int));
      localHashMap.put("platForm", String.valueOf(a.jdField_b_of_type_Int));
      localHashMap.put("requestStatus", String.valueOf(a.jdField_a_of_type_Boolean));
      localHashMap.put("errorCode", String.valueOf(a.jdField_c_of_type_Int));
      localHashMap.put("totalCost", String.valueOf(a.jdField_a_of_type_Long));
      localHashMap.put("averageSpeed", String.valueOf(a.jdField_a_of_type_Double));
      localHashMap.put("totalSessionCount", String.valueOf(a.jdField_b_of_type_Long));
      localHashMap.put("finishedSessionCount", String.valueOf(a.jdField_c_of_type_Long));
      localHashMap.put("resSessionContains", String.valueOf(a.jdField_d_of_type_Long));
      localHashMap.put("resTotalSize", String.valueOf(a.e));
      localHashMap.put("dbTotalSize", String.valueOf(a.f));
      localHashMap.put("resRequestCount", String.valueOf(a.g));
      localHashMap.put("resRequestFailedCount", String.valueOf(a.h));
      localHashMap.put("resRequestCancelCount", String.valueOf(a.i));
      localHashMap.put("resTrivialCount", String.valueOf(a.j));
      localHashMap.put("resTrivialFailedCount", String.valueOf(a.k));
      localHashMap.put("resTrivialCancelCount", String.valueOf(a.l));
      localHashMap.put("dbRequestCount", String.valueOf(a.m));
      localHashMap.put("dbRequestFailedCount", String.valueOf(a.n));
      localHashMap.put("dbRequestCancelCount", String.valueOf(a.o));
      localHashMap.put("udpDetected", String.valueOf(a.jdField_b_of_type_Boolean));
      localHashMap.put("connectType", String.valueOf(a.jdField_d_of_type_Int));
      localHashMap.put("connectElipse", String.valueOf(a.p));
      localHashMap.put("sessionReadyAllTimes", String.valueOf(a.q));
      localHashMap.put("fileFailedCount", String.valueOf(a.r));
      localHashMap.put("fileErrorList", String.valueOf(a.jdField_a_of_type_JavaUtilArrayList));
    }
    return localHashMap;
  }
  
  public static void a()
  {
    if (a == null)
    {
      a = new asod();
      a.a();
      a.jdField_b_of_type_Int = 4;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "]");
    }
    axqy.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt + "]");
    }
    axqy.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt1 + "], reservedFromType = [" + paramInt2 + "]");
    }
    axqy.b(null, "dc00898", "", "", paramString, paramString, paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void b()
  {
    if (a != null)
    {
      a.a();
      a = null;
    }
  }
  
  public static void c()
  {
    if (a != null)
    {
      HashMap localHashMap = a();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      axrn.a(BaseApplicationImpl.getContext()).a(str, "MsgBackup_MsgBackupReporter", true, 0L, 0L, localHashMap, null);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asog
 * JD-Core Version:    0.7.0.1
 */