import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class biyp
{
  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getLong(paramString, 0L);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyp
 * JD-Core Version:    0.7.0.1
 */