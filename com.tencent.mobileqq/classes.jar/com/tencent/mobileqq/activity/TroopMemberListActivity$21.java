package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class TroopMemberListActivity$21
  implements View.OnClickListener
{
  TroopMemberListActivity$21(TroopMemberListActivity paramTroopMemberListActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.c, TroopMemberListActivity.class);
    ((Intent)localObject).putExtra("troop_uin", this.c.mTroopUin);
    ((Intent)localObject).putExtra("param_from", 15);
    ((Intent)localObject).putExtra("param_seq_days", TroopMemberListActivity.access$1000(this.c));
    ((Intent)localObject).putExtra("param_seq_name", TroopMemberListActivity.access$1100(this.c));
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.a);
    this.c.startActivityForResult((Intent)localObject, 4);
    localObject = this.c.app;
    String str = this.c.mTroopUin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.b);
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, str, localStringBuilder.toString(), "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.21
 * JD-Core Version:    0.7.0.1
 */