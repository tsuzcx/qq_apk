package com.tencent.falco.base.floatwindow.permission.romutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.falco.base.floatwindow.utils.Logger;
import java.util.List;

public class MiuiRomUtils
  extends BaseRomUtils
{
  private static final String TAG = "MiuiRomUtils";
  
  public static void applyPermission(Context paramContext)
  {
    int i = getMiuiVersion();
    if (i == 5)
    {
      goToMiuiPermissionActivity_V5(paramContext);
      return;
    }
    if (i == 6)
    {
      goToMiuiPermissionActivity_V6(paramContext);
      return;
    }
    if (i == 7)
    {
      goToMiuiPermissionActivity_V7(paramContext);
      return;
    }
    if (i == 8)
    {
      goToMiuiPermissionActivity_V8(paramContext);
      return;
    }
    Logger.e("MiuiRomUtils", "this is a special MIUI rom version, its version code " + i);
  }
  
  public static int getMiuiVersion()
  {
    String str = PhoneRomUtils.getSystemProperty("ro.miui.ui.version.name");
    if (str != null) {
      try
      {
        int i = Integer.parseInt(str.substring(1));
        return i;
      }
      catch (Exception localException)
      {
        Logger.e("MiuiRomUtils", "get miui version code error, version : " + str);
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  public static void goToMiuiPermissionActivity_V5(Context paramContext)
  {
    String str = paramContext.getPackageName();
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", str, null));
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    Logger.e("MiuiRomUtils", "intent is not available!");
  }
  
  public static void goToMiuiPermissionActivity_V6(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    Logger.e("MiuiRomUtils", "Intent is not available!");
  }
  
  public static void goToMiuiPermissionActivity_V7(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    Logger.e("MiuiRomUtils", "Intent is not available!");
  }
  
  public static void goToMiuiPermissionActivity_V8(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setPackage("com.miui.securitycenter");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    Logger.e("MiuiRomUtils", "Intent is not available!");
  }
  
  private static boolean isIntentAvailable(Intent paramIntent, Context paramContext)
  {
    if (paramIntent == null) {}
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() <= 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.MiuiRomUtils
 * JD-Core Version:    0.7.0.1
 */