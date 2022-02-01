import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class bccy
{
  private static String a(bccz parambccz)
  {
    return parambccz.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    bccz localbccz = new bccz();
    localbccz.jdField_a_of_type_JavaLangString = paramString1;
    localbccz.jdField_b_of_type_JavaLangString = paramString2;
    localbccz.jdField_c_of_type_JavaLangString = paramString3;
    localbccz.jdField_a_of_type_Long = paramLong1;
    localbccz.jdField_b_of_type_Long = paramLong2;
    localbccz.jdField_d_of_type_Long = paramLong3;
    localbccz.f = paramLong4;
    localbccz.g = paramLong5;
    localbccz.jdField_d_of_type_JavaLangString = paramString4;
    localbccz.e = paramString5;
    localbccz.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localbccz);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localbccz);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    bcef.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccy
 * JD-Core Version:    0.7.0.1
 */