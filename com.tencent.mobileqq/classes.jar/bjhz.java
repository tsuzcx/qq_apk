import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bjhz
{
  public int a;
  public String a;
  
  public bjhz()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bjhz a(QQAppInterface paramQQAppInterface)
  {
    bjhz localbjhz = new bjhz();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bjia.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbjhz.jdField_a_of_type_Int = 1;
      localbjhz.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbjhz;
    }
    if (i == 2)
    {
      localbjhz.jdField_a_of_type_Int = 2;
      return localbjhz;
    }
    if ((!bjib.a(localBaseApplication)) || (!bjib.b(localBaseApplication)) || (!bjib.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbjhz.jdField_a_of_type_Int = 3;
        localbjhz.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbjhz;
      }
      localbjhz.jdField_a_of_type_Int = 5;
      return localbjhz;
    }
    localbjhz.jdField_a_of_type_Int = 4;
    return localbjhz;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bjia.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhz
 * JD-Core Version:    0.7.0.1
 */