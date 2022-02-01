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
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity) == null) {
        ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, (ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
      }
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
      {
        paramView = ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
        boolean bool;
        if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
        {
          bool = true;
          label92:
          paramView.a(bool, true);
          if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            break label220;
          }
          paramInt = 2;
          label110:
          LpReportInfo_dc00518.report(100, paramInt, paramInt);
          if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            break label225;
          }
        }
        label220:
        label225:
        for (paramView = "QQnotice.aio.detail.seton";; paramView = "QQnotice.aio.detail.setoff")
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: " + paramView);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
          QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "remindpage_click", null, null, String.valueOf(1), String.valueOf(paramInt));
          break;
          bool = false;
          break label92;
          paramInt = 1;
          break label110;
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity != null)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getResources().getString(2131694459), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.6
 * JD-Core Version:    0.7.0.1
 */