package com.tencent.mobileqq.addfriend.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$6
  implements View.OnClickListener
{
  AddFriendVerifyFragment$6(AddFriendVerifyFragment paramAddFriendVerifyFragment, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyFragment.b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment);
    Object localObject;
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity(), 0, this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131690017), 0).b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getQBaseActivity().getTitleBarHeight());
    }
    else if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity().getIntent().getStringExtra("extra");
      String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      int i = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity().getIntent().getIntExtra("sub_source_id", 0);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity().getIntent().getStringExtra("src_name");
      ((IFriendHandlerService)AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getRuntimeService(IFriendHandlerService.class, "")).requestAddFriend(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), (String)localObject, this.jdField_a_of_type_Int, (byte)0, str1, this.b, i, false, null, false, null, str2, this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity().getIntent().getBundleExtra("flc_extra_param"), true);
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getActivity(), 1, this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getString(2131694424), 0).b(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getQBaseActivity().getTitleBarHeight());
    }
    ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.b), String.valueOf(this.c), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a)) {
      ReportController.b(AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.a(this.b, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.6
 * JD-Core Version:    0.7.0.1
 */