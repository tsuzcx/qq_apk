package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$9
  implements View.OnClickListener
{
  AddFriendVerifyActivity$9(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    Object localObject;
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity;
      QQToast.a((Context)localObject, 0, ((AddFriendVerifyActivity)localObject).getString(2131690017), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
    }
    else if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("extra");
      String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("sub_source_id", 0);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("src_name");
      ((IFriendHandlerService)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), (String)localObject, this.jdField_a_of_type_Int, (byte)0, str1, this.b, i, false, null, false, null, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getBundleExtra("flc_extra_param"), true);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity;
      QQToast.a((Context)localObject, 1, ((AddFriendVerifyActivity)localObject).getString(2131694424), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.b), String.valueOf(this.c), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.b, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.9
 * JD-Core Version:    0.7.0.1
 */