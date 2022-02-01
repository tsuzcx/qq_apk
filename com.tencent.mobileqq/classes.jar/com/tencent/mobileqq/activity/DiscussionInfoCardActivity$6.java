package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DiscussionInfoCardActivity$6
  implements ActionSheet.OnButtonClickListener
{
  DiscussionInfoCardActivity$6(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.b();
      continue;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.uin;
      Bundle localBundle = NewReportPlugin.a(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), "", "", paramView, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getCurrentAccountUin(), 22001, null, localBundle);
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, new String[] { DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a) });
      continue;
      DiscussionInfoCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.6
 * JD-Core Version:    0.7.0.1
 */