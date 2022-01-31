import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bcwb
{
  public int a;
  public String a;
  
  public bcwb()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static bcwb a(QQAppInterface paramQQAppInterface)
  {
    bcwb localbcwb = new bcwb();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = bcwc.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localbcwb.jdField_a_of_type_Int = 1;
      localbcwb.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localbcwb;
    }
    if (i == 2)
    {
      localbcwb.jdField_a_of_type_Int = 2;
      return localbcwb;
    }
    if ((!bcwd.a(localBaseApplication)) || (!bcwd.b(localBaseApplication)) || (!bcwd.c(localBaseApplication)))
    {
      if (i == 3)
      {
        localbcwb.jdField_a_of_type_Int = 3;
        localbcwb.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
        return localbcwb;
      }
      localbcwb.jdField_a_of_type_Int = 5;
      return localbcwb;
    }
    localbcwb.jdField_a_of_type_Int = 4;
    return localbcwb;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = bcwc.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwb
 * JD-Core Version:    0.7.0.1
 */