import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class bkyz
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString).versionCode;
  }
  
  public static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageInfo(paramString, 0);
  }
  
  @Nullable
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramString = paramContext.getApplicationInfo(paramString, 128);
      return (String)paramContext.getApplicationLabel(paramString);
    }
    catch (Exception paramContext)
    {
      QLog.e("PackageUtil", 1, "getApplicationName: failed. ", paramContext);
    }
    return null;
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
 * Qualified Name:     bkyz
 * JD-Core Version:    0.7.0.1
 */