package com.tencent.falco.base.floatwindow.permission.romutils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.falco.base.floatwindow.utils.Logger;

public class HuaweiRomUtils
  extends BaseRomUtils
{
  private static final String TAG = "HuaweiRomUtils";
  
  public static void applyPermission(Context paramContext)
  {
    try
    {
      Intent localIntent1 = new Intent();
      localIntent1.setFlags(268435456);
      localIntent1.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
      if (PhoneRomUtils.getEmuiVersion() == 3.1D) {}
      for (;;)
      {
        paramContext.startActivity(localIntent1);
        return;
        localIntent1.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
      }
      Intent localIntent2;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localIntent2 = new Intent();
      localIntent2.setFlags(268435456);
      localIntent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
      paramContext.startActivity(localIntent2);
      localSecurityException.printStackTrace();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      localIntent2 = new Intent();
      localIntent2.setFlags(268435456);
      localIntent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
      paramContext.startActivity(localIntent2);
      localActivityNotFoundException.printStackTrace();
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e("HuaweiRomUtils", "进入设置页面失败，请手动设置");
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.HuaweiRomUtils
 * JD-Core Version:    0.7.0.1
 */