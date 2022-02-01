package com.app.hubert.guide.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;

public class ScreenUtils
{
  private ScreenUtils()
  {
    throw new AssertionError();
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    return (int)(paramInt * paramContext.getResources().getDisplayMetrics().density);
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    int i = 0;
    if (!isNavigationBarShow(paramActivity)) {
      return 0;
    }
    paramActivity = paramActivity.getResources();
    int j = paramActivity.getIdentifier("navigation_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramActivity.getDimensionPixelSize(j);
    }
    LogUtil.i("NavigationBar的高度:" + i);
    return i;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = dp2px(paramContext, 20);
    LogUtil.i("common statusBar height:" + i);
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(j);
      LogUtil.i("real statusBar height:" + i);
    }
    LogUtil.i("finally statusBar height:" + i);
    return i;
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      if (localPoint2.y == localPoint1.y) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.app.hubert.guide.util.ScreenUtils
 * JD-Core Version:    0.7.0.1
 */