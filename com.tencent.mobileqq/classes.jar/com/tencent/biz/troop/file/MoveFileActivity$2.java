package com.tencent.biz.troop.file;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.troop.file.protocol.TroopFileMoveFileObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.widget.QQToast;

class MoveFileActivity$2
  extends TroopFileMoveFileObserver
{
  MoveFileActivity$2(MoveFileActivity paramMoveFileActivity, TroopFileInfo paramTroopFileInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
    localIntent.putExtra("folderId", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
    int i = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity().getResources().getDimensionPixelSize(2131299166);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
      String str = Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a);
      if (MoveFileActivity.c(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).equals("/"))
      {
        paramString = "0";
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 2, HardCodeUtil.a(2131706915), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.finish();
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.overridePendingTransition(0, 2130772003);
      return;
      paramString = "1";
      break;
      switch (paramInt)
      {
      default: 
        paramString = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getString(2131696063);
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, paramString, 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -302: 
      case -301: 
      case -103: 
        ReportController.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706908), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -136: 
        ReportController.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706912), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -107: 
      case -102: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706911), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -406: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706907), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -407: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706909), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.2
 * JD-Core Version:    0.7.0.1
 */