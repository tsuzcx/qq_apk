package com.tencent.mobileqq.addfriend.ui;

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
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyFragment$3
  implements View.OnClickListener
{
  AddFriendVerifyFragment$3(AddFriendVerifyFragment paramAddFriendVerifyFragment, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity().getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getWindowToken(), 0);
      AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).clearFocus();
    }
    Object localObject;
    if (AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity(), 2131756189);
      ((Dialog)localObject).setContentView(2131562765);
      ((TextView)((Dialog)localObject).findViewById(2131365644)).setText(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131691105));
      ((ProgressBar)((Dialog)localObject).findViewById(2131367113)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131380236)).setImageResource(2130839590);
      ((Dialog)localObject).show();
    }
    else
    {
      localObject = AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getText().toString().trim();
      this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a((String)localObject, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131691954).equals(localObject)) && (!AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment))) {
        AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment;
      ((AddFriendVerifyFragment)localObject).a(AddFriendVerifyFragment.a((AddFriendVerifyFragment)localObject).getText().toString().trim());
      if (this.jdField_a_of_type_Int == 0) {
        ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.jdField_a_of_type_JavaLangString)) {
        ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.3
 * JD-Core Version:    0.7.0.1
 */