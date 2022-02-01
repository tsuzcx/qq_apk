import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class bdke
{
  private static String a(bdkf parambdkf)
  {
    return parambdkf.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    bdkf localbdkf = new bdkf();
    localbdkf.jdField_a_of_type_JavaLangString = paramString1;
    localbdkf.jdField_b_of_type_JavaLangString = paramString2;
    localbdkf.jdField_c_of_type_JavaLangString = paramString3;
    localbdkf.jdField_a_of_type_Long = paramLong1;
    localbdkf.jdField_b_of_type_Long = paramLong2;
    localbdkf.jdField_d_of_type_Long = paramLong3;
    localbdkf.f = paramLong4;
    localbdkf.g = paramLong5;
    localbdkf.jdField_d_of_type_JavaLangString = paramString4;
    localbdkf.e = paramString5;
    localbdkf.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localbdkf);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localbdkf);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    bdll.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdke
 * JD-Core Version:    0.7.0.1
 */