import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class antz
  extends anri
{
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    paramQQAppInterface = new anty(paramQQAppInterface, paramContext);
    paramContext = paramString.split("\\?");
    if (paramContext.length < 1) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = paramContext[0];
    paramQQAppInterface.c = paramContext[1];
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramanrl = (String)paramString.next();
      if (!TextUtils.isEmpty(paramanrl))
      {
        String str = paramContext.getQueryParameter(paramanrl);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramanrl.toLowerCase(), str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antz
 * JD-Core Version:    0.7.0.1
 */