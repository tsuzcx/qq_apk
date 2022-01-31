import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axri
{
  private static String a(axrj paramaxrj)
  {
    return paramaxrj.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    axrj localaxrj = new axrj();
    localaxrj.jdField_a_of_type_Long = paramLong9;
    localaxrj.b = paramLong1;
    localaxrj.c = paramLong2;
    localaxrj.jdField_d_of_type_Long = paramLong3;
    localaxrj.e = paramLong4;
    localaxrj.jdField_f_of_type_Long = paramLong5;
    localaxrj.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localaxrj.g = paramLong6;
    localaxrj.m = paramLong7;
    localaxrj.h = paramLong8;
    localaxrj.jdField_d_of_type_JavaLangString = paramString1;
    localaxrj.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localaxrj);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    axqw.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axri
 * JD-Core Version:    0.7.0.1
 */