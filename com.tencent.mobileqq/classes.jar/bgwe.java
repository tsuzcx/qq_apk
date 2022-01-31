import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class bgwe
{
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("SETTING", 0).getString("debug_h5_test_env", null);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext.getSharedPreferences("SETTING", 0).edit().putBoolean("debug_h5_test_mode", paramBoolean).putString("debug_h5_test_env", paramString).apply();
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("SETTING", 0).getBoolean("debug_h5_test_mode", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwe
 * JD-Core Version:    0.7.0.1
 */