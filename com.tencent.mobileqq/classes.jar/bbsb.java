import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bbsb
{
  public int a;
  public String a;
  
  public bbsb()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bbsb a(QQAppInterface paramQQAppInterface)
  {
    bbsb localbbsb = new bbsb();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bbsc.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbbsb.jdField_a_of_type_Int = 1;
      localbbsb.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbbsb;
    }
    if (i == 2)
    {
      localbbsb.jdField_a_of_type_Int = 2;
      return localbbsb;
    }
    if ((!bbsd.a(localBaseApplication)) || (!bbsd.b(localBaseApplication)) || (!bbsd.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbbsb.jdField_a_of_type_Int = 3;
        localbbsb.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbbsb;
      }
      localbbsb.jdField_a_of_type_Int = 5;
      return localbbsb;
    }
    localbbsb.jdField_a_of_type_Int = 4;
    return localbbsb;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bbsc.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbsb
 * JD-Core Version:    0.7.0.1
 */