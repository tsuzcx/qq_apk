package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.qz.o;

public class c
  extends com.tencent.mm.ui.a
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Activity localActivity = com.tencent.luggage.wxa.rc.a.a(paramContext);
    if ((localActivity != null) && (localActivity.getWindow() != null))
    {
      a(localActivity.getWindow(), paramBoolean);
      return;
    }
    o.c("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", new Object[] { paramContext });
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    a(paramWindow, paramBoolean, false);
  }
  
  public static void a(Window paramWindow, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = e(paramWindow, true);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new c.1(paramWindow));
      paramWindow.addFlags(1024);
      if ((paramBoolean2) && (Build.VERSION.SDK_INT >= 28))
      {
        paramWindow.getAttributes().layoutInDisplayCutoutMode = 1;
        paramWindow.setAttributes(paramWindow.getAttributes());
      }
    }
    else
    {
      i = e(paramWindow, false);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
      try
      {
        paramWindow.clearFlags(1024);
        return;
      }
      catch (Exception paramWindow)
      {
        o.a("MicroMsg.AppBrandUIUtil", paramWindow, "[CAUGHT CRASH]", new Object[0]);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = paramContext instanceof Activity;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    try
    {
      int i = ((Activity)paramContext).getWindow().getAttributes().flags;
      if ((i & 0x400) == 1024) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 24) {
      return false;
    }
    if (paramView == null) {
      return false;
    }
    paramView = com.tencent.luggage.wxa.rc.a.a(paramView.getContext());
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.isInMultiWindowMode()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int e(Window paramWindow, boolean paramBoolean)
  {
    int i = paramWindow.getDecorView().getSystemUiVisibility();
    int j;
    if (paramBoolean)
    {
      j = i | 0x400 | 0x100;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j | 0x200 | 0x2;
      }
      j = i | 0x4;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j | 0x1000;
      }
    }
    else
    {
      j = i & 0xFFFFFBFF & 0xFFFFFEFF;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j & 0xFFFFFDFF & 0xFFFFFFFD;
      }
      j = i & 0xFFFFFFFB;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j & 0xFFFFEFFF;
      }
    }
    o.d("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */