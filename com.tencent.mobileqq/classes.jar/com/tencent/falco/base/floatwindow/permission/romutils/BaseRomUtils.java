package com.tencent.falco.base.floatwindow.permission.romutils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.RequiresApi;
import com.tencent.falco.base.floatwindow.utils.Logger;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

public abstract class BaseRomUtils
{
  private static final String CHECK_OP = "checkOp";
  private static final int FW_OP_SYSTEM_ALERT_WINDOW = 24;
  private static final String TAG = "BaseRomUtils";
  
  public static boolean hasPermissionBelowMarshmallow(@NotNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return hasPermissionBelowMarshmallow(paramContext, 24);
    }
    return true;
  }
  
  @RequiresApi(19)
  private static boolean hasPermissionBelowMarshmallow(@NotNull Context paramContext, int paramInt)
  {
    boolean bool = false;
    try
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      paramInt = ((Integer)AppOpsManager.class.getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), paramContext.getApplicationContext().getPackageName() })).intValue();
      if (paramInt == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      Logger.e("BaseRomUtils", paramContext.toString());
    }
    return false;
  }
  
  @RequiresApi(api=23)
  public static boolean hasPermissionForO(@NotNull Context paramContext)
  {
    for (;;)
    {
      try
      {
        WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
        if (localWindowManager == null) {
          return false;
        }
        paramContext = new View(paramContext);
        if (Build.VERSION.SDK_INT >= 26)
        {
          i = 2038;
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(0, 0, i, 24, -2);
          paramContext.setLayoutParams(localLayoutParams);
          localWindowManager.addView(paramContext, localLayoutParams);
          localWindowManager.removeView(paramContext);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Logger.e("BaseRomUtils", paramContext.toString());
        return false;
      }
      int i = 2003;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.BaseRomUtils
 * JD-Core Version:    0.7.0.1
 */