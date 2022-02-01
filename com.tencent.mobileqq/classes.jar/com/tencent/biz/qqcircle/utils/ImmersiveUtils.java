package com.tencent.biz.qqcircle.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersiveUtils
{
  public static String a = "ImmersiveUtils";
  public static int b = -1;
  public static boolean c = true;
  public static int d = 67108864;
  public static boolean e = false;
  public static int f = -1;
  public static boolean g = true;
  private static float h = -1.0F;
  private static int i = -1;
  private static int j = -1;
  private static boolean k = false;
  private static boolean l = false;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("smartisan-sm705")) {
      e = true;
    }
    if (((String)localObject).equalsIgnoreCase("vivo-vivo Y35A")) {
      e = true;
    }
  }
  
  public static float a()
  {
    f();
    return h;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(paramFloat * a());
  }
  
  public static int a(Context paramContext)
  {
    if (f == -1)
    {
      SharedPreferences localSharedPreferences = RFApplication.getApplication().getSharedPreferences(a, 4);
      f = localSharedPreferences.getInt("status_bar_height", -1);
      if (f == -1)
      {
        Object localObject = paramContext.getResources();
        int m = ((Resources)localObject).getIdentifier("status_bar_height", "dimen", "android");
        if (m > 0) {
          m = ((Resources)localObject).getDimensionPixelSize(m);
        } else {
          m = 0;
        }
        float f1 = DisplayUtil.a();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getStatusBarHeight org=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(", sys density=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(", cur density=");
          ((StringBuilder)localObject).append(paramContext.getResources().getDisplayMetrics().density);
          QLog.d("systembar", 2, ((StringBuilder)localObject).toString());
        }
        f1 /= paramContext.getResources().getDisplayMetrics().density;
        float f2 = 1.0F;
        if (m <= 0)
        {
          if (f1 <= 0.0F) {
            f1 = f2;
          }
          m = a(f1 * 25.0F);
        }
        else
        {
          float f3 = m;
          if (f1 <= 0.0F) {
            f1 = f2;
          }
          m = (int)Math.ceil(f3 * f1 + 0.5F);
        }
        f = m;
        localSharedPreferences.edit().putInt("status_bar_height", f).apply();
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("height=");
        paramContext.append(f);
        QLog.i("systembar", 2, paramContext.toString());
      }
    }
    return f;
  }
  
  public static void a(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.clearFlags(67108864);
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramWindow.addFlags(67108864);
    }
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MANUFACTURER = ");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append(", MODEL = ");
        localStringBuilder.append(Build.MODEL);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      if ((localObject != null) && ((((String)localObject).equals("MeizuPRO 7-S")) || (((String)localObject).equalsIgnoreCase("MeizuM711C"))))
      {
        b(paramWindow);
        return;
      }
      c(paramWindow);
    }
  }
  
  public static boolean a(boolean paramBoolean, Window paramWindow)
  {
    if (OSUtils.b()) {
      return b(paramWindow, paramBoolean);
    }
    if (OSUtils.a()) {
      return c(paramWindow, paramBoolean);
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWindow.getDecorView().setSystemUiVisibility(9216);
        return true;
      }
    }
    else if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    f();
    return i;
  }
  
  public static void b(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Field localField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
      localField.setAccessible(true);
      localField.setInt(paramWindow.getDecorView(), 0);
      return;
    }
    catch (Exception paramWindow)
    {
      label35:
      break label35;
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "反射修改状态栏颜色失败");
    }
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramWindow != null) {}
    try
    {
      localLayoutParams = paramWindow.getAttributes();
      Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
      localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
      localField1.setAccessible(true);
      localField2.setAccessible(true);
      m = localField1.getInt(null);
      n = localField2.getInt(localLayoutParams);
      if (!paramBoolean) {
        break label195;
      }
      m |= n;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams;
        Field localField2;
        int n;
        boolean bool1;
        continue;
        int m = (m ^ 0xFFFFFFFF) & n;
      }
    }
    localField2.setInt(localLayoutParams, m);
    paramWindow.setAttributes(localLayoutParams);
    bool1 = true;
    break label120;
    bool1 = bool3;
    if (QLog.isColorLevel())
    {
      QLog.e(a, 2, "setStatusBarDarkModeForFlyme: failed");
      bool1 = bool3;
    }
    label120:
    bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow = paramWindow.getDecorView();
      bool2 = bool1;
      if (paramWindow != null)
      {
        n = paramWindow.getSystemUiVisibility();
        if (paramBoolean) {
          m = n | 0x2000;
        } else {
          m = n & 0xFFFFDFFF;
        }
        bool2 = bool1;
        if (m != n)
        {
          paramWindow.setSystemUiVisibility(m);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public static int c()
  {
    f();
    return j;
  }
  
  private static void c(Window paramWindow)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) || (e()))
      {
        paramWindow.clearFlags(67108864);
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        paramWindow.setStatusBarColor(0);
        return;
      }
    }
    catch (Exception paramWindow)
    {
      QLog.e(a, 1, paramWindow, new Object[0]);
    }
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      d(paramWindow, paramBoolean);
      return true;
    }
    return e(paramWindow, paramBoolean);
  }
  
  public static int d()
  {
    int m = b;
    if (m != -1) {
      return m;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      b = 0;
      return b;
    }
    String str = Build.MANUFACTURER.toUpperCase();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (((!str.endsWith("BBK")) && (!str.endsWith("VIVO"))) || ((Build.VERSION.SDK_INT >= 20) && (!((String)localObject).equals("OPPO-3007")))) {
      b = 1;
    } else {
      b = 0;
    }
    return b;
  }
  
  @TargetApi(23)
  private static void d(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
  }
  
  public static boolean e()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private static boolean e(Window paramWindow, boolean paramBoolean)
  {
    Object localObject = paramWindow.getClass();
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int n = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          m = n;
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
          return true;
        }
      }
      catch (Exception paramWindow)
      {
        paramWindow.printStackTrace();
        return false;
      }
      int m = 0;
    }
  }
  
  private static void f()
  {
    if (h == -1.0F)
    {
      DisplayMetrics localDisplayMetrics = RFApplication.getApplication().getResources().getDisplayMetrics();
      h = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        i = localDisplayMetrics.widthPixels;
        j = localDisplayMetrics.heightPixels;
        return;
      }
      j = localDisplayMetrics.widthPixels;
      i = localDisplayMetrics.heightPixels;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */