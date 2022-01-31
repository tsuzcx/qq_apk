import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class azpl
{
  private static String a(azpm paramazpm)
  {
    return paramazpm.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    azpm localazpm = new azpm();
    localazpm.jdField_a_of_type_JavaLangString = paramString1;
    localazpm.jdField_b_of_type_JavaLangString = paramString2;
    localazpm.jdField_c_of_type_JavaLangString = paramString3;
    localazpm.jdField_a_of_type_Long = paramLong1;
    localazpm.jdField_b_of_type_Long = paramLong2;
    localazpm.jdField_d_of_type_Long = paramLong3;
    localazpm.f = paramLong4;
    localazpm.g = paramLong5;
    localazpm.jdField_d_of_type_JavaLangString = paramString4;
    localazpm.e = paramString5;
    localazpm.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localazpm);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localazpm);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    azqs.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpl
 * JD-Core Version:    0.7.0.1
 */