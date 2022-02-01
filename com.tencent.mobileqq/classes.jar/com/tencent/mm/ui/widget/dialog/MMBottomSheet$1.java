package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMBottomSheet$1
  implements View.OnClickListener
{
  MMBottomSheet$1(MMBottomSheet paramMMBottomSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.tryHide();
    if (MMBottomSheet.a(this.a) != null) {
      MMBottomSheet.a(this.a).onClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.1
 * JD-Core Version:    0.7.0.1
 */