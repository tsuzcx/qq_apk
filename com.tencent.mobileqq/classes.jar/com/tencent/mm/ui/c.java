package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(21)
public class c
{
  private static final boolean a;
  private static final WeakHashMap<Activity, c> b = new WeakHashMap();
  private WindowInsets c;
  private final Set<View.OnApplyWindowInsetsListener> d = new HashSet();
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 23) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  private c(@NonNull Activity paramActivity)
  {
    paramActivity.runOnUiThread(new c.1(this, paramActivity));
  }
  
  @Nullable
  private WindowInsets a()
  {
    try
    {
      WindowInsets localWindowInsets = this.c;
      return localWindowInsets;
    }
    finally {}
  }
  
  @TargetApi(21)
  public static c a(@NonNull Activity paramActivity)
  {
    return a(paramActivity, true);
  }
  
  private static c a(@NonNull Activity paramActivity, boolean paramBoolean)
  {
    synchronized (b)
    {
      c localc2 = (c)b.get(paramActivity);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = localc2;
        if (paramBoolean)
        {
          localc1 = new c(paramActivity);
          b.put(paramActivity, localc1);
        }
      }
      return localc1;
    }
  }
  
  @Nullable
  public static WindowInsets b(@NonNull Activity paramActivity)
  {
    if (a)
    {
      paramActivity = a(paramActivity, false);
      if (paramActivity == null) {
        return null;
      }
      return paramActivity.a();
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.getWindow().getDecorView().getRootWindowInsets();
    }
    return null;
  }
  
  public void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null) {
      return;
    }
    synchronized (this.d)
    {
      this.d.add(paramOnApplyWindowInsetsListener);
      return;
    }
  }
  
  public void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null) {
      return;
    }
    synchronized (this.d)
    {
      this.d.remove(paramOnApplyWindowInsetsListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c
 * JD-Core Version:    0.7.0.1
 */