import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class apjd
{
  public static apje a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new apje();
    aoxr localaoxr = aoxs.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localaoxr.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localaoxr.a();
    paramQQAppInterface.b = localaoxr.b();
    paramQQAppInterface.jdField_a_of_type_Int = localaoxr.a();
    paramQQAppInterface.c = localaoxr.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = aoxc.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjd
 * JD-Core Version:    0.7.0.1
 */