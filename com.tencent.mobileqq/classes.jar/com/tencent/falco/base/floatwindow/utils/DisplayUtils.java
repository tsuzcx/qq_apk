package com.tencent.falco.base.floatwindow.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.falco.base.floatwindow.permission.romutils.PhoneRomUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/utils/DisplayUtils;", "", "()V", "TAG", "", "getNavigationBarCurrentHeight", "", "context", "Landroid/content/Context;", "getNavigationBarHeight", "getScreenSize", "Landroid/graphics/Point;", "hasNavigationBar", "", "isHasNavigationBar", "isHuaWeiHideNav", "isMiuiFullScreen", "isVivoFullScreen", "rejectedNavHeight", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class DisplayUtils
{
  public static final DisplayUtils INSTANCE = new DisplayUtils();
  private static final String TAG = "DisplayUtils";
  
  private final int getNavigationBarCurrentHeight(Context paramContext)
  {
    if (hasNavigationBar(paramContext)) {
      return getNavigationBarHeight(paramContext);
    }
    return 0;
  }
  
  private final int getNavigationBarHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      i = paramContext.getDimensionPixelSize(i);
    } else {
      i = 0;
    }
    paramContext = new StringBuilder();
    paramContext.append("getNavigationBarHeight = ");
    paramContext.append(i);
    Log.d("DisplayUtils", paramContext.toString());
    return i;
  }
  
  private final Point getScreenSize(Context paramContext)
  {
    Point localPoint = new Point();
    paramContext = paramContext.getSystemService("window");
    if (paramContext != null)
    {
      paramContext = ((WindowManager)paramContext).getDefaultDisplay();
      if (paramContext != null) {
        paramContext.getRealSize(localPoint);
      }
      return localPoint;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final boolean hasNavigationBar(Context paramContext)
  {
    if (getNavigationBarHeight(paramContext) == 0) {
      return false;
    }
    if ((PhoneRomUtils.INSTANCE.checkIsHuaweiRom()) && (isHuaWeiHideNav(paramContext))) {
      return false;
    }
    if ((PhoneRomUtils.INSTANCE.checkIsMiuiRom()) && (isMiuiFullScreen(paramContext))) {
      return false;
    }
    if ((PhoneRomUtils.INSTANCE.checkIsVivoRom()) && (isVivoFullScreen(paramContext))) {
      return false;
    }
    return isHasNavigationBar(paramContext);
  }
  
  private final boolean isHasNavigationBar(Context paramContext)
  {
    Object localObject = paramContext.getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
          ((Display)localObject).getRealMetrics(localDisplayMetrics);
        }
        int i = localDisplayMetrics.heightPixels;
        int j = localDisplayMetrics.widthPixels;
        localDisplayMetrics = new DisplayMetrics();
        ((Display)localObject).getMetrics(localDisplayMetrics);
        int k = localDisplayMetrics.heightPixels;
        int m = localDisplayMetrics.widthPixels;
        if (getNavigationBarHeight(paramContext) + k > i) {
          return false;
        }
        if (j - m <= 0)
        {
          bool1 = bool2;
          if (i - k <= 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final boolean isHuaWeiHideNav(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 21) {
      i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
    } else {
      i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean isMiuiFullScreen(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.Global.getInt(paramContext, "force_fsg_nav_bar", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean isVivoFullScreen(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.Secure.getInt(paramContext, "navigation_gesture_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  @JvmStatic
  public static final int rejectedNavHeight(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Point localPoint = INSTANCE.getScreenSize(paramContext);
    if (localPoint.x > localPoint.y) {
      return localPoint.y;
    }
    return localPoint.y - INSTANCE.getNavigationBarCurrentHeight(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.utils.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */