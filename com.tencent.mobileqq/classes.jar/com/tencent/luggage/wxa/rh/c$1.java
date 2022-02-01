package com.tencent.luggage.wxa.rh;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

class c$1
  implements View.OnApplyWindowInsetsListener
{
  c$1(c paramc, ViewGroup paramViewGroup) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    c localc = this.b;
    c.b(localc, c.a(localc, paramWindowInsets.getSystemWindowInsetTop()));
    paramWindowInsets = paramWindowInsets.consumeSystemWindowInsets();
    if (paramView != this.a) {
      paramView.onApplyWindowInsets(paramWindowInsets);
    }
    return paramWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.c.1
 * JD-Core Version:    0.7.0.1
 */