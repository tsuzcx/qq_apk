import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoxl
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new aoxk(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "gamecenter";
      paramQQAppInterface.c = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxl
 * JD-Core Version:    0.7.0.1
 */