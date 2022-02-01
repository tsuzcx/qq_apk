package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DiscussionInfoCardActivity$6
  implements ActionSheet.OnButtonClickListener
{
  DiscussionInfoCardActivity$6(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          DiscussionInfoCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
        }
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.uin;
        Bundle localBundle = NewReportPlugin.a(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
        DiscussionInfoCardActivity localDiscussionInfoCardActivity = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity;
        NewReportPlugin.a(localDiscussionInfoCardActivity, DiscussionInfoCardActivity.a(localDiscussionInfoCardActivity), "", "", paramView, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getCurrentAccountUin(), 22001, null, localBundle);
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, new String[] { DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a) });
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.b();
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((paramView != null) && (paramView.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.isFinishing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.6
 * JD-Core Version:    0.7.0.1
 */