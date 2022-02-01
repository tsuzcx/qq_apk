package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopMemberListActivity$28
  implements ActionSheet.OnButtonClickListener
{
  TroopMemberListActivity$28(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i;
    if ((!TroopMemberListActivity.access$1700(this.a)) && (paramInt >= 5)) {
      i = paramInt + 1;
    } else {
      i = paramInt;
    }
    if (this.a.mIsQidianPrivateTroop)
    {
      if (paramInt == 0)
      {
        this.a.mHandler.postDelayed(new TroopMemberListActivity.28.1(this), 320L);
      }
      else if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mOnActionSheetClickListener.OnClick, error : which = ");
        paramView.append(paramInt);
        paramView.append(", troopUin = ");
        paramView.append(this.a.mTroopUin);
        QLog.d("TroopMemberListActivityget_troop_member", 2, paramView.toString());
      }
    }
    else if (this.a.mFrom == 9)
    {
      if (i == 0)
      {
        paramView = this.a;
        paramView.mIsInDeleteState = true;
        paramView.mSlideLeftUin = "";
        paramView.mRightManageBtn.setVisibility(0);
        this.a.mTitleRightImgBtn.setVisibility(8);
        this.a.mTitleSortImgBtn.setVisibility(8);
        if (this.a.mAdapter != null) {
          this.a.mAdapter.a();
        }
        ReportController.b(this.a.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.mTroopUin, this.a.mMyTroopRole, "", "");
      }
    }
    else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.a.delTroopMember();
          }
        }
        else {
          this.a.mHandler.postDelayed(new TroopMemberListActivity.28.2(this), 320L);
        }
      }
      else if (!TextUtils.isEmpty(this.a.mTroopCode))
      {
        paramView = new Intent();
        paramView.putExtra("param_from", 30);
        paramView.putExtra("group_uin", this.a.mTroopUin);
        paramView.putExtra("param_groupcode", this.a.mTroopCode);
        paramView.putExtra("param_from", 30);
        paramView.putExtra("param_subtype", 4);
        paramView.putExtra("param_entrance", 30);
        paramView.putExtra("param_max", 30);
        paramView.putExtra("param_exit_animation", 3);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.a.app.getApplicationContext(), paramView);
        this.a.overridePendingTransition(2130772011, 0);
        ReportController.b(this.a.app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.mTroopUin, "", "", "");
      }
    }
    else {
      this.a.showMemberDstribute();
    }
    if ((this.a.mActionSheet != null) && (this.a.mActionSheet.isShowing())) {
      this.a.mActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.28
 * JD-Core Version:    0.7.0.1
 */