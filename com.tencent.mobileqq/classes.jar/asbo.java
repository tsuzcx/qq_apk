import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class asbo
{
  public static asbp a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new asbp();
    arqi localarqi = arqj.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localarqi.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localarqi.a();
    paramQQAppInterface.b = localarqi.b();
    paramQQAppInterface.jdField_a_of_type_Int = localarqi.a();
    paramQQAppInterface.c = localarqi.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = arpt.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbo
 * JD-Core Version:    0.7.0.1
 */