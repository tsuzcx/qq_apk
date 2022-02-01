package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$5
  implements View.OnClickListener
{
  AddFriendVerifyFragment$5(AddFriendVerifyFragment paramAddFriendVerifyFragment, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyFragment.b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment);
    Object localObject = AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment, false);
    String str = AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getText().toString().trim();
    if ((str != null) && (localObject != null) && (!str.equals(localObject))) {
      ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a(str, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131691954).equals(str)) && (!AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment))) {
      AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) && (!this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg.equals(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getText().toString()))) {
        ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment;
    ((AddFriendVerifyFragment)localObject).a(AddFriendVerifyFragment.a((AddFriendVerifyFragment)localObject).getText().toString().trim(), null, "");
    ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_JavaLangString)) {
      ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a(this.jdField_a_of_type_Int, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.5
 * JD-Core Version:    0.7.0.1
 */