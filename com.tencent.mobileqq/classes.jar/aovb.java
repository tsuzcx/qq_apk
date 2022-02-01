import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class aovb
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    paramaoul = Uri.parse(paramString).getLastPathSegment();
    paramQQAppInterface = new aova(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "com.qqfav";
    paramQQAppInterface.c = paramaoul;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovb
 * JD-Core Version:    0.7.0.1
 */