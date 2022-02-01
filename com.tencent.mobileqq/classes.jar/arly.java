import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class arly
{
  public static arlz a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new arlz();
    arar localarar = aras.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localarar.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localarar.a();
    paramQQAppInterface.b = localarar.b();
    paramQQAppInterface.jdField_a_of_type_Int = localarar.a();
    paramQQAppInterface.c = localarar.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = arac.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arly
 * JD-Core Version:    0.7.0.1
 */