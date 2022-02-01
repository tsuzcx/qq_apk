package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;

class ActivateFriendActivity$6
  implements ActionSheet.OnButtonClickListener
{
  ActivateFriendActivity$6(ActivateFriendActivity paramActivateFriendActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity) == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity;
        ActivateFriendActivity.a(paramView, (ActivateFriendsManager)paramView.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
      }
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
      {
        ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity).a(ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity) ^ true, true);
        if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
          paramInt = 2;
        } else {
          paramInt = 1;
        }
        LpReportInfo_dc00518.report(100, paramInt, paramInt);
        if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
          paramView = "QQnotice.aio.detail.seton";
        } else {
          paramView = "QQnotice.aio.detail.setoff";
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("do report: ");
          localStringBuilder.append(paramView);
          QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
        QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "remindpage_click", null, null, String.valueOf(1), String.valueOf(paramInt));
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.isFinishing())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity;
        if (paramView != null) {
          QQToast.a(paramView, 1, paramView.getResources().getString(2131694424), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getTitleBarHeight());
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.6
 * JD-Core Version:    0.7.0.1
 */