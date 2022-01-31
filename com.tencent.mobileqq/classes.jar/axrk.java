import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axrk
{
  private static String a(axrl paramaxrl)
  {
    return paramaxrl.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    axrl localaxrl = new axrl();
    localaxrl.jdField_a_of_type_Long = paramLong9;
    localaxrl.b = paramLong1;
    localaxrl.c = paramLong2;
    localaxrl.jdField_d_of_type_Long = paramLong3;
    localaxrl.e = paramLong4;
    localaxrl.jdField_f_of_type_Long = paramLong5;
    localaxrl.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localaxrl.g = paramLong6;
    localaxrl.m = paramLong7;
    localaxrl.h = paramLong8;
    localaxrl.jdField_d_of_type_JavaLangString = paramString1;
    localaxrl.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localaxrl);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    axqy.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axrk
 * JD-Core Version:    0.7.0.1
 */