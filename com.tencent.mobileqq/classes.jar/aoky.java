import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class aoky
  extends aojt
{
  public aojs a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aojw paramaojw)
  {
    paramQQAppInterface = new aokx(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "qboss";
    paramQQAppInterface.c = "qboss_load";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int i = 0;
    for (;;)
    {
      if (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2) {}
        try
        {
          paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
          paramQQAppInterface.a(paramString[0], paramString[1]);
          i += 1;
        }
        catch (Exception paramaojw)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QbossLoaderParser", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], paramaojw);
            }
          }
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoky
 * JD-Core Version:    0.7.0.1
 */