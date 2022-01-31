import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bcwq
{
  public int a;
  public String a;
  
  public bcwq()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bcwq a(QQAppInterface paramQQAppInterface)
  {
    bcwq localbcwq = new bcwq();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bcwr.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbcwq.jdField_a_of_type_Int = 1;
      localbcwq.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbcwq;
    }
    if (i == 2)
    {
      localbcwq.jdField_a_of_type_Int = 2;
      return localbcwq;
    }
    if ((!bcws.a(localBaseApplication)) || (!bcws.b(localBaseApplication)) || (!bcws.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbcwq.jdField_a_of_type_Int = 3;
        localbcwq.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbcwq;
      }
      localbcwq.jdField_a_of_type_Int = 5;
      return localbcwq;
    }
    localbcwq.jdField_a_of_type_Int = 4;
    return localbcwq;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bcwr.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwq
 * JD-Core Version:    0.7.0.1
 */