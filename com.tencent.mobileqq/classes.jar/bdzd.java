import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class bdzd
{
  public static String a()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    return "V1_AND_MINISDK_0.9.2_0_RELEASE_B";
  }
  
  public static String a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static String b()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformQUA();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return a();
  }
  
  public static String b(Context paramContext)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject).append("a=").append(Build.VERSION.SDK_INT).append('&');
    ((StringBuilder)localObject).append("p=").append(paramContext.widthPixels).append('*').append(paramContext.heightPixels).append('&');
    ((StringBuilder)localObject).append("f=").append(Build.MANUFACTURER).append('&');
    ((StringBuilder)localObject).append("mm=").append(bdqz.b() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(bdqz.c()).append('&');
    ((StringBuilder)localObject).append("cc=").append(bdqz.b()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append(localMiniAppProxy.getAppVersion());
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdzd
 * JD-Core Version:    0.7.0.1
 */