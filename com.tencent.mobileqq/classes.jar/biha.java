import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class biha
{
  public int a;
  public String a;
  
  public biha()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static biha a(QQAppInterface paramQQAppInterface)
  {
    biha localbiha = new biha();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bihb.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbiha.jdField_a_of_type_Int = 1;
      localbiha.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbiha;
    }
    if (i == 2)
    {
      localbiha.jdField_a_of_type_Int = 2;
      return localbiha;
    }
    if ((!bihc.a(localBaseApplication)) || (!bihc.b(localBaseApplication)) || (!bihc.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbiha.jdField_a_of_type_Int = 3;
        localbiha.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbiha;
      }
      localbiha.jdField_a_of_type_Int = 5;
      return localbiha;
    }
    localbiha.jdField_a_of_type_Int = 4;
    return localbiha;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bihb.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biha
 * JD-Core Version:    0.7.0.1
 */