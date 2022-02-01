import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bhnq
{
  public int a;
  public String a;
  
  public bhnq()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bhnq a(QQAppInterface paramQQAppInterface)
  {
    bhnq localbhnq = new bhnq();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bhnr.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbhnq.jdField_a_of_type_Int = 1;
      localbhnq.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbhnq;
    }
    if (i == 2)
    {
      localbhnq.jdField_a_of_type_Int = 2;
      return localbhnq;
    }
    if ((!bhns.a(localBaseApplication)) || (!bhns.b(localBaseApplication)) || (!bhns.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbhnq.jdField_a_of_type_Int = 3;
        localbhnq.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbhnq;
      }
      localbhnq.jdField_a_of_type_Int = 5;
      return localbhnq;
    }
    localbhnq.jdField_a_of_type_Int = 4;
    return localbhnq;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bhnr.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnq
 * JD-Core Version:    0.7.0.1
 */