import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

public abstract class aowf
{
  public static int a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramString = paramContext.getApplicationInfo(paramString, 0);
        if (paramString != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramString) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowf
 * JD-Core Version:    0.7.0.1
 */