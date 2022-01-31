import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class axpp
{
  private static String a(axpq paramaxpq)
  {
    return paramaxpq.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    axpq localaxpq = new axpq();
    localaxpq.jdField_a_of_type_JavaLangString = paramString1;
    localaxpq.jdField_b_of_type_JavaLangString = paramString2;
    localaxpq.jdField_c_of_type_JavaLangString = paramString3;
    localaxpq.jdField_a_of_type_Long = paramLong1;
    localaxpq.jdField_b_of_type_Long = paramLong2;
    localaxpq.jdField_d_of_type_Long = paramLong3;
    localaxpq.f = paramLong4;
    localaxpq.g = paramLong5;
    localaxpq.jdField_d_of_type_JavaLangString = paramString4;
    localaxpq.e = paramString5;
    localaxpq.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localaxpq);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localaxpq);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    axqw.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpp
 * JD-Core Version:    0.7.0.1
 */