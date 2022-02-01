package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$43
  implements View.OnClickListener
{
  TroopMemberListActivity$43(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f) && (!TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))) {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Int > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 3))
      {
        Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getIntent();
        localIntent.putExtra("member_uin", "0");
        localIntent.putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.setResult(-1, localIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 11) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, HardCodeUtil.a(2131715482), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
      continue;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, HardCodeUtil.a(2131715478), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.43
 * JD-Core Version:    0.7.0.1
 */