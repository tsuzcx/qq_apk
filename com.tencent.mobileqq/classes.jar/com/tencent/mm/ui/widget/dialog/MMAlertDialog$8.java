package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMAlertDialog$8
  implements View.OnClickListener
{
  MMAlertDialog$8(MMAlertDialog paramMMAlertDialog, AlertParams paramAlertParams) {}
  
  public void onClick(View paramView)
  {
    if (this.a.K != null) {
      this.a.K.onClick(this.b, -3);
    }
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.8
 * JD-Core Version:    0.7.0.1
 */