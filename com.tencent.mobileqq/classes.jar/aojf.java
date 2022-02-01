import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aojf
  extends aojt
{
  public aojs a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aojw paramaojw)
  {
    paramQQAppInterface = new aoje(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "groupvideo";
    if (paramString.contains("openroom")) {
      paramQQAppInterface.c = "openroom";
    }
    for (;;)
    {
      paramContext = paramString.split("\\?");
      if (paramContext.length == 2) {
        break;
      }
      return paramQQAppInterface;
      if (paramString.contains("preload")) {
        paramQQAppInterface.c = "preload";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojf
 * JD-Core Version:    0.7.0.1
 */