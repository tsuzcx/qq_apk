package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMHalfBottomDialog$4
  implements View.OnClickListener
{
  MMHalfBottomDialog$4(MMHalfBottomDialog paramMMHalfBottomDialog) {}
  
  public void onClick(View paramView)
  {
    if (MMHalfBottomDialog.e(this.a) != null) {
      MMHalfBottomDialog.e(this.a).onClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.4
 * JD-Core Version:    0.7.0.1
 */