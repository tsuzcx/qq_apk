import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.QRBridgeUtil;
import mqq.app.AppRuntime;

public class bfmm
{
  private static int a = -1;
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    new Bundle().putLong("start_plugin_act_begin_time", l);
    bfmr.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), new bfmn(paramContext, l));
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    a(paramContext, paramIntent, paramString1, paramString2, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, EnterCallback paramEnterCallback)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramIntent = localBundle;
    if (localBundle == null) {
      paramIntent = new Bundle();
    }
    paramIntent.putString("package_name", paramString1);
    paramIntent.putString("component_name", "." + paramString2);
    long l = System.currentTimeMillis();
    paramIntent.putLong("start_plugin_act_begin_time", l);
    bfmr.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", paramIntent, new bfmo(paramEnterCallback, paramContext, l));
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (QRBridgeUtil.sIsPluginReady)
    {
      bfne.b("ReaderPluginHelper", "[loadPlugin] sIsPluginReady = true ! mGrayState = " + a);
      return;
    }
    if (a == -1)
    {
      a = bfmp.a().getInt("KEY_SHADOW_GRAY", -1);
      bfne.b("ReaderPluginHelper", "[loadPlugin] SP state = " + a);
    }
    if (a == -1) {
      a = 0;
    }
    bfne.d("ReaderPluginHelper", "[loadPlugin] sIsPluginReady = " + QRBridgeUtil.sIsPluginReady + " mGrayState = " + a + " isShadowOnly = " + paramBoolean);
    if (a == 1) {
      a(paramContext);
    }
    for (;;)
    {
      bfnk.a(paramContext, String.valueOf(a));
      return;
      if (paramBoolean) {
        break;
      }
      BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
    }
  }
  
  public static boolean a()
  {
    bfne.d("ReaderPluginHelper", "[isUseShadow] mGrayState = " + a);
    return a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmm
 * JD-Core Version:    0.7.0.1
 */