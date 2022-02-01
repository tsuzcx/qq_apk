package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.luggage.wxa.hg.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.re.c;
import java.lang.reflect.Method;

public class a
{
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    int i = (int)((paramInt1 >> 24 & 0xFF) * paramFloat + (paramInt2 >> 24 & 0xFF) * f);
    int j = (int)((paramInt1 >> 16 & 0xFF) * paramFloat + (paramInt2 >> 16 & 0xFF) * f);
    int k = (int)((paramInt1 >> 8 & 0xFF) * paramFloat + (paramInt2 >> 8 & 0xFF) * f);
    return ((int)((paramInt1 & 0xFF) * paramFloat + (paramInt2 & 0xFF) * f) & 0xFF) << 0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    Object localObject1 = (WindowManager)paramContext.getSystemService("window");
    if (localObject1 == null)
    {
      o.b("Luggage.LuggageUIHelper", "getRealBottomHeight, get NULL windowManager");
      return 0;
    }
    Object localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
    localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = f(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom - ((Rect)localObject1).top, ((Rect)localObject1).right - ((Rect)localObject1).left);
    }
    return j - i;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return g.a(paramContext, paramInt);
  }
  
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
  }
  
  public static boolean a()
  {
    return (Build.VERSION.SDK_INT >= 23) && (!c.c());
  }
  
  public static int b(Context paramContext)
  {
    return a(paramContext, 25);
  }
  
  private static int b(Context paramContext, int paramInt)
  {
    Rect localRect = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > paramInt)
    {
      o.c("Luggage.LuggageUIHelper", "[fixStatusBarHeight] top:%s statusHeight:%s", new Object[] { Integer.valueOf(localRect.top), Integer.valueOf(paramInt) });
      return 0;
    }
    return paramInt;
  }
  
  public static void b(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.addFlags(-2147483648);
      paramWindow.setNavigationBarColor(0);
      if (Build.VERSION.SDK_INT >= 28) {
        paramWindow.setNavigationBarDividerColor(0);
      }
    }
  }
  
  public static int c(Context paramContext)
  {
    int i = a(paramContext, -1);
    if (i > 0) {
      return b(paramContext, i);
    }
    if ((paramContext instanceof Activity))
    {
      Rect localRect = new Rect();
      paramContext = (Activity)paramContext;
      paramContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      i = paramContext.getWindow().getDecorView().getHeight();
      int[] arrayOfInt = new int[2];
      paramContext.getWindow().getDecorView().getLocationOnScreen(arrayOfInt);
      if ((i - localRect.height() >= 0) && (arrayOfInt[1] > 200)) {
        return i - localRect.height();
      }
      return localRect.top;
    }
    return com.tencent.luggage.wxa.qx.a.e(paramContext, 20);
  }
  
  public static boolean c(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      if (paramWindow.getDecorView() == null) {
        return false;
      }
      if (a())
      {
        paramWindow = paramWindow.getDecorView();
        int i = paramWindow.getSystemUiVisibility();
        if (paramBoolean) {
          i |= 0x2000;
        } else {
          i &= 0xFFFFDFFF;
        }
        paramWindow.setSystemUiVisibility(i);
        return true;
      }
    }
    return false;
  }
  
  public static void d(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      a(((Activity)paramContext).getWindow());
    }
  }
  
  public static void d(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      if (paramWindow.getDecorView() == null) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramWindow = paramWindow.getDecorView();
        int i = paramWindow.getSystemUiVisibility();
        if (paramBoolean) {
          i |= 0x10;
        } else {
          i &= 0xFFFFFFEF;
        }
        paramWindow.setSystemUiVisibility(i);
      }
    }
  }
  
  @TargetApi(17)
  public static boolean e(Context paramContext)
  {
    return a(paramContext) > 0;
  }
  
  public static Point f(Context paramContext)
  {
    Point localPoint = new Point();
    if (paramContext == null) {
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      return localPoint;
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    paramContext.getSize(localPoint);
    return localPoint;
    paramContext.getSize(localPoint);
    return localPoint;
  }
  
  public static int g(Context paramContext)
  {
    boolean bool = e(paramContext);
    int j = 0;
    int i = j;
    if (bool)
    {
      int k = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      i = j;
      if (k > 0) {
        i = Resources.getSystem().getDimensionPixelSize(k);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */