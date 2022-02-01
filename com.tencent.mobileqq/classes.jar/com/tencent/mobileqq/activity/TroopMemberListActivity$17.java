package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$17
  implements View.OnClickListener
{
  TroopMemberListActivity$17(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mCanAtAll) && (!TroopMemberListActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mFrom == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mDiscRemainCout > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mFrom == 3))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getIntent();
        ((Intent)localObject).putExtra("member_uin", "0");
        ((Intent)localObject).putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.setResult(-1, (Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mFrom == 11) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, HardCodeUtil.a(2131715408), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mTitleBar.getHeight());
      }
    }
    else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mNoAtAllRemainTips))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      QQToast.a((Context)localObject, ((TroopMemberListActivity)localObject).mNoAtAllRemainTips, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mTitleBar.getHeight());
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, HardCodeUtil.a(2131715368), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mTitleBar.getHeight());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.17
 * JD-Core Version:    0.7.0.1
 */