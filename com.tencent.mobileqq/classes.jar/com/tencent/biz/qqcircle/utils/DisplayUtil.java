package com.tencent.biz.qqcircle.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DisplayUtil
{
  public static int a = 0;
  public static int b = 0;
  private static int c = -1;
  private static float d = -1.0F;
  private static boolean e = true;
  private static int f = -1;
  private static String g;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      g = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
    }
    catch (Throwable localThrowable)
    {
      label56:
      break label56;
    }
    g = null;
  }
  
  public static float a()
  {
    if (d < 0.0F) {
      d = RFApplication.getApplication().getResources().getDisplayMetrics().density;
    }
    return d;
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    else
    {
      localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    }
    int i = Build.VERSION.SDK_INT;
    int m = 1;
    if (i >= 17) {
      if ((!b(paramActivity)) || (!c(paramActivity))) {}
    }
    for (;;)
    {
      i = 1;
      break;
      do
      {
        i = 0;
        break label108;
        if ((e(paramActivity)) && (c(paramActivity))) {
          break;
        }
      } while (!c());
    }
    label108:
    int n = localDisplayMetrics.heightPixels;
    int j = n;
    int k = i;
    if (Build.MANUFACTURER.contains("Xiaomi")) {
      if ((!Build.MODEL.contains("MIX 2S")) && (!Build.MODEL.contains("MI 8")))
      {
        j = n;
        k = i;
        if (!Build.MODEL.contains("MIX 2")) {}
      }
      else
      {
        j = n;
        k = i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (Settings.Global.getInt(RFApplication.getApplication().getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            m = 0;
          }
          j = n;
          k = i;
          if (m != 0)
          {
            j = a(RFApplication.getApplication());
            k = 0;
          }
        }
      }
    }
    i = j;
    if (k != 0) {
      i = j - b(paramActivity);
    }
    return i;
  }
  
  public static int a(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      int i;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
      }
      else
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        try
        {
          i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        }
        catch (InvocationTargetException paramContext)
        {
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalAccessException paramContext)
        {
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalArgumentException paramContext)
        {
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
      }
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      QLog.e("DisplayUtil", 2, paramContext.getMessage());
      return -1;
    }
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier(paramString, "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static int b()
  {
    if (c == -1) {
      c = RFApplication.getApplication().getResources().getDisplayMetrics().densityDpi;
    }
    return c;
  }
  
  public static int b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (e) {
        paramContext = "navigation_bar_height";
      } else {
        paramContext = "navigation_bar_height_landscape";
      }
      return a(localResources, paramContext);
    }
    return 0;
  }
  
  @TargetApi(17)
  public static boolean b(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    paramActivity.getSize(localPoint1);
    paramActivity.getRealSize(localPoint2);
    return localPoint1.y != localPoint2.y;
  }
  
  public static boolean c()
  {
    String str = a("ro.build.display.id", "");
    if (("Flyme 7.1.1.4A".equals(str)) || ("Flyme 7.3.0.0A".equals(str)))
    {
      if (("1".equals(a("persist.sys.mz_mback_nav", "0"))) && ("0".equals(a("persist.sys.mz_mainkeys", "0")))) {
        return true;
      }
      if (("0".equals(a("persist.sys.mz_mback_nav", "0"))) && ("0".equals(a("persist.sys.mz_mback_nav", "0")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean c(@NonNull Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId())))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    if ((Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")) || (Build.MODEL.contains("Redmi K20 Pro"))) && (Build.VERSION.SDK_INT >= 21)) {
      return Settings.Global.getInt(RFApplication.getApplication().getContentResolver(), "force_fsg_nav_bar", 0) == 0;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return d(paramContext) != a(paramContext);
    }
    boolean bool1 = ViewConfiguration.get(paramContext).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    return (!bool1) && (!bool2);
  }
  
  public static int d()
  {
    if (a <= 0) {
      if (RFApplication.getApplication().getResources().getConfiguration().orientation == 2) {
        a = RFApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
      } else {
        a = RFApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return a;
  }
  
  @TargetApi(13)
  public static int d(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    paramContext.getDefaultDisplay().getSize(localPoint);
    return localPoint.y;
  }
  
  public static int e()
  {
    if (b <= 0) {
      if (RFApplication.getApplication().getResources().getConfiguration().orientation == 2) {
        b = RFApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
      } else {
        b = RFApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
      }
    }
    return b;
  }
  
  public static boolean e(Context paramContext)
  {
    int i = f;
    if (i != -1) {
      return i == 1;
    }
    Resources localResources = paramContext.getResources();
    i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if (!"1".equals(g))
      {
        if (!"0".equals(g)) {
          break label101;
        }
        bool = true;
        break label101;
      }
    }
    else if (Build.VERSION.SDK_INT >= 14)
    {
      bool = ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
      break label101;
    }
    boolean bool = false;
    label101:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasNavbar=");
      paramContext.append(bool);
      QLog.d("XPanelContainer", 2, paramContext.toString());
    }
    if (bool)
    {
      f = 1;
      return bool;
    }
    f = 0;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */