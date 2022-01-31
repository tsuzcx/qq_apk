import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azmw
{
  private static String a(azmx paramazmx)
  {
    return paramazmx.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    azmx localazmx = new azmx();
    localazmx.jdField_a_of_type_Long = paramLong9;
    localazmx.b = paramLong1;
    localazmx.c = paramLong2;
    localazmx.jdField_d_of_type_Long = paramLong3;
    localazmx.e = paramLong4;
    localazmx.jdField_f_of_type_Long = paramLong5;
    localazmx.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localazmx.g = paramLong6;
    localazmx.m = paramLong7;
    localazmx.h = paramLong8;
    localazmx.jdField_d_of_type_JavaLangString = paramString1;
    localazmx.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localazmx);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    azmj.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmw
 * JD-Core Version:    0.7.0.1
 */