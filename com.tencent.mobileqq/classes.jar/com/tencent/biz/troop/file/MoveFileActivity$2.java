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
    this.b.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.f(this.b));
    localIntent.putExtra("folderId", this.a.c);
    int i = this.b.getActivity().getResources().getDimensionPixelSize(2131299920);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.b.app;
      String str = Long.toString(this.b.a);
      if (MoveFileActivity.g(this.b).equals("/")) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
      QQToast.makeText(this.b.getActivity(), 2, HardCodeUtil.a(2131904780), 0).show(i);
      this.b.setResult(-1, localIntent);
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
                paramString = this.b.getString(2131893843);
                QQToast.makeText(this.b.getActivity(), 1, paramString, 0).show(i);
                this.b.setResult(0, localIntent);
                break label520;
              }
            }
            QQToast.makeText(this.b.getActivity(), 1, HardCodeUtil.a(2131904776), 0).show(i);
            this.b.setResult(0, localIntent);
            break label520;
          }
          else
          {
            ReportController.b(this.b.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.b.a), "", "", "");
            QQToast.makeText(this.b.getActivity(), 1, HardCodeUtil.a(2131904777), 0).show(i);
            this.b.setResult(0, localIntent);
            break label520;
          }
        }
        label377:
        ReportController.b(this.b.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.b.a), "", "", "");
        QQToast.makeText(this.b.getActivity(), 1, HardCodeUtil.a(2131904773), 0).show(i);
        this.b.setResult(0, localIntent);
      }
      else
      {
        QQToast.makeText(this.b.getActivity(), 1, HardCodeUtil.a(2131904772), 0).show(i);
        this.b.setResult(0, localIntent);
      }
    }
    else
    {
      QQToast.makeText(this.b.getActivity(), 1, HardCodeUtil.a(2131904774), 0).show(i);
      this.b.setResult(0, localIntent);
    }
    label520:
    this.b.finish();
    this.b.overridePendingTransition(0, 2130772018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.2
 * JD-Core Version:    0.7.0.1
 */