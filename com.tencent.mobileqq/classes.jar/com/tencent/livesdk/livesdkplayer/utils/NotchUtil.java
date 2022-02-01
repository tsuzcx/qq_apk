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
    if ((hasNotch(paramActivity)) && (paramActivity != null))
    {
      if (paramActivity.getWindow() == null) {
        return;
      }
      Window localWindow = paramActivity.getWindow();
      Object localObject;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = localWindow.getDecorView();
        int i;
        if (paramBoolean) {
          i = 8192;
        } else {
          i = 0;
        }
        ((View)localObject).setSystemUiVisibility(i | 0x500);
        localWindow.clearFlags(67108864);
        localWindow.clearFlags(1024);
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        localObject = localWindow.getAttributes();
        if (localObject != null) {
          ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
        }
        localWindow.setAttributes((WindowManager.LayoutParams)localObject);
      }
      if (paramView != null) {
        paramView.setPadding(0, getStatusBarHeight(paramActivity), 0, 0);
      }
    }
  }
  
  public static void adjustWindow(Window paramWindow, View paramView, boolean paramBoolean)
  {
    if (hasNotch(paramView.getContext()))
    {
      if (paramWindow == null) {
        return;
      }
      Object localObject;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = paramWindow.getDecorView();
        int i;
        if (paramBoolean) {
          i = 8192;
        } else {
          i = 0;
        }
        ((View)localObject).setSystemUiVisibility(i | 0x500);
        paramWindow.clearFlags(67108864);
        paramWindow.addFlags(-2147483648);
        paramWindow.setStatusBarColor(0);
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        localObject = paramWindow.getAttributes();
        if (localObject != null) {
          ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
        }
        paramWindow.setAttributes((WindowManager.LayoutParams)localObject);
      }
      if (paramView != null) {
        paramView.setPadding(0, getStatusBarHeight(paramView.getContext()), 0, 0);
      }
    }
  }
  
  public static int getCurrentNavigationBarHeight(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    if (isNavigationBarShown(paramActivity)) {
      return getNavigationBarHeight(paramActivity);
    }
    return 0;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    int i = 0;
    if (paramContext == null) {
      return 0;
    }
    int j = paramContext.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      if (paramContext.getResources() == null) {
        return 0;
      }
      int k = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
      i = j;
      if (k > 0) {
        i = paramContext.getResources().getDimensionPixelSize(k);
      }
    }
    return i;
  }
  
  public static boolean hasNotch(Context paramContext)
  {
    if (!inited)
    {
      boolean bool;
      if ((!oppoNotch(paramContext)) && (!vivoNotch(paramContext)) && (!huaweiNotch(paramContext))) {
        bool = false;
      } else {
        bool = true;
      }
      hasNotch = bool;
      inited = true;
    }
    return hasNotch;
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
    if (paramActivity == null) {
      return false;
    }
    paramActivity = paramActivity.findViewById(16908336);
    if (paramActivity == null) {
      return false;
    }
    int i = paramActivity.getVisibility();
    if (i != 8) {
      return i != 4;
    }
    return false;
  }
  
  public static boolean oppoNotch(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static void setFullScreenWithHideStatusBar(Activity paramActivity)
  {
    if ((hasNotch(paramActivity)) && (paramActivity != null))
    {
      if (paramActivity.getWindow() == null) {
        return;
      }
      paramActivity = paramActivity.getWindow();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity.addFlags(67108864);
        paramActivity.getDecorView().setSystemUiVisibility(1284);
        return;
      }
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.setFlags(1024, 1024);
      }
    }
  }
  
  public static void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    if ((hasNotch(paramActivity)) && (paramActivity != null))
    {
      if (paramActivity.getWindow() == null) {
        return;
      }
      paramActivity = paramActivity.getWindow();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity.getDecorView().setSystemUiVisibility(9472);
        paramActivity.clearFlags(67108864);
        paramActivity.addFlags(-2147483648);
        paramActivity.setStatusBarColor(paramInt);
      }
    }
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