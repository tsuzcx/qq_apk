import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bfab
{
  public int a;
  public String a;
  
  public bfab()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bfab a(QQAppInterface paramQQAppInterface)
  {
    bfab localbfab = new bfab();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bfac.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbfab.jdField_a_of_type_Int = 1;
      localbfab.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbfab;
    }
    if (i == 2)
    {
      localbfab.jdField_a_of_type_Int = 2;
      return localbfab;
    }
    if ((!bfad.a(localBaseApplication)) || (!bfad.b(localBaseApplication)) || (!bfad.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbfab.jdField_a_of_type_Int = 3;
        localbfab.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbfab;
      }
      localbfab.jdField_a_of_type_Int = 5;
      return localbfab;
    }
    localbfab.jdField_a_of_type_Int = 4;
    return localbfab;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bfac.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfab
 * JD-Core Version:    0.7.0.1
 */