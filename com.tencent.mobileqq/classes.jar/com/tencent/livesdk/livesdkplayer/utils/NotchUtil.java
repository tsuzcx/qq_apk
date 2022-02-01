package com.tencent.livesdk.livesdkplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Method;

public class NotchUtil
{
  private static final String TAG = "NotchUtil";
  private static boolean hasNotch = false;
  private static boolean inited = false;
  
  public static void adjustActivity(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    if ((!hasNotch(paramActivity)) || (paramActivity == null) || (paramActivity.getWindow() == null)) {}
    label148:
    for (;;)
    {
      return;
      Window localWindow = paramActivity.getWindow();
      Object localObject;
      int i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = localWindow.getDecorView();
        if (paramBoolean)
        {
          i = 8192;
          ((View)localObject).setSystemUiVisibility(i | 0x500);
          localWindow.clearFlags(67108864);
          localWindow.clearFlags(1024);
          localWindow.addFlags(-2147483648);
          localWindow.setStatusBarColor(0);
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label148;
        }
        paramView.setPadding(0, getStatusBarHeight(paramActivity), 0, 0);
        return;
        i = 0;
        break;
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = localWindow.getAttributes();
          if (localObject != null) {
            ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
          }
          localWindow.setAttributes((WindowManager.LayoutParams)localObject);
        }
      }
    }
  }
  
  public static void adjustWindow(Window paramWindow, View paramView, boolean paramBoolean)
  {
    if ((!hasNotch(paramView.getContext())) || (paramWindow == null)) {}
    label127:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = paramWindow.getDecorView();
        if (paramBoolean)
        {
          i = 8192;
          ((View)localObject).setSystemUiVisibility(i | 0x500);
          paramWindow.clearFlags(67108864);
          paramWindow.addFlags(-2147483648);
          paramWindow.setStatusBarColor(0);
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label127;
        }
        paramView.setPadding(0, getStatusBarHeight(paramView.getContext()), 0, 0);
        return;
        i = 0;
        break;
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = paramWindow.getAttributes();
          if (localObject != null) {
            ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
          }
          paramWindow.setAttributes((WindowManager.LayoutParams)localObject);
        }
      }
    }
  }
  
  public static int getCurrentNavigationBarHeight(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (!isNavigationBarShown(paramActivity)) {
      return 0;
    }
    return getNavigationBarHeight(paramActivity);
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      return 0;
      i = paramContext.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
    } while (i <= 0);
    return paramContext.getResources().getDimensionPixelSize(i);
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null)) {}
    int i;
    do
    {
      return 0;
      i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    } while (i <= 0);
    return paramContext.getResources().getDimensionPixelSize(i);
  }
  
  public static boolean hasNotch(Context paramContext)
  {
    if (!inited) {
      if ((!oppoNotch(paramContext)) && (!vivoNotch(paramContext)) && (!huaweiNotch(paramContext))) {
        break label41;
      }
    }
    label41:
    for (boolean bool = true;; bool = false)
    {
      hasNotch = bool;
      inited = true;
      return hasNotch;
    }
  }
  
  public static boolean huaweiNotch(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNavigationBarShown(Activity paramActivity)
  {
    if (paramActivity == null) {}
    int i;
    do
    {
      do
      {
        return false;
        paramActivity = paramActivity.findViewById(16908336);
      } while (paramActivity == null);
      i = paramActivity.getVisibility();
    } while ((i == 8) || (i == 4));
    return true;
  }
  
  public static boolean oppoNotch(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static void setFullScreenWithHideStatusBar(Activity paramActivity)
  {
    if ((!hasNotch(paramActivity)) || (paramActivity == null) || (paramActivity.getWindow() == null)) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity.addFlags(67108864);
        paramActivity.getDecorView().setSystemUiVisibility(1284);
        return;
      }
    } while (Build.VERSION.SDK_INT < 19);
    paramActivity.setFlags(1024, 1024);
  }
  
  public static void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    if ((!hasNotch(paramActivity)) || (paramActivity == null) || (paramActivity.getWindow() == null)) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (Build.VERSION.SDK_INT < 21);
    paramActivity.getDecorView().setSystemUiVisibility(9472);
    paramActivity.clearFlags(67108864);
    paramActivity.addFlags(-2147483648);
    paramActivity.setStatusBarColor(paramInt);
  }
  
  public static boolean vivoNotch(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.utils.NotchUtil
 * JD-Core Version:    0.7.0.1
 */