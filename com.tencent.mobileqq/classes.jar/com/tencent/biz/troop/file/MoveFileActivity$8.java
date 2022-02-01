package com.tencent.biz.troop.file;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.protocol.TroopFileCreateFolderObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class MoveFileActivity$8
  extends TroopFileCreateFolderObserver
{
  MoveFileActivity$8(MoveFileActivity paramMoveFileActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TroopFileInfo paramTroopFileInfo)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131299166);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramTroopFileInfo);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839445);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755349);
      MoveFileActivity.a(this.a).i(paramTroopFileInfo);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", paramTroopFileInfo.b, "", "");
      QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131706914), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramTroopFileInfo = this.a.getString(2131696063);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
    case -313: 
      paramTroopFileInfo = this.a.getString(2131697358);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697533), null, this.a.jdField_a_of_type_JavaLangString, paramTroopFileInfo);
      return;
      paramTroopFileInfo = this.a.getString(2131697363);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      paramTroopFileInfo = this.a.getString(2131697361);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131697360);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131697364);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.8
 * JD-Core Version:    0.7.0.1
 */