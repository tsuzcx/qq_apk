import android.graphics.drawable.Drawable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;

public class aody
{
  public static Drawable a(String paramString)
  {
    String[] arrayOfString1 = paramString.split("&");
    paramString = "";
    int m = arrayOfString1.length;
    int i = 0;
    int j = 1;
    if (i < m)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      if ((arrayOfString2.length == 2) || (arrayOfString2[0].equals("type"))) {}
      for (;;)
      {
        try
        {
          k = Integer.parseInt(arrayOfString2[1]);
          i += 1;
          j = k;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("UinToDrawableUtil", 1, "type wrong", localNumberFormatException);
          k = j;
          continue;
        }
        int k = j;
        if (localNumberFormatException[0].equals("uin"))
        {
          paramString = localNumberFormatException[1];
          k = j;
        }
      }
    }
    return a(paramString, j);
  }
  
  public static Drawable a(String paramString, int paramInt)
  {
    return bdbk.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt, 4, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aody
 * JD-Core Version:    0.7.0.1
 */