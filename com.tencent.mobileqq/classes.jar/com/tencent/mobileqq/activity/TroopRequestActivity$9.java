package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopRequestActivity$9
  implements ActionSheet.OnButtonClickListener
{
  TroopRequestActivity$9(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (NetworkUtil.d(BaseApplication.getContext())) {
      TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.u, "", "");
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2131694459, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.9
 * JD-Core Version:    0.7.0.1
 */