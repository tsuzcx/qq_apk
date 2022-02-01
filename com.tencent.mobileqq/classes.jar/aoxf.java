import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoxf
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    if (paramString.startsWith("mqqapi://vaslive"))
    {
      paramQQAppInterface = new aoxe(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "vaslive";
      if (paramString.startsWith("mqqapi://vaslive/watch")) {
        paramQQAppInterface.c = "watch";
      }
      for (;;)
      {
        paramContext = paramString.split("\\?");
        if (paramContext.length == 2) {
          break;
        }
        return paramQQAppInterface;
        if (paramString.startsWith("mqqapi://vaslive/myshopping")) {
          paramQQAppInterface.c = "mqqapi://vaslive/myshopping";
        }
      }
      paramContext = paramContext[1].split("&");
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxf
 * JD-Core Version:    0.7.0.1
 */