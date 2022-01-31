import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bevs
{
  public int a;
  public String a;
  
  public bevs()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bevs a(QQAppInterface paramQQAppInterface)
  {
    bevs localbevs = new bevs();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bevt.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbevs.jdField_a_of_type_Int = 1;
      localbevs.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbevs;
    }
    if (i == 2)
    {
      localbevs.jdField_a_of_type_Int = 2;
      return localbevs;
    }
    if ((!bevu.a(localBaseApplication)) || (!bevu.b(localBaseApplication)) || (!bevu.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbevs.jdField_a_of_type_Int = 3;
        localbevs.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbevs;
      }
      localbevs.jdField_a_of_type_Int = 5;
      return localbevs;
    }
    localbevs.jdField_a_of_type_Int = 4;
    return localbevs;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bevt.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevs
 * JD-Core Version:    0.7.0.1
 */