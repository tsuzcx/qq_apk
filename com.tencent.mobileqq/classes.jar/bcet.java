import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bcet
{
  private static String a(bceu parambceu)
  {
    return parambceu.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    bceu localbceu = new bceu();
    localbceu.jdField_a_of_type_Long = paramLong9;
    localbceu.b = paramLong1;
    localbceu.c = paramLong2;
    localbceu.jdField_d_of_type_Long = paramLong3;
    localbceu.e = paramLong4;
    localbceu.jdField_f_of_type_Long = paramLong5;
    localbceu.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    localbceu.g = paramLong6;
    localbceu.m = paramLong7;
    localbceu.h = paramLong8;
    localbceu.jdField_d_of_type_JavaLangString = paramString1;
    localbceu.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localbceu);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    bcef.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcet
 * JD-Core Version:    0.7.0.1
 */