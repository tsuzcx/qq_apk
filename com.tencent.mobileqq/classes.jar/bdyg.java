import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class bdyg
{
  public static String a(int paramInt)
  {
    String str = b(paramInt);
    return bdzf.a().getString(str, "");
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str = b(paramInt);
    bdzf.a().edit().putString(str, paramString).apply();
  }
  
  private static String b(int paramInt)
  {
    return "gdt_cookie_" + ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount() + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyg
 * JD-Core Version:    0.7.0.1
 */