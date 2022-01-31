import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class bffm
{
  public static String a(int paramInt)
  {
    String str = b(paramInt);
    return bfgv.a().getString(str, "");
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str = b(paramInt);
    bfgv.a().edit().putString(str, paramString).apply();
  }
  
  private static String b(int paramInt)
  {
    return "gdt_cookie_" + beuc.a().a() + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffm
 * JD-Core Version:    0.7.0.1
 */