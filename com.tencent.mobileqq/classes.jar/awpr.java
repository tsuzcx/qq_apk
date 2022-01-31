import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class awpr
{
  private static String a(awps paramawps)
  {
    return paramawps.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    awps localawps = new awps();
    localawps.jdField_a_of_type_JavaLangString = paramString1;
    localawps.jdField_b_of_type_JavaLangString = paramString2;
    localawps.jdField_c_of_type_JavaLangString = paramString3;
    localawps.jdField_a_of_type_Long = paramLong1;
    localawps.jdField_b_of_type_Long = paramLong2;
    localawps.jdField_d_of_type_Long = paramLong3;
    localawps.f = paramLong4;
    localawps.g = paramLong5;
    localawps.jdField_d_of_type_JavaLangString = paramString4;
    localawps.e = paramString5;
    localawps.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localawps);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localawps);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    awqx.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awpr
 * JD-Core Version:    0.7.0.1
 */