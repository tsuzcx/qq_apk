package com.tencent.falco.utils;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class UIUtil
{
  private static final String TAG = "UIUtil";
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static void fixAudioManagerLeak(Context paramContext)
  {
    Log.i("AudioManagerLeak", "fixAudioManagerLeak");
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    try
    {
      Field localField = paramContext.getClass().getDeclaredField("mContext");
      localField.setAccessible(true);
      localField.set(paramContext, null);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.i("AudioManagerLeak", paramContext.getMessage());
    }
  }
  
  public static void fixInputMethodManagerLeak(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    String[] arrayOfString = new String[4];
    int i = 0;
    arrayOfString[0] = "mCurRootView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    arrayOfString[3] = "mLastSrvView";
    while (i < arrayOfString.length)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (localObject1 == null) {
          return;
        }
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject2 != null) && ((localObject2 instanceof View)))
        {
          localObject2 = (View)localObject2;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("v_get.getContext() is ");
          localStringBuilder.append(((View)localObject2).getContext());
          Log.i("UIUtil", localStringBuilder.toString());
          if ((((View)localObject2).getContext() instanceof MutableContextWrapper))
          {
            localObject2 = ((MutableContextWrapper)((View)localObject2).getContext()).getBaseContext();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("contextis ");
            localStringBuilder.append(localObject2);
            localStringBuilder.append(", destContext is ");
            localStringBuilder.append(paramContext);
            Log.i("UIUtil", localStringBuilder.toString());
            if (localObject2 == paramContext) {
              ((Field)localObject1).set(localInputMethodManager, null);
            }
          }
          else if (((View)localObject2).getContext() == paramContext)
          {
            ((Field)localObject1).set(localInputMethodManager, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      i += 1;
    }
  }
  
  public static int getContentViewHeight(Context paramContext)
  {
    return getScreenHeight(paramContext) - getStatusBarHeight(paramContext);
  }
  
  private static String getNavBarOverride()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label53:
      break label53;
    }
    return null;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    if (hasNavBar(paramContext))
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0) {
        return paramContext.getDimensionPixelSize(i);
      }
    }
    return 0;
  }
  
  public static int getRawScreenHeight(Context paramContext)
  {
    int i;
    if (isMeizu()) {
      i = getScreenHeight(paramContext);
    }
    for (int j = getSmartBarHeight(paramContext);; j = getNavigationBarHeight(paramContext))
    {
      return i - j;
      i = getScreenHeight(paramContext);
    }
  }
  
  public static int getRealScreenHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      return localDisplayMetrics.heightPixels;
    }
    return 0;
  }
  
  public static float getScreenDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int getScreenDensityDpi(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics.heightPixels;
    }
    return 0;
  }
  
  public static DisplayMetrics getScreenMetrics(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static int[] getScreenSize(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    int k = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    int j = m;
    int i = k;
    if (Build.VERSION.SDK_INT >= 14)
    {
      j = m;
      i = k;
      if (Build.VERSION.SDK_INT < 17)
      {
        i = k;
        try
        {
          k = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          i = k;
          j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          i = k;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = m;
        }
      }
    }
    m = j;
    k = i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      k = i;
      try
      {
        Point localPoint = new Point();
        k = i;
        Display.class.getMethod("getRealSize", new Class[] { Point.class }).invoke(paramContext, new Object[] { localPoint });
        k = i;
        i = localPoint.x;
        k = i;
        m = localPoint.y;
        k = i;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        m = j;
      }
    }
    return new int[] { k, m };
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics.widthPixels;
    }
    return 0;
  }
  
  private static int getSmartBarHeight(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("mz_action_button_min_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      i = localResources.getDimensionPixelSize(i);
    } else {
      i = -1;
    }
    int j = i;
    if (i <= 0) {
      j = dp2px(paramContext, 25.0F);
    }
    return j;
  }
  
  public static boolean hasNavBar(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      boolean bool = localResources.getBoolean(i);
      paramContext = getNavBarOverride();
      if ("1".equals(paramContext)) {
        return false;
      }
      if ("0".equals(paramContext)) {
        return true;
      }
      return bool;
    }
    return ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
  }
  
  public static boolean isMIUI()
  {
    return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean isMeizu()
  {
    return Build.BRAND.equals("Meizu");
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      localDisplay.getSize(localPoint1);
      localDisplay.getRealSize(localPoint2);
      int i;
      if (paramBoolean) {
        i = localPoint1.y + getStatusBarHeight(paramActivity.getApplicationContext());
      } else {
        i = localPoint1.y;
      }
      return localPoint2.y != i;
    }
    paramBoolean = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool = KeyCharacterMap.deviceHasKey(4);
    if (!paramBoolean) {
      return !bool;
    }
    return false;
  }
  
  public static boolean isNavigationBarVisible(Window paramWindow)
  {
    boolean bool2 = false;
    if (paramWindow == null) {
      return false;
    }
    Object localObject1 = paramWindow.getAttributes();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = (ViewGroup)paramWindow.getDecorView();
      i = ((WindowManager.LayoutParams)localObject1).systemUiVisibility;
      if ((((((ViewGroup)localObject2).getWindowSystemUiVisibility() | i) & 0x2) == 0) && ((((WindowManager.LayoutParams)localObject1).flags & 0x80000000) != 0))
      {
        m = 1;
        break label68;
      }
    }
    int m = 0;
    label68:
    paramWindow = paramWindow.getDecorView();
    localObject1 = paramWindow.getClass();
    try
    {
      localObject2 = ((Class)localObject1).getDeclaredField("mLastBottomInset");
      ((Field)localObject2).setAccessible(true);
      i = ((Field)localObject2).getInt(paramWindow);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      i = 0;
    }
    int j;
    try
    {
      Field localField = ((Class)localObject1).getDeclaredField("mLastRightInset");
      localField.setAccessible(true);
      j = localField.getInt(paramWindow);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      j = 0;
    }
    int k;
    try
    {
      localObject1 = ((Class)localObject1).getDeclaredField("mLastLeftInset");
      ((Field)localObject1).setAccessible(true);
      k = ((Field)localObject1).getInt(paramWindow);
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
      k = 0;
    }
    int n;
    if ((i == 0) && (j > 0)) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0) {
      k = j;
    } else if ((i != 0) || (k <= 0)) {
      k = i;
    }
    boolean bool1 = bool2;
    if (m != 0)
    {
      bool1 = bool2;
      if (k > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isScreenPortrait(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 1;
  }
  
  public static float px2dp(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static void setFullscreen(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      setFullscreen(paramActivity.getWindow(), paramBoolean1, paramBoolean2);
    }
  }
  
  public static void setFullscreen(Window paramWindow, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (!paramBoolean1) {
      i = 5380;
    } else {
      i = 5376;
    }
    int j = i;
    if (!paramBoolean2) {
      j = i | 0x2 | 0x800;
    }
    if (paramWindow != null) {
      paramWindow.getDecorView().setSystemUiVisibility(j);
    }
  }
  
  public static void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      setStatusBarColor(paramActivity.getWindow(), paramInt);
    }
  }
  
  public static void setStatusBarColor(Window paramWindow, int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramWindow != null))
    {
      paramWindow.clearFlags(67108864);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.UIUtil
 * JD-Core Version:    0.7.0.1
 */