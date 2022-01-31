import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azrf
{
  private static String a(azrg paramazrg)
  {
    return paramazrg.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    azrg localazrg = new azrg();
    localazrg.jdField_a_of_type_Long = paramLong9;
    localazrg.b = paramLong1;
    localazrg.c = paramLong2;
    localazrg.jdField_d_of_type_Long = paramLong3;
    localazrg.e = paramLong4;
    localazrg.jdField_f_of_type_Long = paramLong5;
    localazrg.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localazrg.g = paramLong6;
    localazrg.m = paramLong7;
    localazrg.h = paramLong8;
    localazrg.jdField_d_of_type_JavaLangString = paramString1;
    localazrg.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localazrg);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    azqs.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrf
 * JD-Core Version:    0.7.0.1
 */