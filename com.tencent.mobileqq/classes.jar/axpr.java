import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class axpr
{
  private static String a(axps paramaxps)
  {
    return paramaxps.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    axps localaxps = new axps();
    localaxps.jdField_a_of_type_JavaLangString = paramString1;
    localaxps.jdField_b_of_type_JavaLangString = paramString2;
    localaxps.jdField_c_of_type_JavaLangString = paramString3;
    localaxps.jdField_a_of_type_Long = paramLong1;
    localaxps.jdField_b_of_type_Long = paramLong2;
    localaxps.jdField_d_of_type_Long = paramLong3;
    localaxps.f = paramLong4;
    localaxps.g = paramLong5;
    localaxps.jdField_d_of_type_JavaLangString = paramString4;
    localaxps.e = paramString5;
    localaxps.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localaxps);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localaxps);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    axqy.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpr
 * JD-Core Version:    0.7.0.1
 */