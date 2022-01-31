import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class bfgd
{
  public static String a(int paramInt)
  {
    String str = b(paramInt);
    return bfhm.a().getString(str, "");
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str = b(paramInt);
    bfhm.a().edit().putString(str, paramString).apply();
  }
  
  private static String b(int paramInt)
  {
    return "gdt_cookie_" + beut.a().a() + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgd
 * JD-Core Version:    0.7.0.1
 */