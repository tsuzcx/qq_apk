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
import mqq.app.AppRuntime;

class MoveFileActivity$8
  extends TroopFileCreateFolderObserver
{
  MoveFileActivity$8(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, TroopFileInfo paramTroopFileInfo)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131299920);
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      MoveFileActivity.b(this.a).add(0, paramTroopFileInfo);
      MoveFileActivity.d(this.a, 0);
      MoveFileActivity.i(this.a).setEnabled(true);
      MoveFileActivity.i(this.a).setBackgroundResource(2130839481);
      MoveFileActivity.i(this.a).setTextAppearance(this.a.getActivity(), 2131952356);
      MoveFileActivity.h(this.a).j(paramTroopFileInfo);
      MoveFileActivity.j(this.a).notifyDataSetChanged();
      localObject = this.a.app;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, localStringBuilder.toString(), paramTroopFileInfo.c, "", "");
      QQToast.makeText(this.a.getActivity(), 2, HardCodeUtil.a(2131904779), 0).show(i);
      return;
    }
    if (paramInt != -405)
    {
      if (paramInt != -313)
      {
        if (paramInt != -303)
        {
          if (paramInt != -134)
          {
            if ((paramInt != -107) && (paramInt != -102))
            {
              paramTroopFileInfo = this.a.getString(2131893843);
              QQToast.makeText(this.a.getActivity(), 1, paramTroopFileInfo, 0).show(i);
              return;
            }
            paramTroopFileInfo = this.a.getString(2131895152);
            QQToast.makeText(this.a.getActivity(), 1, paramTroopFileInfo, 0).show(i);
            return;
          }
          paramTroopFileInfo = this.a.getString(2131895155);
          localObject = this.a.app;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.a);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, localStringBuilder.toString(), "1", "", "");
        }
        else
        {
          paramTroopFileInfo = this.a.getString(2131895156);
          QQToast.makeText(this.a.getActivity(), 1, paramTroopFileInfo, 0).show(i);
        }
      }
      else
      {
        paramTroopFileInfo = this.a.getString(2131895150);
        localObject = this.a.app;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.a);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, localStringBuilder.toString(), "1", "", "");
      }
      localObject = this.a;
      ((MoveFileActivity)localObject).a(((MoveFileActivity)localObject).getResources().getString(2131895312), null, this.a.b, paramTroopFileInfo);
      return;
    }
    paramTroopFileInfo = this.a.getString(2131895153);
    QQToast.makeText(this.a.getActivity(), 1, paramTroopFileInfo, 0).show(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.8
 * JD-Core Version:    0.7.0.1
 */