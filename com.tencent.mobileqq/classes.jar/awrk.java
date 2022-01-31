import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awrk
{
  private static String a(awrl paramawrl)
  {
    return paramawrl.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    awrl localawrl = new awrl();
    localawrl.jdField_a_of_type_Long = paramLong9;
    localawrl.b = paramLong1;
    localawrl.c = paramLong2;
    localawrl.jdField_d_of_type_Long = paramLong3;
    localawrl.e = paramLong4;
    localawrl.jdField_f_of_type_Long = paramLong5;
    localawrl.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localawrl.g = paramLong6;
    localawrl.m = paramLong7;
    localawrl.h = paramLong8;
    localawrl.jdField_d_of_type_JavaLangString = paramString1;
    localawrl.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localawrl);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    awqx.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awrk
 * JD-Core Version:    0.7.0.1
 */