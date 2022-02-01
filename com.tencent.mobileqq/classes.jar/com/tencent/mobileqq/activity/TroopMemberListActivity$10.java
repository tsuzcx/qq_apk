package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class TroopMemberListActivity$10
  implements View.OnClickListener
{
  TroopMemberListActivity$10(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mFrom == 15) && (TroopMemberListActivity.access$300(this.a).size() > 0))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("param_deleted_uins", TroopMemberListActivity.access$300(this.a));
      this.a.setResult(-1, (Intent)localObject);
      int i;
      if ((this.a.mTroopOwnerUin != null) && (this.a.mTroopOwnerUin.equals(this.a.app.getCurrentAccountUin()))) {
        i = 0;
      } else {
        i = 1;
      }
      localObject = this.a.app;
      String str = this.a.mTroopUin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, str, localStringBuilder.toString(), "1", TroopMemberListActivity.access$300(this.a).toString());
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.10
 * JD-Core Version:    0.7.0.1
 */