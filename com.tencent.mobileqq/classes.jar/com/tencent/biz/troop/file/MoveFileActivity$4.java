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
    this.a.jdField_a_of_type_JavaLangString = paramDialogInterface.getInputValue().trim();
    if (this.a.jdField_a_of_type_JavaLangString.length() > TroopFileUtils.a)
    {
      paramDialogInterface.a(this.a.getString(2131697381), -65536);
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      return;
    }
    if (TroopFileUtils.a(this.a.jdField_a_of_type_JavaLangString))
    {
      paramDialogInterface.a(this.a.getString(2131697382), -65536);
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, ((StringBuilder)localObject).toString(), "0", "", "");
      return;
    }
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.app;
    Object localObject = this.a;
    if (TroopFileUtils.a(paramDialogInterface, (Context)localObject, ((MoveFileActivity)localObject).jdField_a_of_type_Long) == 0) {
      return;
    }
    TroopFileProtocol.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131697309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.4
 * JD-Core Version:    0.7.0.1
 */