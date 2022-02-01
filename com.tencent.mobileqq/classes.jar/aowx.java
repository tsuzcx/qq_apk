import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class aowx
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    paramQQAppInterface = new aoww(paramQQAppInterface, paramContext);
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
      paramaoul = (String)paramString.next();
      if (!TextUtils.isEmpty(paramaoul))
      {
        String str = paramContext.getQueryParameter(paramaoul);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramaoul.toLowerCase(), str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowx
 * JD-Core Version:    0.7.0.1
 */