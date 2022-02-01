import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class ansl
  extends anri
{
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    paramQQAppInterface = new ansk(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "qapp";
    paramQQAppInterface.c = Uri.parse(paramString).getHost();
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansl
 * JD-Core Version:    0.7.0.1
 */