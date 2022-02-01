package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;

final class ViewUtils$2
  implements ViewUtils.OnApplyWindowInsetsListener
{
  ViewUtils$2(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ViewUtils.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  @NonNull
  public WindowInsetsCompat a(View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull ViewUtils.RelativePadding paramRelativePadding)
  {
    if (this.a) {
      paramRelativePadding.d += paramWindowInsetsCompat.getSystemWindowInsetBottom();
    }
    boolean bool = ViewUtils.a(paramView);
    if (this.b) {
      if (bool) {
        paramRelativePadding.c += paramWindowInsetsCompat.getSystemWindowInsetLeft();
      } else {
        paramRelativePadding.a += paramWindowInsetsCompat.getSystemWindowInsetLeft();
      }
    }
    if (this.c) {
      if (bool) {
        paramRelativePadding.a += paramWindowInsetsCompat.getSystemWindowInsetRight();
      } else {
        paramRelativePadding.c += paramWindowInsetsCompat.getSystemWindowInsetRight();
      }
    }
    paramRelativePadding.a(paramView);
    ViewUtils.OnApplyWindowInsetsListener localOnApplyWindowInsetsListener = this.d;
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (localOnApplyWindowInsetsListener != null) {
      localWindowInsetsCompat = localOnApplyWindowInsetsListener.a(paramView, paramWindowInsetsCompat, paramRelativePadding);
    }
    return localWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils.2
 * JD-Core Version:    0.7.0.1
 */