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
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
    localIntent.putExtra("folderId", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
    int i = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity().getResources().getDimensionPixelSize(2131299168);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
      String str = Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a);
      if (MoveFileActivity.c(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).equals("/")) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
      QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 2, HardCodeUtil.a(2131706937), 0).b(i);
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(-1, localIntent);
    }
    else if (paramInt != -407)
    {
      if (paramInt != -406)
      {
        if ((paramInt != -302) && (paramInt != -301)) {
          if (paramInt != -136)
          {
            if (paramInt != -107)
            {
              if (paramInt == -103) {
                break label377;
              }
              if (paramInt != -102)
              {
                paramString = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getString(2131696078);
                QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, paramString, 0).b(i);
                this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
                break label520;
              }
            }
            QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706933), 0).b(i);
            this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
            break label520;
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
            QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706934), 0).b(i);
            this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
            break label520;
          }
        }
        label377:
        ReportController.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706930), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706929), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, HardCodeUtil.a(2131706931), 0).b(i);
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
    }
    label520:
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.finish();
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.overridePendingTransition(0, 2130772015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.2
 * JD-Core Version:    0.7.0.1
 */