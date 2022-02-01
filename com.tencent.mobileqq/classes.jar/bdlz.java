import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bdlz
{
  private static String a(bdma parambdma)
  {
    return parambdma.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    bdma localbdma = new bdma();
    localbdma.jdField_a_of_type_Long = paramLong9;
    localbdma.b = paramLong1;
    localbdma.c = paramLong2;
    localbdma.jdField_d_of_type_Long = paramLong3;
    localbdma.e = paramLong4;
    localbdma.jdField_f_of_type_Long = paramLong5;
    localbdma.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localbdma.g = paramLong6;
    localbdma.m = paramLong7;
    localbdma.h = paramLong8;
    localbdma.jdField_d_of_type_JavaLangString = paramString1;
    localbdma.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localbdma);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    bdll.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdlz
 * JD-Core Version:    0.7.0.1
 */