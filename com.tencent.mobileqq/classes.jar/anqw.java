import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class anqw
  extends anri
{
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    paramQQAppInterface = new anqv(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "troop_homework";
    paramQQAppInterface.c = "publish";
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
 * Qualified Name:     anqw
 * JD-Core Version:    0.7.0.1
 */