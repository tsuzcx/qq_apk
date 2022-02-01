package com.tencent.biz.troop.file;

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
      paramDialogInterface.a(this.a.getString(2131697362), -65536);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.jdField_a_of_type_Long + "", "", "", "");
    }
    do
    {
      return;
      if (TroopFileUtils.a(this.a.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface.a(this.a.getString(2131697363), -65536);
        ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (TroopFileUtils.a(this.a.app, this.a, this.a.jdField_a_of_type_Long) == 0);
    TroopFileProtocol.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131697290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.4
 * JD-Core Version:    0.7.0.1
 */