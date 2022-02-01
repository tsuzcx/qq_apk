import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class bcrm
{
  private static String a(bcrn parambcrn)
  {
    return parambcrn.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    bcrn localbcrn = new bcrn();
    localbcrn.jdField_a_of_type_JavaLangString = paramString1;
    localbcrn.jdField_b_of_type_JavaLangString = paramString2;
    localbcrn.jdField_c_of_type_JavaLangString = paramString3;
    localbcrn.jdField_a_of_type_Long = paramLong1;
    localbcrn.jdField_b_of_type_Long = paramLong2;
    localbcrn.jdField_d_of_type_Long = paramLong3;
    localbcrn.f = paramLong4;
    localbcrn.g = paramLong5;
    localbcrn.jdField_d_of_type_JavaLangString = paramString4;
    localbcrn.e = paramString5;
    localbcrn.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localbcrn);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localbcrn);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    bcst.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrm
 * JD-Core Version:    0.7.0.1
 */