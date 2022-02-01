package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMConfirmDialog$Builder$2
  implements View.OnClickListener
{
  MMConfirmDialog$Builder$2(MMConfirmDialog.Builder paramBuilder, CheckBox paramCheckBox, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof CheckBox)))
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      if (localCheckBox.isChecked()) {
        MMConfirmDialog.Builder.b(this.c)[((java.lang.Integer)this.a.getTag()).intValue()] = 1;
      } else {
        MMConfirmDialog.Builder.b(this.c)[((java.lang.Integer)this.a.getTag()).intValue()] = 0;
      }
      if (MMConfirmDialog.Builder.c(this.c) != null) {
        MMConfirmDialog.Builder.c(this.c).onCheckboxClick(this.b, localCheckBox.isChecked(), MMConfirmDialog.Builder.b(this.c));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.2
 * JD-Core Version:    0.7.0.1
 */