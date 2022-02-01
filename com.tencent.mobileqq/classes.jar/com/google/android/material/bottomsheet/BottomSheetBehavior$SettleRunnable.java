package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

class BottomSheetBehavior$SettleRunnable
  implements Runnable
{
  int a;
  private final View b;
  private boolean c;
  
  BottomSheetBehavior$SettleRunnable(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    this.b = paramView;
    this.a = paramInt;
  }
  
  public void run()
  {
    if ((this.this$0.i != null) && (this.this$0.i.continueSettling(true))) {
      ViewCompat.postOnAnimation(this.b, this);
    } else {
      this.this$0.e(this.a);
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable
 * JD-Core Version:    0.7.0.1
 */