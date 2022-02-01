package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.regex.Matcher;

class AddFriendVerifyFragment$7
  implements View.OnClickListener
{
  AddFriendVerifyFragment$7(AddFriendVerifyFragment paramAddFriendVerifyFragment, StringBuffer paramStringBuffer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyFragment.b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment);
    Object localObject = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    int i = 0;
    while (i < AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).size())
    {
      String str = ((EditText)AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).get(i)).getText().toString().trim();
      if ("".equals(str))
      {
        i = 1;
        break label92;
      }
      localObject = ((String)localObject).replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str));
      i += 1;
    }
    i = 0;
    label92:
    if (i != 0) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity(), 0, this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131690017), 0).b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getQBaseActivity().getTitleBarHeight());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a((String)localObject, null, "");
    }
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a)) {
      ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a(this.jdField_a_of_type_Int, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.7
 * JD-Core Version:    0.7.0.1
 */