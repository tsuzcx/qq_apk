package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.statistics.ReportController;

class DoubleVideoCtrlUI$26
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.am != null)
    {
      this.a.am.q(this.a.am.k().s);
      TipsUtil.a(this.a.al, 1013);
    }
    ReportController.b(null, "CliOper", "", "", "0X8005CFD", "0X8005CFD", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.26
 * JD-Core Version:    0.7.0.1
 */