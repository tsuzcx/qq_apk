package com.tencent.luggage.wxa.rh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;

public final class a
{
  public static int a(@Nullable Activity paramActivity)
  {
    if (!c.a) {
      return 0;
    }
    if (paramActivity == null) {
      return 0;
    }
    return c.a(paramActivity).b();
  }
  
  private static b a(View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      return null;
    }
    for (;;)
    {
      if ((localView instanceof b)) {
        return (b)localView;
      }
      paramView = localView.getParent();
      if (paramView == null) {
        break;
      }
      if (!(paramView instanceof ViewGroup)) {
        return null;
      }
      localView = (View)paramView;
    }
    return null;
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!c.a) {
      return;
    }
    b localb = a(paramView);
    if (localb != null)
    {
      localb.a(paramInt, paramBoolean);
      return;
    }
    paramView = d.a(paramView.getContext());
    if (paramView != null)
    {
      paramView.getWindow().setStatusBarColor(paramInt);
      d.c(paramView.getWindow(), paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.a
 * JD-Core Version:    0.7.0.1
 */