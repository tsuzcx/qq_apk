package com.dataline.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$13
  implements DialogInterface.OnClickListener
{
  LiteActivity$13(LiteActivity paramLiteActivity, long paramLong, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.c.getIntent().getIntExtra("forward_type", -1) == 11) {
      ReportCenter.a().a(this.c.app.getAccount(), "", String.valueOf(this.a), "1000", "51", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i(LiteActivity.a, 2, "qbShowShareResultDialog back");
    }
    if (this.c.getIntent().getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.c.getIntent().putExtra("MigSdkShareNotDone", false);
      ForwardSdkShareOption.a(this.c, true, "sendToMyComputer", this.a);
    }
    else
    {
      ForwardSdkShareOption.a(this.c, true, "shareToQQ", this.a);
    }
    Util.a(this.b, 0, "", "");
    if (LiteActivity.d(this.c)) {
      this.c.finish();
    }
    if (this.c.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        this.c.getActivity().moveTaskToBack(true);
        return;
      }
      catch (Throwable paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(LiteActivity.a, 2, "qbShowShareResultDialog ", paramDialogInterface);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.13
 * JD-Core Version:    0.7.0.1
 */