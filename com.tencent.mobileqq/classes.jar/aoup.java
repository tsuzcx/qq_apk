import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class aoup
  extends aoui
{
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    paramQQAppInterface = new aoun(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "lightapp";
    paramQQAppInterface.c = "open";
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramaoul = (String)paramString.next();
      if (!TextUtils.isEmpty(paramaoul))
      {
        String str = paramContext.getQueryParameter(paramaoul);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramaoul, str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoup
 * JD-Core Version:    0.7.0.1
 */