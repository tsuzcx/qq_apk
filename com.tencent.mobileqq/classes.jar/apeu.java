import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class apeu
{
  public static apev a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new apev();
    aoti localaoti = aotj.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localaoti.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localaoti.a();
    paramQQAppInterface.b = localaoti.b();
    paramQQAppInterface.jdField_a_of_type_Int = localaoti.a();
    paramQQAppInterface.c = localaoti.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = aost.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeu
 * JD-Core Version:    0.7.0.1
 */