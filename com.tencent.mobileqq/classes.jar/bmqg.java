import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.shadow.dynamic.host.EnterCallback;
import mqq.app.AppRuntime;

public class bmqg
{
  private static int a = -1;
  
  public static void a(Context paramContext)
  {
    bmqi.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), null);
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
    bmqi.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", paramIntent, paramEnterCallback);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (bmop.a().a())
    {
      bmqw.c("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = true ! mGrayState = " + a);
      return;
    }
    bmqw.c("ReaderPluginHelper", "[loadPluginRuntime] sIsPluginReady = false, mGrayState = " + a + " isShadowOnly = " + paramBoolean);
    if (a()) {
      a(paramContext);
    }
    for (;;)
    {
      bmqz.a(paramContext, String.valueOf(a));
      return;
      if (paramBoolean) {
        break;
      }
      BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
    }
  }
  
  public static boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqg
 * JD-Core Version:    0.7.0.1
 */