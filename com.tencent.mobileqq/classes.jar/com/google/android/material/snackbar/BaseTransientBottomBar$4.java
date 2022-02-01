package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

class BaseTransientBottomBar$4
  implements OnApplyWindowInsetsListener
{
  @NonNull
  public WindowInsetsCompat onApplyWindowInsets(View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    BaseTransientBottomBar.b(this.a, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    BaseTransientBottomBar.c(this.a, paramWindowInsetsCompat.getSystemWindowInsetLeft());
    BaseTransientBottomBar.d(this.a, paramWindowInsetsCompat.getSystemWindowInsetRight());
    BaseTransientBottomBar.a(this.a);
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.4
 * JD-Core Version:    0.7.0.1
 */