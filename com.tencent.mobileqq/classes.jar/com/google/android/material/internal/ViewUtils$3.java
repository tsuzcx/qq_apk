package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

final class ViewUtils$3
  implements OnApplyWindowInsetsListener
{
  ViewUtils$3(ViewUtils.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener, ViewUtils.RelativePadding paramRelativePadding) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return this.a.a(paramView, paramWindowInsetsCompat, new ViewUtils.RelativePadding(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils.3
 * JD-Core Version:    0.7.0.1
 */