import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.shadow.dynamic.host.EnterCallback;
import mqq.app.AppRuntime;

public class bgvn
{
  private static int a = -1;
  
  public static void a(Context paramContext)
  {
    bgvr.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    a(paramContext, paramIntent, paramString, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, EnterCallback paramEnterCallback)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramIntent = localBundle;
    if (localBundle == null) {
      paramIntent = new Bundle();
    }
    paramIntent.putString("com.tencent.reader.plugin.KEY_ACTIVITY_CLASSNAME", paramString);
    paramIntent.putLong("start_plugin_act_begin_time", System.currentTimeMillis());
    bgvr.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", paramIntent, paramEnterCallback);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (bgtw.a().a())
    {
      bgwf.c("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = true ! mGrayState = " + a);
      return;
    }
    bgwf.c("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = false, mGrayState = " + a + " isShadowOnly = " + paramBoolean);
    if (a()) {
      a(paramContext);
    }
    for (;;)
    {
      bgwi.a(paramContext, String.valueOf(a));
      return;
      if (paramBoolean) {
        break;
      }
      BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
    }
  }
  
  public static boolean a()
  {
    bgwf.e("ReaderPluginHelper", "[isUseShadow] mGrayState = " + a);
    if (a == -1)
    {
      a = bgvp.a().getInt("KEY_SHADOW_GRAY", -1);
      if (a == -1) {
        a = 0;
      }
      bgwf.c("ReaderPluginHelper", "[loadPluginRuntime] SP state = " + a);
    }
    return a == 1;
  }
  
  public static void b(Context paramContext)
  {
    boolean bool = bgtw.a().a();
    bgwf.c("ReaderPluginHelper", "preloadPlugin: isPluginReady=" + bool + ", isUseShadow=" + a());
    if (bool)
    {
      bgwf.c("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = true ! mGrayState = " + a);
      return;
    }
    if (a())
    {
      c(paramContext);
      return;
    }
    BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
  }
  
  private static void c(Context paramContext)
  {
    bgvr.a().enter(paramContext, 1001L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvn
 * JD-Core Version:    0.7.0.1
 */