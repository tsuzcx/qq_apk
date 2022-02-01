package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.tencent.mm.plugin.appbrand.page.am;

public final class h
{
  private static final h b = new h();
  private final h.a a = new h.a(null);
  
  public static h a()
  {
    return b;
  }
  
  @MainThread
  void a(am paramam)
  {
    if (paramam == null) {
      return;
    }
    this.a.a(paramam);
    try
    {
      paramam.getWrapperView().setFocusable(true);
      paramam.getWrapperView().setFocusableInTouchMode(true);
      paramam.getContentView().setFocusable(true);
      paramam.getContentView().setFocusableInTouchMode(true);
      return;
    }
    catch (NullPointerException paramam) {}
  }
  
  @MainThread
  public void b(am paramam)
  {
    if (paramam == null) {
      return;
    }
    int i = this.a.a(paramam, 0);
    this.a.b(paramam, i + 1);
    try
    {
      paramam.getWrapperView().setFocusable(false);
      paramam.getWrapperView().setFocusableInTouchMode(false);
      paramam.getContentView().setFocusable(false);
      paramam.getContentView().setFocusableInTouchMode(false);
      if ((paramam.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)paramam.getWrapperView()).setDescendantFocusability(393216);
      }
      return;
    }
    catch (NullPointerException paramam) {}
  }
  
  @MainThread
  public void c(am paramam)
  {
    if (paramam == null) {
      return;
    }
    int i = this.a.a(paramam, 0) - 1;
    if (i <= 0)
    {
      a(paramam);
      return;
    }
    this.a.b(paramam, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.h
 * JD-Core Version:    0.7.0.1
 */