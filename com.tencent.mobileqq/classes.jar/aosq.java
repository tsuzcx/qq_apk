import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aosq
  extends aoui
{
  private aouc a(aouc paramaouc, String paramString)
  {
    paramaouc.a = paramString;
    paramaouc.b = "avgame";
    paramaouc.c = "create_room";
    paramString = paramString.split("\\?");
    if (paramString.length != 2) {}
    for (;;)
    {
      return paramaouc;
      paramString = paramString[1].split("&");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (localObject.split("=").length == 2)
        {
          int j = localObject.indexOf("=");
          paramaouc.a(localObject.substring(0, j), localObject.substring(j + 1));
        }
        i += 1;
      }
    }
  }
  
  public aouc a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    return a(new aosp(paramQQAppInterface, paramActivity), paramString);
  }
  
  public aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoul paramaoul)
  {
    return a(new aosp(paramQQAppInterface, paramContext), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosq
 * JD-Core Version:    0.7.0.1
 */