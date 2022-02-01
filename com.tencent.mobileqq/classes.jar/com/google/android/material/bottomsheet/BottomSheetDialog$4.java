package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;

class BottomSheetDialog$4
  extends BottomSheetBehavior.BottomSheetCallback
{
  BottomSheetDialog$4(BottomSheetDialog paramBottomSheetDialog) {}
  
  public void onSlide(@NonNull View paramView, float paramFloat) {}
  
  public void onStateChanged(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 5) {
      this.a.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialog.4
 * JD-Core Version:    0.7.0.1
 */