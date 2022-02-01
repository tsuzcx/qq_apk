package com.tencent.luggage.wxa.rh;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;

public class d
  extends com.tencent.mm.ui.a
{
  @Nullable
  public static Activity a(@Nullable Context paramContext)
  {
    return com.tencent.luggage.wxa.rc.a.a(paramContext);
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    return c(paramActivity.getWindow());
  }
  
  public static boolean c(Window paramWindow)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramWindow != null)
    {
      if (paramWindow.getDecorView() == null) {
        return false;
      }
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void d(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.clearFlags(67108864);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
  }
  
  @Nullable
  public static ContextThemeWrapper h(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof ContextThemeWrapper)) {
      return (ContextThemeWrapper)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext != paramContext) {
        return h(localContext);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.d
 * JD-Core Version:    0.7.0.1
 */