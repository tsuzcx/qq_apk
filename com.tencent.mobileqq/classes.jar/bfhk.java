import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class bfhk
{
  private static String jdField_a_of_type_JavaLangString;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "anonymous", "wechat", "qq", "phone", "other" };
  
  public static String a()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    return "V1_AND_MINISDK_1.1.0_0_RELEASE_B";
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
  
  public static boolean a()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("qq");
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
    ((StringBuilder)localObject).append("mm=").append(belb.b() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(belb.c()).append('&');
    ((StringBuilder)localObject).append("cc=").append(belb.b()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append(localMiniAppProxy.getAppVersion());
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean b()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("demo");
  }
  
  public static String c()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformVersionString();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "1.1.0";
  }
  
  public static String d()
  {
    return f() + " QQ/" + c() + " " + b() + " MiniAppEnable miniProgram miniprogramhtmlwebview";
  }
  
  public static String e()
  {
    int i = beut.a().a();
    return jdField_a_of_type_ArrayOfJavaLangString[i];
  }
  
  public static String f()
  {
    int i = 0;
    if (jdField_a_of_type_JavaLangString != null) {
      return jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        boolean bool = bfhn.a();
        char c;
        String str2;
        if (bool)
        {
          try
          {
            String str1 = WebSettings.getDefaultUserAgent(MiniAppEnv.g().getContext());
            localStringBuilder = new StringBuilder();
            int j = str1.length();
            if (i >= j) {
              break label139;
            }
            c = str1.charAt(i);
            if ((c > '\037') && (c < '')) {
              continue;
            }
            localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
          }
          catch (Exception localException)
          {
            str2 = System.getProperty("http.agent");
            continue;
          }
        }
        else
        {
          str2 = System.getProperty("http.agent");
          continue;
        }
        localStringBuilder.append(c);
      }
      catch (Throwable localThrowable)
      {
        jdField_a_of_type_JavaLangString = "AndroidQQ";
      }
      for (;;)
      {
        return jdField_a_of_type_JavaLangString;
        label139:
        jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhk
 * JD-Core Version:    0.7.0.1
 */