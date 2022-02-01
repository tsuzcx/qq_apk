package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomSheetDialog$1
  implements View.OnClickListener
{
  CustomSheetDialog$1(CustomSheetDialog paramCustomSheetDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.cancel();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.CustomSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */