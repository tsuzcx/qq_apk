import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoya
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    paramaoxk = Uri.parse(paramString).getLastPathSegment();
    paramQQAppInterface = new aoxz(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "com.qqfav";
    paramQQAppInterface.c = paramaoxk;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoya
 * JD-Core Version:    0.7.0.1
 */