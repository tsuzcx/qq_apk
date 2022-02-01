import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class bmgk
{
  public static int a(Context paramContext)
  {
    return bmgj.a(paramContext).getInt("GRAY_UPDATE_GRAY_LEVEL", 0);
  }
  
  public static long a(Context paramContext)
  {
    return bmgj.a(paramContext).getLong("LAST_EXIT_BOOKSTORE_POP_WINDOW_TIME_", 0L);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    bmgj.a(paramContext).edit().putInt("GRAY_UPDATE_GRAY_LEVEL", paramInt).apply();
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    bmgj.a(paramContext).edit().putLong("LAST_EXIT_BOOKSTORE_POP_WINDOW_TIME_", paramLong).apply();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    bmgj.a(paramContext).edit().putBoolean("is_frist_enter_home_page_from_leba", paramBoolean).apply();
  }
  
  public static boolean a(Context paramContext)
  {
    return bmgj.a(paramContext).getBoolean("is_frist_enter_home_page_from_leba", true);
  }
  
  public static int b(Context paramContext)
  {
    return bmgj.a(paramContext).getInt("GRAY_UPDATE_UPDATE_STATUS", 0);
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    bmgj.a(paramContext).edit().putInt("GRAY_UPDATE_UPDATE_STATUS", paramInt).apply();
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    bmgj.a(paramContext).edit().putBoolean("GRAY_UPDATE_IS_UPDATE_TO_QQ_BOOKSTORE", paramBoolean).apply();
  }
  
  public static boolean b(Context paramContext)
  {
    return bmgj.a(paramContext).getBoolean("HOME_PAGE_NEXT_BOTTOM_ITEM_IS_SHELF", false);
  }
  
  public static int c(Context paramContext)
  {
    return paramContext.getSharedPreferences("SETTING", 0).getInt("NUM_OF_RED_POINT", 0);
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    bmgj.a(paramContext).edit().putInt("GRAY_UPDATING_NEXT_REQ_TIME_INTERVAL", paramInt).apply();
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    bmgj.a(paramContext).edit().putBoolean("HOME_PAGE_NEXT_BOTTOM_ITEM_IS_SHELF", paramBoolean).apply();
  }
  
  public static boolean c(Context paramContext)
  {
    return bmgj.a(paramContext).getBoolean("GRAY_UPDATE_IS_UPDATE_TO_QQ_BOOKSTORE", false);
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    bmgj.a(paramContext).edit().putInt("GRAY_UPDATING_REMAIN_MAX_TIME", paramInt).apply();
  }
  
  public static void d(Context paramContext, boolean paramBoolean)
  {
    bmgj.a(paramContext).edit().putBoolean("GRAY_UPDATE_IS_HAS_TAB_CONFIG_DATA", paramBoolean).apply();
  }
  
  public static boolean d(Context paramContext)
  {
    return bmgj.a(paramContext).getBoolean("GRAY_UPDATE_IS_HAS_TAB_CONFIG_DATA", false);
  }
  
  public static void e(Context paramContext, boolean paramBoolean)
  {
    bmgj.a(paramContext).edit().putBoolean("new_user_in_act", paramBoolean).apply();
  }
  
  public static boolean e(Context paramContext)
  {
    return bmgj.a(paramContext).getBoolean("new_user_in_act", false);
  }
  
  public static void f(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("SETTING", 0).edit().putBoolean("is_new_user", paramBoolean).apply();
  }
  
  public static boolean f(Context paramContext)
  {
    return paramContext.getSharedPreferences("SETTING", 0).getBoolean("is_new_user", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgk
 * JD-Core Version:    0.7.0.1
 */