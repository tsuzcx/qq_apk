package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMHalfBottomDialog$6
  implements View.OnClickListener
{
  MMHalfBottomDialog$6(MMHalfBottomDialog paramMMHalfBottomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.tryHide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.6
 * JD-Core Version:    0.7.0.1
 */