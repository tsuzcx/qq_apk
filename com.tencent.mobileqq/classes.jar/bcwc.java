import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class bcwc
{
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("kwsjt_" + paramString, -1);
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwslcdt_" + paramString, -1L);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsbddbw", null);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsg_" + paramString, "");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("kwsbddbw", paramString);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("kwscdf_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("kwsjt_" + paramString1, paramInt);
    paramContext.putString("kwsjhu_" + paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwslcdt_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("kwsg_" + paramString1, paramString2);
    paramContext.apply();
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("kwscdf_" + paramString, 24);
  }
  
  public static long b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwslftjt_" + paramString, -1L);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsjhu_" + paramString, null);
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwslftjt_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static long c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwsrgrt_" + paramString, -1L);
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwsrgrt_" + paramString, paramLong);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwc
 * JD-Core Version:    0.7.0.1
 */