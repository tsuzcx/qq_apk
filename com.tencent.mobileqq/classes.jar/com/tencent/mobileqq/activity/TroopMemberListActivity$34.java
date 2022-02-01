package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$34
  implements View.OnClickListener
{
  TroopMemberListActivity$34(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Integer)localObject).intValue();
      if (i >= 0)
      {
        localObject = paramView.findViewById(2131379771);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (((View)localObject).getTag() != null)
        {
          bool1 = bool2;
          if ((((View)localObject).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject).getTag()).booleanValue();
          }
        }
        if (bool1)
        {
          localObject = (TroopMemberListActivity.ATroopMember)this.a.mSearchResultAdapter.getItem(i);
          this.a.doItemClick((TroopMemberListActivity.ATroopMember)localObject);
          if ((this.a.mSearchDialog != null) && (this.a.mSearchDialog.isShowing())) {
            this.a.mSearchDialog.dismiss();
          }
          if (this.a.mFrom == 11) {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
          }
        }
        else
        {
          localObject = (TroopMemberListActivity.ATroopMember)this.a.mAdapter.getItem(i);
          this.a.doItemClick((TroopMemberListActivity.ATroopMember)localObject);
          if (this.a.mFrom == 11) {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
          }
          if (this.a.mFrom == 18) {
            ReportController.b(this.a.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.mTroopUin, "", "", "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.34
 * JD-Core Version:    0.7.0.1
 */