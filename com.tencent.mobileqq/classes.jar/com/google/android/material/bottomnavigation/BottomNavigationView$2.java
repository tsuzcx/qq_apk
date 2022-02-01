package com.google.android.material.bottomnavigation;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils.RelativePadding;

class BottomNavigationView$2
  implements ViewUtils.OnApplyWindowInsetsListener
{
  BottomNavigationView$2(BottomNavigationView paramBottomNavigationView) {}
  
  @NonNull
  public WindowInsetsCompat a(View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull ViewUtils.RelativePadding paramRelativePadding)
  {
    paramRelativePadding.d += paramWindowInsetsCompat.getSystemWindowInsetBottom();
    int j = ViewCompat.getLayoutDirection(paramView);
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    j = paramWindowInsetsCompat.getSystemWindowInsetLeft();
    int k = paramWindowInsetsCompat.getSystemWindowInsetRight();
    int n = paramRelativePadding.a;
    if (i != 0) {
      m = k;
    } else {
      m = j;
    }
    paramRelativePadding.a = (n + m);
    int m = paramRelativePadding.c;
    if (i == 0) {
      j = k;
    }
    paramRelativePadding.c = (m + j);
    paramRelativePadding.a(paramView);
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView.2
 * JD-Core Version:    0.7.0.1
 */