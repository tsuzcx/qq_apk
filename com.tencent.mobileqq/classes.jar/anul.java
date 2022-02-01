import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class anul
  extends anri
{
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new anuk(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "gamecenter";
      paramQQAppInterface.c = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anul
 * JD-Core Version:    0.7.0.1
 */