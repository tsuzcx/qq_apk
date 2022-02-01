package com.tencent.falco.base.floatwindow.permission.romutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.falco.base.floatwindow.utils.Logger;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class QikuRomUtils
  extends BaseRomUtils
{
  private static final String TAG = "QikuRomUtils";
  
  public static void applyPermission(@NotNull Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
    localIntent.setFlags(268435456);
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    localIntent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
    if (isIntentAvailable(localIntent, paramContext))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    Logger.e("QikuRomUtils", "can't open permission page with particular name");
  }
  
  private static boolean isIntentAvailable(Intent paramIntent, Context paramContext)
  {
    boolean bool = false;
    if (paramIntent == null) {
      return false;
    }
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.QikuRomUtils
 * JD-Core Version:    0.7.0.1
 */