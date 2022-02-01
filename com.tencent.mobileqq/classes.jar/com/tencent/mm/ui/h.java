package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h
{
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      f.d("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
    }
    int k = paramContext.getResources().getDimensionPixelSize(2131296296);
    if ((paramContext instanceof AppCompatActivity))
    {
      paramContext = (AppCompatActivity)paramContext;
      if (paramContext.getSupportActionBar() != null)
      {
        i = paramContext.getSupportActionBar().getHeight();
        break label87;
      }
    }
    else if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if (paramContext.getActionBar() != null)
      {
        i = paramContext.getActionBar().getHeight();
        break label87;
      }
    }
    int i = 0;
    label87:
    int j = i;
    if (i <= 0) {
      j = k;
    }
    f.c("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    return j;
  }
  
  private static int a(Context paramContext, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = i.a(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      f.a("WeUIToolHelper", paramContext, "getStatusBarHeightFromSysR", new Object[0]);
    }
    f.c("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    return paramInt;
  }
  
  public static int b(Context paramContext)
  {
    return a(paramContext, g.a(paramContext, 25));
  }
  
  public static Point c(Context paramContext)
  {
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
        localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        return localPoint;
      }
      catch (InvocationTargetException paramContext)
      {
        f.a("WeUIToolHelper", paramContext, "getDisplayRealSize InvocationTargetException", new Object[0]);
        return localPoint;
      }
      catch (IllegalAccessException paramContext)
      {
        f.a("WeUIToolHelper", paramContext, "getDisplayRealSize IllegalAccessException", new Object[0]);
        return localPoint;
      }
      catch (NoSuchMethodException paramContext)
      {
        f.a("WeUIToolHelper", paramContext, "getDisplayRealSize NoSuchMethodException", new Object[0]);
        return localPoint;
      }
    }
    paramContext.getSize(localPoint);
    return localPoint;
  }
  
  @TargetApi(17)
  public static boolean d(Context paramContext)
  {
    return e(paramContext) > 0;
  }
  
  public static int e(Context paramContext)
  {
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = c(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (h(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (h(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    return j - i;
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool2 = paramContext instanceof Activity;
    boolean bool1 = true;
    if (bool2)
    {
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) != 1024) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static int g(Context paramContext)
  {
    boolean bool = d(paramContext);
    int i = 0;
    if (bool)
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      j = e(paramContext);
      if ((j != 0) && (j < i)) {
        return j;
      }
      return i;
    }
    return 0;
  }
  
  private static boolean h(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */