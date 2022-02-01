package com.google.android.material.bottomsheet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottomSheetDialog$1
  implements View.OnClickListener
{
  BottomSheetDialog$1(BottomSheetDialog paramBottomSheetDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b) && (this.a.isShowing()) && (this.a.c())) {
      this.a.cancel();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */