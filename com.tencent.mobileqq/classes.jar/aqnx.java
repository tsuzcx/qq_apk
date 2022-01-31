import android.os.Bundle;
import android.text.TextUtils;

public class aqnx
{
  public static long a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return 0L;
      paramBundle = paramBundle.getString("roomid", "");
    } while (TextUtils.isEmpty(paramBundle));
    return Long.parseLong(paramBundle);
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    String str;
    do
    {
      return paramBundle;
      str = paramBundle.getString("roomtype");
      paramBundle = str;
    } while (!TextUtils.isEmpty(str));
    return "0";
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("fromid", "");
  }
  
  public static String c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("shakespearetime", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqnx
 * JD-Core Version:    0.7.0.1
 */