package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DiscussionInfoCardActivity$14
  implements ActionSheet.OnButtonClickListener
{
  DiscussionInfoCardActivity$14(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getActivity()))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X8006669", "0X8006669", 0, 0, "", "", "", "");
        DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).c(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity;
        paramView.a(paramView.getString(2131692086));
        DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).show();
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity;
        paramView.a(1, paramView.getString(2131694475));
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.14
 * JD-Core Version:    0.7.0.1
 */