package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
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
    if ((!TroopMemberListActivity.c(this.a)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.a.e) {
        if (paramInt == 0) {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopMemberListActivity.28.1(this), 320L);
        }
      }
      for (;;)
      {
        if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.a.jdField_b_of_type_JavaLangString);
          continue;
          if (this.a.d == 9) {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.c = true;
              this.a.t = "";
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.jdField_b_of_type_JavaLangString, this.a.n, "", "");
              break;
            }
          } else {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.l();
              break;
            case 1: 
              if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
              {
                paramView = new Intent(this.a, SelectMemberActivity.class);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("group_uin", this.a.jdField_b_of_type_JavaLangString);
                paramView.putExtra("param_groupcode", this.a.jdField_a_of_type_JavaLangString);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("param_subtype", 4);
                paramView.putExtra("param_entrance", 30);
                paramView.putExtra("param_max", 30);
                paramView.putExtra("param_exit_animation", 3);
                this.a.startActivity(paramView);
                this.a.overridePendingTransition(2130771999, 0);
                ReportController.b(this.a.app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.jdField_b_of_type_JavaLangString, "", "", "");
              }
              break;
            case 2: 
              this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopMemberListActivity.28.2(this), 320L);
              break;
            case 3: 
              this.a.n();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.28
 * JD-Core Version:    0.7.0.1
 */