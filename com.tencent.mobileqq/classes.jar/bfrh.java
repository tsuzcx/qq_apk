import android.content.Context;
import android.content.SharedPreferences;

public class bfrh
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "sdk_preference";
    }
    return paramContext.getSharedPreferences(str, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrh
 * JD-Core Version:    0.7.0.1
 */