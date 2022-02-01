package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QIMShortVideoEntryDialog
  extends ReportDialog
  implements View.OnClickListener
{
  QIMShortVideoEntryDialog.IAdvertiseJumpDialogCallBack a;
  
  public void onClick(View paramView)
  {
    if ((this.a == null) || (paramView == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131374459) {
        this.a.a();
      } else if (paramView.getId() == 2131364824) {
        this.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QIMShortVideoEntryDialog
 * JD-Core Version:    0.7.0.1
 */