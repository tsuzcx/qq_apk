import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class amxa
{
  public static amxb a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new amxb();
    amlp localamlp = amlq.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localamlp.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localamlp.a();
    paramQQAppInterface.b = localamlp.b();
    paramQQAppInterface.jdField_a_of_type_Int = localamlp.a();
    paramQQAppInterface.c = localamlp.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = amlb.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxa
 * JD-Core Version:    0.7.0.1
 */