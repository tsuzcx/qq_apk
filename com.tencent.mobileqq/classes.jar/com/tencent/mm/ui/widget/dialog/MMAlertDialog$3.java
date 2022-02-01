package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMAlertDialog$3
  implements View.OnClickListener
{
  MMAlertDialog$3(MMAlertDialog paramMMAlertDialog, MMAlertDialog.Builder.IOnContentClick paramIOnContentClick) {}
  
  public void onClick(View paramView)
  {
    MMAlertDialog.Builder.IOnContentClick localIOnContentClick = this.a;
    if (localIOnContentClick != null) {
      localIOnContentClick.onContentClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.3
 * JD-Core Version:    0.7.0.1
 */