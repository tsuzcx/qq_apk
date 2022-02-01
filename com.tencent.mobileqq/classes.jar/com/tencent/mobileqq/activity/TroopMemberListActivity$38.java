package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopMemberListActivity$38
  implements View.OnClickListener
{
  TroopMemberListActivity$38(TroopMemberListActivity paramTroopMemberListActivity, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.e.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberMngHandlerName());
    if (localObject != null)
    {
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.e.mTroopUin), this.a, this.b.isChecked(), this.c);
      String str = this.e.mMyTroopRole;
      if (this.b.isChecked()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(this.e.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.e.mTroopUin, str, (String)localObject, "");
    }
    localObject = this.d;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.d.dismiss();
    }
    this.e.constructProgressDialog();
    this.e.mProgressDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.38
 * JD-Core Version:    0.7.0.1
 */