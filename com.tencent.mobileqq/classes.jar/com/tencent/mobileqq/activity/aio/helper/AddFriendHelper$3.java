package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class AddFriendHelper$3
  implements ActionSheet.OnButtonClickListener
{
  AddFriendHelper$3(AddFriendHelper paramAddFriendHelper, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.a());
        paramView.putExtra("url", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        ReportController.b(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
      }
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
      paramView = new ArrayList();
    }
    try
    {
      paramView.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.a())));
      localObject = (IStrangerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStrangerService.class, "all");
      if (localObject != null) {
        ((IStrangerService)localObject).deleteStrangers(paramView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramView.jdField_a_of_type_AndroidContentContext, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAddFriendHelper.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (NumberFormatException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendHelper", 2, "delete Stranger parseLong() error", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.3
 * JD-Core Version:    0.7.0.1
 */