package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;

class BottomSheetDialogFragment$BottomSheetDismissCallback
  extends BottomSheetBehavior.BottomSheetCallback
{
  private BottomSheetDialogFragment$BottomSheetDismissCallback(BottomSheetDialogFragment paramBottomSheetDialogFragment) {}
  
  public void onSlide(@NonNull View paramView, float paramFloat) {}
  
  public void onStateChanged(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 5) {
      BottomSheetDialogFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialogFragment.BottomSheetDismissCallback
 * JD-Core Version:    0.7.0.1
 */