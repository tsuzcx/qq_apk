import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class anzv
{
  static anzx a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AREngine_ARPromotion";
  }
  
  public static anzo a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (anzo)((QQAppInterface)paramAppInterface).getManager(279);
    }
    if (AudioHelper.e()) {
      throw new IllegalArgumentException(amtj.a(2131707629));
    }
    return null;
  }
  
  public static anzx a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (AudioHelper.e())) {
      throw new IllegalArgumentException(amtj.a(2131707627));
    }
    if (jdField_a_of_type_Anzx == null) {}
    try
    {
      if (jdField_a_of_type_Anzx == null) {
        jdField_a_of_type_Anzx = new anzx(paramAppInterface);
      }
      return jdField_a_of_type_Anzx;
    }
    finally {}
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      a(paramAppInterface).a(paramAppInterface);
      BusinessCommonConfig.getInstance(paramAppInterface).doOnReconnect();
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "doOnReconnect, 不是主进程");
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong < AudioHelper.a();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.a();
    return (paramLong1 < l) && (paramLong2 > l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzv
 * JD-Core Version:    0.7.0.1
 */