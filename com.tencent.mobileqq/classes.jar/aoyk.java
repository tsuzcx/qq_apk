import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoyk
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    paramQQAppInterface = new aoyj(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "qapp";
    paramQQAppInterface.c = Uri.parse(paramString).getHost();
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyk
 * JD-Core Version:    0.7.0.1
 */