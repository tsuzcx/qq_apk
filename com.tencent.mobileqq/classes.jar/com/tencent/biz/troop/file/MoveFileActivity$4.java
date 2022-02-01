package com.tencent.biz.troop.file;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class MoveFileActivity$4
  implements DialogInterface.OnClickListener
{
  MoveFileActivity$4(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (InputDialog)paramDialogInterface;
    this.a.b = paramDialogInterface.getInputValue().trim();
    if (this.a.b.length() > TroopFileUtils.a)
    {
      paramDialogInterface.a(this.a.getString(2131895154), -65536);
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.a);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      return;
    }
    if (TroopFileUtils.b(this.a.b))
    {
      paramDialogInterface.a(this.a.getString(2131895155), -65536);
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.a);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, ((StringBuilder)localObject).toString(), "0", "", "");
      return;
    }
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.app;
    Object localObject = this.a;
    if (TroopFileUtils.a(paramDialogInterface, (Context)localObject, ((MoveFileActivity)localObject).a) == 0) {
      return;
    }
    TroopFileProtocol.a(this.a.app, this.a.a, "/", this.a.b, MoveFileActivity.k(this.a));
    this.a.a(2131895082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.4
 * JD-Core Version:    0.7.0.1
 */