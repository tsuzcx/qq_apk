package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewBottomSheetDialog$1
  implements View.OnClickListener
{
  NewBottomSheetDialog$1(NewBottomSheetDialog paramNewBottomSheetDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.cancel();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.NewBottomSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */