import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class bkgu
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString).versionCode;
  }
  
  public static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageInfo(paramString, 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      a(paramContext, paramString);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgu
 * JD-Core Version:    0.7.0.1
 */