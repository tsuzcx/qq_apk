package com.tencent.avgame.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class AvGameLoadingActivity$8
  implements DialogInterface.OnClickListener
{
  AvGameLoadingActivity$8(AvGameLoadingActivity paramAvGameLoadingActivity, AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = -102;
    if (paramInt == 1)
    {
      paramDialogInterface.cancel();
      if (this.a != null)
      {
        Object localObject2 = null;
        Object localObject1 = null;
        AvGameLoadingActivity.d(this.d, true);
        AvGameLoadingActivity.b(this.d, 5);
        paramDialogInterface = localObject2;
        if (!this.b) {
          if (AvGameLoadingActivity.d(this.d) != 3)
          {
            paramDialogInterface = localObject2;
            if (AvGameLoadingActivity.d(this.d) != 5) {}
          }
          else
          {
            paramDialogInterface = (DialogInterface)localObject1;
            if (AvGameLoadingActivity.n(this.d) != null)
            {
              AvGameLoadingActivity.b(this.d, 6);
              paramDialogInterface = AvGameLoadingActivity.n(this.d);
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("join failed alert DIALOG change to troop  with  troop UIN ");
            ((StringBuilder)localObject1).append(paramDialogInterface);
            QLog.e("AvGameLoadingActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = this.d;
        AvGameLoadingActivity.a((AvGameLoadingActivity)localObject1, AvGameLoadingActivity.o((AvGameLoadingActivity)localObject1), paramDialogInterface);
        return;
      }
      QLog.e("AvGameLoadingActivity", 2, "alertDialogWithRetCode createAvGameRoom app null ");
      if (!this.b) {
        i = -103;
      }
      AVGameNodeReportUtil.b(i);
      AvGameLoadingActivity.a(this.d, false, this.c);
      return;
    }
    paramDialogInterface.cancel();
    if (!this.b) {
      i = -103;
    }
    AVGameNodeReportUtil.b(i);
    AvGameLoadingActivity.a(this.d, false, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.8
 * JD-Core Version:    0.7.0.1
 */