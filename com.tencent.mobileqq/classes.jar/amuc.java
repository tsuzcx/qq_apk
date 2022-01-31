import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class amuc
{
  static amue a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AREngine_ARPromotion";
  }
  
  public static amtv a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (amtv)((QQAppInterface)paramAppInterface).getManager(279);
    }
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(alud.a(2131708912));
    }
    return null;
  }
  
  public static amue a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (AudioHelper.d())) {
      throw new IllegalArgumentException(alud.a(2131708910));
    }
    if (jdField_a_of_type_Amue == null) {}
    try
    {
      if (jdField_a_of_type_Amue == null) {
        jdField_a_of_type_Amue = new amue(paramAppInterface);
      }
      return jdField_a_of_type_Amue;
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
 * Qualified Name:     amuc
 * JD-Core Version:    0.7.0.1
 */