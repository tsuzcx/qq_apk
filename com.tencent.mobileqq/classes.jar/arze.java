import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class arze
{
  public static arzf a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new arzf();
    arnr localarnr = arns.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localarnr.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localarnr.a();
    paramQQAppInterface.b = localarnr.b();
    paramQQAppInterface.jdField_a_of_type_Int = localarnr.a();
    paramQQAppInterface.c = localarnr.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = arnc.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arze
 * JD-Core Version:    0.7.0.1
 */