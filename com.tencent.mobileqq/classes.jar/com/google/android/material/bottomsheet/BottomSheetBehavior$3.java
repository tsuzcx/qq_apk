package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils.RelativePadding;

class BottomSheetBehavior$3
  implements ViewUtils.OnApplyWindowInsetsListener
{
  BottomSheetBehavior$3(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public WindowInsetsCompat a(View paramView, WindowInsetsCompat paramWindowInsetsCompat, ViewUtils.RelativePadding paramRelativePadding)
  {
    BottomSheetBehavior.a(this.a, paramWindowInsetsCompat.getMandatorySystemGestureInsets().bottom);
    BottomSheetBehavior.a(this.a, false);
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.3
 * JD-Core Version:    0.7.0.1
 */