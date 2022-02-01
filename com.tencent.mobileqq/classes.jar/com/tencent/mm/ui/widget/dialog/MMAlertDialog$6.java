package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMAlertDialog$6
  implements View.OnClickListener
{
  MMAlertDialog$6(MMAlertDialog paramMMAlertDialog, AlertParams paramAlertParams) {}
  
  public void onClick(View paramView)
  {
    if (this.a.I != null) {
      this.a.I.onClick(this.b, -1);
    }
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.6
 * JD-Core Version:    0.7.0.1
 */