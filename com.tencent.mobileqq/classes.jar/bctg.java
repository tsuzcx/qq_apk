import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bctg
{
  private static String a(bcth parambcth)
  {
    return parambcth.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    bcth localbcth = new bcth();
    localbcth.jdField_a_of_type_Long = paramLong9;
    localbcth.b = paramLong1;
    localbcth.c = paramLong2;
    localbcth.jdField_d_of_type_Long = paramLong3;
    localbcth.e = paramLong4;
    localbcth.jdField_f_of_type_Long = paramLong5;
    localbcth.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localbcth.g = paramLong6;
    localbcth.m = paramLong7;
    localbcth.h = paramLong8;
    localbcth.jdField_d_of_type_JavaLangString = paramString1;
    localbcth.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localbcth);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    bcst.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctg
 * JD-Core Version:    0.7.0.1
 */