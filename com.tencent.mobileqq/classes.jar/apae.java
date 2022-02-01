import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class apae
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    paramQQAppInterface = new apad(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "commonBuddyGroup";
    paramQQAppInterface.c = "open";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {}
    for (;;)
    {
      return paramQQAppInterface;
      paramContext = paramContext[1].split("&");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2) {
          paramQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apae
 * JD-Core Version:    0.7.0.1
 */