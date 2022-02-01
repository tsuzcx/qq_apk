import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bdlo
{
  private static String a(bdlp parambdlp)
  {
    return parambdlp.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    bdlp localbdlp = new bdlp();
    localbdlp.jdField_a_of_type_Long = paramLong9;
    localbdlp.b = paramLong1;
    localbdlp.c = paramLong2;
    localbdlp.jdField_d_of_type_Long = paramLong3;
    localbdlp.e = paramLong4;
    localbdlp.jdField_f_of_type_Long = paramLong5;
    localbdlp.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    localbdlp.g = paramLong6;
    localbdlp.m = paramLong7;
    localbdlp.h = paramLong8;
    localbdlp.jdField_d_of_type_JavaLangString = paramString1;
    localbdlp.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localbdlp);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    bdla.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdlo
 * JD-Core Version:    0.7.0.1
 */