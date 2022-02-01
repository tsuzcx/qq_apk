import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class aoxo
  extends aoxh
{
  public aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoxk paramaoxk)
  {
    paramQQAppInterface = new aoxm(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "lightapp";
    paramQQAppInterface.c = "open";
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramaoxk = (String)paramString.next();
      if (!TextUtils.isEmpty(paramaoxk))
      {
        String str = paramContext.getQueryParameter(paramaoxk);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramaoxk, str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxo
 * JD-Core Version:    0.7.0.1
 */