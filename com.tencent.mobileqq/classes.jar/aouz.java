import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class aouz
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    paramQQAppInterface = new aouy(paramQQAppInterface, paramContext);
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
    paramaoul = paramContext.getQueryParameterNames().iterator();
    while (paramaoul.hasNext())
    {
      String str1 = (String)paramaoul.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = paramContext.getQueryParameter(str1);
        if (!TextUtils.isEmpty(str2)) {
          paramQQAppInterface.a(str1.toLowerCase(), str2);
        }
      }
    }
    paramQQAppInterface.a("key_scheme", paramString);
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aouz
 * JD-Core Version:    0.7.0.1
 */