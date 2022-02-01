import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class biyg
{
  public int a;
  public String a;
  
  public biyg()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static biyg a(QQAppInterface paramQQAppInterface)
  {
    biyg localbiyg = new biyg();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = biyh.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbiyg.jdField_a_of_type_Int = 1;
      localbiyg.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbiyg;
    }
    if (i == 2)
    {
      localbiyg.jdField_a_of_type_Int = 2;
      return localbiyg;
    }
    if ((!biyi.a(localBaseApplication)) || (!biyi.b(localBaseApplication)) || (!biyi.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbiyg.jdField_a_of_type_Int = 3;
        localbiyg.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbiyg;
      }
      localbiyg.jdField_a_of_type_Int = 5;
      return localbiyg;
    }
    localbiyg.jdField_a_of_type_Int = 4;
    return localbiyg;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = biyh.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyg
 * JD-Core Version:    0.7.0.1
 */