import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class axru
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "Click_grp_asst", 0);
    paramContext.putInt(paramString + "grp_setting_asst", 0);
    paramContext.putInt(paramString + "grp_setting_msg", 0);
    paramContext.putInt(paramString + "grp_msg_equ", 0);
    paramContext.putInt(paramString + "grp_msg_dec", 0);
    paramContext.putInt(paramString + "grp_msg_inc", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_msg");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_inc");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_inc");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axru
 * JD-Core Version:    0.7.0.1
 */