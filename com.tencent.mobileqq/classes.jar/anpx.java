import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class anpx
  extends anri
{
  private anrh a(anrh paramanrh, String paramString)
  {
    paramanrh.a = paramString;
    paramanrh.b = "avgame";
    paramanrh.c = "create_room";
    paramString = paramString.split("\\?");
    if (paramString.length != 2) {}
    for (;;)
    {
      return paramanrh;
      paramString = paramString[1].split("&");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (localObject.split("=").length == 2)
        {
          int j = localObject.indexOf("=");
          paramanrh.a(localObject.substring(0, j), localObject.substring(j + 1));
        }
        i += 1;
      }
    }
  }
  
  public anrh a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    return a(new anpw(paramQQAppInterface, paramActivity), paramString);
  }
  
  public anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, anrl paramanrl)
  {
    return a(new anpw(paramQQAppInterface, paramContext), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpx
 * JD-Core Version:    0.7.0.1
 */