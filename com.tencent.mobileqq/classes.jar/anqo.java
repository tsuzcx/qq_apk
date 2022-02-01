import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class anqo
  extends anri
{
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    paramQQAppInterface = new anqn(paramQQAppInterface, paramContext);
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
 * Qualified Name:     anqo
 * JD-Core Version:    0.7.0.1
 */