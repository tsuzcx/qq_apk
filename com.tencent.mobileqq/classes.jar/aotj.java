import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aotj
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    paramQQAppInterface = new aoti(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "ftssearch";
    paramQQAppInterface.c = "openmixweb";
    paramContext = paramString.replace("mqqapi://ftssearch/openmixweb?", "").replace("^?", "").split("&");
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if ((paramString != null) && (paramString.length == 2)) {
          paramQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotj
 * JD-Core Version:    0.7.0.1
 */