import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aowb
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    paramQQAppInterface = new aovz(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "avgame";
    paramQQAppInterface.c = "join_room";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int i = 0;
    while (i < paramContext.length)
    {
      paramString = paramContext[i];
      if (paramString.split("=").length == 2)
      {
        int j = paramString.indexOf("=");
        paramQQAppInterface.a(paramString.substring(0, j), paramString.substring(j + 1));
      }
      i += 1;
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowb
 * JD-Core Version:    0.7.0.1
 */