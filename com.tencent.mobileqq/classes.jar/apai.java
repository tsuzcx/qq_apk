import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class apai
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new apah(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "gamecenter";
      paramQQAppInterface.c = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apai
 * JD-Core Version:    0.7.0.1
 */