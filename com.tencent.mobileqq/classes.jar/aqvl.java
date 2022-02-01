import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class aqvl
{
  public static aqvm a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new aqvm();
    aqkg localaqkg = aqkh.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localaqkg.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localaqkg.a();
    paramQQAppInterface.b = localaqkg.b();
    paramQQAppInterface.jdField_a_of_type_Int = localaqkg.a();
    paramQQAppInterface.c = localaqkg.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = aqjr.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvl
 * JD-Core Version:    0.7.0.1
 */