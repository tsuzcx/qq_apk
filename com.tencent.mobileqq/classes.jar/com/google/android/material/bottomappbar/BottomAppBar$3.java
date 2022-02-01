package com.google.android.material.bottomappbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils.RelativePadding;

class BottomAppBar$3
  implements ViewUtils.OnApplyWindowInsetsListener
{
  BottomAppBar$3(BottomAppBar paramBottomAppBar) {}
  
  @NonNull
  public WindowInsetsCompat a(View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull ViewUtils.RelativePadding paramRelativePadding)
  {
    if (BottomAppBar.f(this.a)) {
      BottomAppBar.a(this.a, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    }
    boolean bool = BottomAppBar.g(this.a);
    int m = 0;
    int k = 0;
    int j;
    if (bool)
    {
      if (BottomAppBar.h(this.a) != paramWindowInsetsCompat.getSystemWindowInsetLeft()) {
        i = 1;
      } else {
        i = 0;
      }
      BottomAppBar.b(this.a, paramWindowInsetsCompat.getSystemWindowInsetLeft());
      j = i;
    }
    else
    {
      j = 0;
    }
    int i = m;
    if (BottomAppBar.i(this.a))
    {
      i = k;
      if (BottomAppBar.j(this.a) != paramWindowInsetsCompat.getSystemWindowInsetRight()) {
        i = 1;
      }
      BottomAppBar.c(this.a, paramWindowInsetsCompat.getSystemWindowInsetRight());
    }
    if ((j != 0) || (i != 0))
    {
      BottomAppBar.k(this.a);
      BottomAppBar.l(this.a);
      BottomAppBar.m(this.a);
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.3
 * JD-Core Version:    0.7.0.1
 */