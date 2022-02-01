package com.tencent.luggage.wxa.qz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.wxa.qx.a;

public class l
{
  protected static int a = -1;
  private static int b = -1;
  private static boolean c = false;
  private static int d = -1;
  private static int e = -1;
  
  public static final int a(Context paramContext)
  {
    if (!c)
    {
      if (!h(paramContext)) {
        return r.g().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
      }
      b = r.g().getInt("com.tencent.mm.compatible.util.keybord.height", b(paramContext, 230));
      return b;
    }
    return c(paramContext);
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    int j = c(paramContext);
    if (!e(paramContext))
    {
      double d1 = j;
      Double.isNaN(d1);
      paramInt = (int)(d1 / 1.5D);
      i = g(paramContext)[0] / 2;
      if (paramInt > i) {
        return i;
      }
      return paramInt;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = a(paramContext, true);
    }
    paramInt = b(paramContext);
    if (i > paramInt) {
      return paramInt;
    }
    if (i < j) {
      return j;
    }
    return i;
  }
  
  public static final int a(Context paramContext, boolean paramBoolean)
  {
    if (!c)
    {
      int i = b;
      if ((i > 0) && (paramBoolean)) {
        return i;
      }
      return a(paramContext);
    }
    return c(paramContext);
  }
  
  public static final int b(Context paramContext)
  {
    if (!c)
    {
      int i = d;
      if (i > 0) {
        return i;
      }
      if (!h(paramContext)) {
        return 1140;
      }
      i = b(paramContext, 380);
      d = i;
      return i;
    }
    return c(paramContext);
  }
  
  private static final int b(Context paramContext, int paramInt)
  {
    return a.e(paramContext, paramInt);
  }
  
  public static final int c(Context paramContext)
  {
    int i = e;
    if (i > 0) {
      return i;
    }
    if (!h(paramContext)) {
      return e * 3;
    }
    i = b(paramContext, 230);
    e = i;
    return i;
  }
  
  public static final int d(Context paramContext)
  {
    return a(paramContext, -1);
  }
  
  public static boolean e(Context paramContext)
  {
    return f(paramContext) == 1;
  }
  
  public static int f(Context paramContext)
  {
    paramContext = g(paramContext);
    if (paramContext[0] < paramContext[1]) {
      return 1;
    }
    return 2;
  }
  
  public static int[] g(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = r.a();
    }
    paramContext = new int[2];
    if ((localObject instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)localObject).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      paramContext[0] = localDisplayMetrics.widthPixels;
      paramContext[1] = localDisplayMetrics.heightPixels;
      return paramContext;
    }
    localObject = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay();
    paramContext[0] = ((Display)localObject).getWidth();
    paramContext[1] = ((Display)localObject).getHeight();
    return paramContext;
  }
  
  private static final boolean h(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = r.a();
    }
    return localContext != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.l
 * JD-Core Version:    0.7.0.1
 */