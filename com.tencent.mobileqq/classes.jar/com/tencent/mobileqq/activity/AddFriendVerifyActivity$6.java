package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyActivity$6
  implements View.OnClickListener
{
  AddFriendVerifyActivity$6(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131756189);
      ((Dialog)localObject).setContentView(2131562765);
      ((TextView)((Dialog)localObject).findViewById(2131365644)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131691105));
      ((ProgressBar)((Dialog)localObject).findViewById(2131367113)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131380236)).setImageResource(2130839590);
      ((Dialog)localObject).show();
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a((String)localObject, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131691954).equals(localObject)) && (!AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity;
      ((AddFriendVerifyActivity)localObject).b(((AddFriendVerifyActivity)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
      if (this.jdField_a_of_type_Int == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.6
 * JD-Core Version:    0.7.0.1
 */