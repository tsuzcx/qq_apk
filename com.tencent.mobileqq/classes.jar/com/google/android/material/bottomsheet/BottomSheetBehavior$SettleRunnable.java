package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

class BottomSheetBehavior$SettleRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  
  BottomSheetBehavior$SettleRunnable(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.continueSettling(true))) {
      ViewCompat.postOnAnimation(this.jdField_a_of_type_AndroidViewView, this);
    } else {
      this.this$0.e(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable
 * JD-Core Version:    0.7.0.1
 */